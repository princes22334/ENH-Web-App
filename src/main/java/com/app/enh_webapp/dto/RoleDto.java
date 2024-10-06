package com.app.enh_webapp.dto;


import com.app.enh_webapp.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private Long id;
    private String technicalName;
    private String roleName;
    private String description;

}
