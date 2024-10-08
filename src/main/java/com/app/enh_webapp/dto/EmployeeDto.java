package com.app.enh_webapp.dto;

import com.app.enh_webapp.entity.Access;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String employeeNumber;
    private String status;
    private String phoneNumber;
    private String CompanyName;
    private Set<AccessDto> accesses;
}
