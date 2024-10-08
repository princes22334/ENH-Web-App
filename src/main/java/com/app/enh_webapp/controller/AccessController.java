package com.app.enh_webapp.controller;

import com.app.enh_webapp.dto.AccessDto;
import com.app.enh_webapp.service.AccessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccessController {

    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping("/employee/{id}/access")
    public ResponseEntity<AccessDto> createAccessByEmployeeId(@PathVariable Long id,
                                                             @RequestBody AccessDto dto){
        return new ResponseEntity<>(accessService.createAccessForEmployeeById(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{employeeId}/access/{accessId}")
    public ResponseEntity<String> removeAccessForEmployeeById(@PathVariable Long employeeId,
                                                                      @PathVariable Long accessId) {
        accessService.removeAccessForEmployeeById(employeeId, accessId);
        return new ResponseEntity<>(("Access Successfully Removed for Employee ID: "+employeeId), HttpStatus.OK);
    }
}
