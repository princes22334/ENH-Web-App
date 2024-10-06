package com.app.enh_webapp.service;

import com.app.enh_webapp.dto.RoleDto;

import java.util.List;

public interface RoleService {

    RoleDto createRole(Long companyId, RoleDto dto);

    List<RoleDto> getAllRoles();
}
