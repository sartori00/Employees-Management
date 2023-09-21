package br.com.sartori.employeesmanagement.adapters.in.controller;

import br.com.sartori.employeesmanagement.adapters.in.controller.dto.request.EmployeeRequest;
import br.com.sartori.employeesmanagement.adapters.in.controller.dto.response.EmployeeResponse;
import br.com.sartori.employeesmanagement.adapters.in.controller.mapper.EmployeesMapper;
import br.com.sartori.employeesmanagement.application.ports.in.InsertEmployeeInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeesMapper employeesMapper;

    @Autowired
    InsertEmployeeInputPort insertEmployeeInputPort;

    @PostMapping
    public ResponseEntity<EmployeeResponse> insert(@RequestBody @Valid EmployeeRequest request){
        var employee = insertEmployeeInputPort.insert(employeesMapper.toEmployee(request));
        return ResponseEntity.ok().body(new EmployeeResponse(employee));
    }
}
