package com.app.enh_webapp.controller;

import com.app.enh_webapp.dto.EmployeeDto;
import com.app.enh_webapp.service.EmployeeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/company/{id}/employee")
    public ResponseEntity<EmployeeDto> createEmployee(@PathVariable Long id,
                                                      @RequestBody EmployeeDto dto){
        return new ResponseEntity<>(employeeService.createEmployee(id, dto), HttpStatus.CREATED);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                                            @RequestParam(defaultValue = "10", required = false) int pageSize){
        return new ResponseEntity<>(employeeService.getAllEmployee(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long id,
                                                          @RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(employeeService.updateEmployeeById(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee ID: "+id+" Successfully Deleted", HttpStatus.OK);
    }
}
