package com.app.enh_webapp.service.impl;

import com.app.enh_webapp.dto.RoleDto;
import com.app.enh_webapp.entity.Company;
import com.app.enh_webapp.entity.Role;
import com.app.enh_webapp.exception.ResourceNotFoundException;
import com.app.enh_webapp.repository.CompanyRepository;
import com.app.enh_webapp.repository.RoleRepository;
import com.app.enh_webapp.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<RoleDto> getAllRoles(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Role> roles = roleRepository.findAll(pageable);
       return roles.stream().map(role -> convertToDto(role)).collect(Collectors.toList());
    }

    @Override
    public RoleDto getRoleById(Long roleId) {
       Role role = roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Invalid Input! Role id doesn't Exist"));
        return convertToDto(role);
    }

    @Override
    public RoleDto updateRoleById(Long roleId, RoleDto dto) {
       Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Input! Role id doesn't Exist"));
        role.setId(dto.getId());
        role.setTechnicalName(dto.getRoleName());
        role.setRoleName(dto.getRoleName());
        role.setDescription(dto.getDescription());
      Role savedRole =  roleRepository.save(role);
        return convertToDto(savedRole);
    }

    @Override
    public void deleteRoleById(Long roleId) {
        roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Input! Role id doesn't Exist"));
        roleRepository.deleteById(roleId);
    }

    public RoleDto convertToDto(Role role){
        return modelMapper.map(role, RoleDto.class);
    }

    public Role convertToEntity(RoleDto dto){
        return modelMapper.map(dto, Role.class);
    }
}
