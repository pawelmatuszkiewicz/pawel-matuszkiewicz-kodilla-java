package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Bread");
        Product product2 = new Product("Sugar");
        Item item1 = new Item(product1, new BigDecimal(2.5), 10);
        product1.getItems().add(item1);
        Item item2 = new Item(product2, new BigDecimal(3), 3);
        product2.getItems().add(item2);
        Invoice invoice = new Invoice("2018/04/0001");
        invoice.getItems().add(item1);
        item1.setInvoice(invoice);
        invoice.getItems().add(item2);
        item2.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        Invoice readInvoice = invoiceDao.findOne(id);

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertEquals(id, readInvoice.getId());

        //CleanUp
        invoiceDao.delete(id);
    }
}
