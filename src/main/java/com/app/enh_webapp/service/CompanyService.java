package com.app.enh_webapp.service;

import com.app.enh_webapp.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    CompanyDto createCompany(CompanyDto dto);

    CompanyDto getCompanyById(Long companyId);

    List<CompanyDto> getAllCompany(int pageNo, int pageSize);
}
