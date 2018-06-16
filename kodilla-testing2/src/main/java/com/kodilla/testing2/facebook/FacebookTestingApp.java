package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_BIRTHDAY = "//span[@class=\"_5k_4\" and @data-name=\"birthday_wrapper\"]/span/select[1]";
    public static final String XPATH_BIRTHMONTH = "//span[@class=\"_5k_4\" and @data-name=\"birthday_wrapper\"]/span/select[2]";
    public static final String XPATH_BIRTHYEAR = "//span[@class=\"_5k_4\" and @data-name=\"birthday_wrapper\"]/span/select[3]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com");

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_BIRTHDAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(9);

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_BIRTHMONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(9);

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_BIRTHYEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByIndex(20);

    }
}
