package com.app.enh_webapp.controller;

import com.app.enh_webapp.dto.RoleDto;
import com.app.enh_webapp.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/company/{id}/roles")
    public ResponseEntity<RoleDto> createRole(@PathVariable Long id,
                                              @RequestBody RoleDto dto){
        return new ResponseEntity<>(roleService.createRole(id, dto), HttpStatus.CREATED);
    }
    @GetMapping("/roles")
    public List<RoleDto> getAllRoles(){
        return roleService.getAllRoles();
    }
}
