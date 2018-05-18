package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<CompanyDto> retrieveCompaniesWithSubstring(String substring) {
        List<Company> companies = companyDao.retrieveCompaniesWithSubstring(substring);
        List<CompanyDto> resultList = new ArrayList<>();
        for (Company company : companies) {
            resultList.add(new CompanyDto(company.getId(), company.getName()));
        }
        return resultList;
    }

    public List<EmployeeDto> retrieveEmployeesWithSubstring(String substring) {
        List<Employee> employees = employeeDao.retrieveEmployeesWithSubstring(substring);
        List<EmployeeDto> resultList = new ArrayList<>();
        for (Employee employee : employees) {
            resultList.add(new EmployeeDto(
                    employee.getId(),
                    employee.getFirstname(),
                    employee.getLastname())
            );
        }
        return resultList;
    }
}
