package com.app.enh_webapp.controller;

import com.app.enh_webapp.dto.CompanyDto;
import com.app.enh_webapp.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createCompanyUnit(@RequestBody CompanyDto dto) {
        return new ResponseEntity<>(companyService.createCompany(dto), HttpStatus.CREATED);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id){
        return new ResponseEntity<>(companyService.getCompanyById(id), HttpStatus.OK);
    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDto>> getAllCompany(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                                          @RequestParam(defaultValue = "0", required = false) int pageSize){
        return new ResponseEntity<>(companyService.getAllCompany(pageNo, pageSize), HttpStatus.OK);
    }

}
