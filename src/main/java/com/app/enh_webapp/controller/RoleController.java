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
    public List<RoleDto> getAllRoles(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                    @RequestParam(defaultValue = "10", required = false) int pageSize){
        return roleService.getAllRoles(pageNo, pageSize);
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable Long roleId){
        return new ResponseEntity<>(roleService.getRoleById(roleId), HttpStatus.OK);
    }

    @PutMapping("/role/{roleId}")
    public ResponseEntity<RoleDto> updateRoleById(@PathVariable Long roleId,
                                                  @RequestBody RoleDto dto){
        return new ResponseEntity<>(roleService.updateRoleById(roleId, dto), HttpStatus.OK);
    }

    @DeleteMapping("/role/{roleId}")
    public ResponseEntity<String> deleteRoleById(@PathVariable Long roleId){
        roleService.deleteRoleById(roleId);
        return new ResponseEntity<>(("Role with ID:"+roleId+" deleted Successfully"), HttpStatus.OK);
    }
}
