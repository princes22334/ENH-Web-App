package com.app.enh_webapp.service;

import com.app.enh_webapp.dto.AccessDto;

public interface AccessService {

    AccessDto createAccessForEmployeeById(Long id, AccessDto dto);

    void removeAccessForEmployeeById(Long employeeId, Long accessId);
}
