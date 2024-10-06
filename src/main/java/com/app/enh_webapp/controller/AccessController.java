package com.app.enh_webapp.controller;

import com.app.enh_webapp.dto.AccessDto;
import com.app.enh_webapp.service.impl.AccessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
}
