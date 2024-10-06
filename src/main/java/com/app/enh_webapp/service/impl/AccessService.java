package com.app.enh_webapp.service.impl;

import com.app.enh_webapp.dto.AccessDto;

public interface AccessService {

    AccessDto createAccessForEmployeeById(Long id, AccessDto dto);
}
