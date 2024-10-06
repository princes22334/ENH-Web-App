package com.app.enh_webapp.service.impl;

import com.app.enh_webapp.dto.CompanyDto;
import com.app.enh_webapp.entity.Company;
import com.app.enh_webapp.exception.ResourceNotFoundException;
import com.app.enh_webapp.repository.CompanyRepository;
import com.app.enh_webapp.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper mapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public CompanyDto createCompany(CompanyDto dto) {
        Company company = companyRepository.save(convertToEntity(dto));
        return convertToDto(company);
    }

    @Override
    public CompanyDto getCompanyById(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ResourceNotFoundException("Company ID doesn't Exists"));
        return convertToDto(company);
    }

    @Override
    public List<CompanyDto> getAllCompany(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Company> all = companyRepository.findAll(pageable);
        return all.stream().map(company -> convertToDto(company)).collect(Collectors.toList());
    }

    public CompanyDto convertToDto(Company company){
        return mapper.map(company, CompanyDto.class);
    }

    public Company convertToEntity(CompanyDto dto){
        return mapper.map(dto, Company.class);
    }
}
