package com.app.enh_webapp.service.impl;

import com.app.enh_webapp.dto.AccessDto;
import com.app.enh_webapp.entity.Access;
import com.app.enh_webapp.entity.Company;
import com.app.enh_webapp.entity.Employee;
import com.app.enh_webapp.entity.Role;
import com.app.enh_webapp.exception.ResourceNotFoundException;
import com.app.enh_webapp.repository.AccessRepository;
import com.app.enh_webapp.repository.CompanyRepository;
import com.app.enh_webapp.repository.EmployeeRepository;
import com.app.enh_webapp.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl implements AccessService {
    private final AccessRepository accessRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    public AccessServiceImpl(AccessRepository accessRepository, EmployeeRepository employeeRepository, CompanyRepository companyRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.accessRepository = accessRepository;
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public AccessDto createAccessForEmployeeById(Long id, AccessDto dto) {
        // Check if Employee is present or not
        Employee employee = employeeRepository
                .findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Id doesn't exist"));

        // Retrieving all roles to check
        List<Role> roles = roleRepository.findAll();
        for (Role role : roles) {
            if (role.getTechnicalName().equals(dto.getAccessName())) {
                // Checking if access is already present
                List<Access> accessList = accessRepository.findAll();
                boolean accessExists = false;
                for (Access access1 : accessList) {
                    if (access1.getEmployeeName().equals(employee.getName()) && access1.getAccessName().equals(dto.getAccessName())) {
                        accessExists = true;
                        break;
                    }
                }

                if (accessExists) {
                    throw new ResourceNotFoundException("Access is already present with Employee " + employee.getName());
                } else {
                    // Retrieving role company
                    Company company = role.getCompany();
                    Access writingAccess = convertToEntity(dto);
                    writingAccess.setRoleCompany(company.getCompanyName());
                    //writingAccess.setEmployee(employee);
                    writingAccess.setEmployeeName(employee.getName());
                    writingAccess.setEmployee(employee);
                    return convertToDto(accessRepository.save(writingAccess));
                }
            }
        }
        throw new ResourceNotFoundException("Given Access doesn't exist");
    }

//    public AccessDto convertToDto(Access access) {
//        AccessDto dto = new AccessDto();
//        dto.setAccessName(access.getAccessName());
//        //dto.setEmployeeName(access.getEmployeeName());
//        dto.setRoleCompany(access.getRoleCompany());
//        return dto;
//    }
    public AccessDto convertToDto(Access access) {
        return modelMapper.map(access, AccessDto.class);
    }

//    public Access convertToEntity(AccessDto dto) {
//        Access access = new Access();
//        access.setAccessName(dto.getAccessName());
//        return access;
//    }
    public Access convertToEntity(AccessDto dto) {
        return modelMapper.map(dto, Access.class);

    }
}
