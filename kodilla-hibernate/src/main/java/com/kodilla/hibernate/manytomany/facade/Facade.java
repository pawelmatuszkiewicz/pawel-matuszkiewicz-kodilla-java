package com.kodilla.hibernate.manytomany.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    @Autowired
    SearchService searchService;

    public List<CompanyDto> getCompaniesWithSubstring(String substring) {
        return searchService.retrieveCompaniesWithSubstring(substring);
    }

    public List<EmployeeDto> getEmployeesWithSubstring(String substring) {
        return searchService.retrieveEmployeesWithSubstring(substring);
    }
}
