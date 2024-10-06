package com.app.enh_webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long id;
    private String companyId;
    private String companyName;
    private String location;
    private List<RoleDto> roles;
    private Set<EmployeeDto> employees;
}
