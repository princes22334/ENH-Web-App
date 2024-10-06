package com.app.enh_webapp.service.impl;

import com.app.enh_webapp.dto.RoleDto;
import com.app.enh_webapp.entity.Company;
import com.app.enh_webapp.entity.Role;
import com.app.enh_webapp.exception.ResourceNotFoundException;
import com.app.enh_webapp.repository.CompanyRepository;
import com.app.enh_webapp.repository.RoleRepository;
import com.app.enh_webapp.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleDto createRole(Long companyId, RoleDto dto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ResourceNotFoundException("Company ID:"+companyId+" doesn't exist"));
        Role role = convertToEntity(dto);
        role.setCompany(company);
        return convertToDto(roleRepository.save(role));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
       return roles.stream().map(role -> convertToDto(role)).collect(Collectors.toList());
    }

    public RoleDto convertToDto(Role role){
        return modelMapper.map(role, RoleDto.class);
    }

    public Role convertToEntity(RoleDto dto){
        return modelMapper.map(dto, Role.class);
    }
}
