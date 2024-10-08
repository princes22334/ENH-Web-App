package com.app.enh_webapp.service.impl;

import com.app.enh_webapp.dto.EmployeeDto;
import com.app.enh_webapp.entity.Company;
import com.app.enh_webapp.entity.Employee;
import com.app.enh_webapp.exception.ResourceNotFoundException;
import com.app.enh_webapp.repository.CompanyRepository;
import com.app.enh_webapp.repository.EmployeeRepository;
import com.app.enh_webapp.repository.RoleRepository;
import com.app.enh_webapp.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto createEmployee(Long companyId, EmployeeDto dto) {
       Company company = companyRepository
               .findById(companyId).orElseThrow(()-> new ResourceNotFoundException("Company Id doesn't Exists"));
        Employee employee = convertToEntity(dto);
        employee.getAccesses();
        employee.setCompany(company);
        employee.setCompanyName(company.getCompanyName());
        Employee saved = employeeRepository.save(employee);
        return convertToDto(saved);
    }

    @Override
    public List<EmployeeDto> getAllEmployee(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> all = employeeRepository.findAll(pageable);

        List<EmployeeDto> collect = all.stream().map(employee -> convertToDto(employee)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Input! ID doesn't exists"));
        return convertToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto dto) {
       Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Input! Employee Id doesn't Exist"));

        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setDepartment(dto.getDepartment());
        employee.setEmployeeNumber(dto.getEmployeeNumber());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setStatus(dto.getStatus());
        employee.setPhoneNumber(dto.getPhoneNumber());

        Employee updatedEmployee = employeeRepository.save(employee);
        return convertToDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Input! Employee Id doesn't Exist"));
        employeeRepository.deleteById(id);
    }


    public EmployeeDto convertToDto(Employee employee){
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee convertToEntity(EmployeeDto dto){
        return modelMapper.map(dto, Employee.class);
    }
}
