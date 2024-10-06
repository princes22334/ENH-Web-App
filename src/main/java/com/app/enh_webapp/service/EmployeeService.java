package com.app.enh_webapp.service;

import com.app.enh_webapp.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(Long companyId, EmployeeDto dto);

    List<EmployeeDto> getAllEmployee(int pageNo, int pageSize);

    EmployeeDto getEmployeeById(Long id);
}
