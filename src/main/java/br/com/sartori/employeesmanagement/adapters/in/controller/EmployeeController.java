package br.com.sartori.employeesmanagement.adapters.in.controller;

import br.com.sartori.employeesmanagement.adapters.in.controller.dto.request.EmployeeRequest;
import br.com.sartori.employeesmanagement.adapters.in.controller.dto.response.EmployeeResponse;
import br.com.sartori.employeesmanagement.adapters.in.controller.mapper.EmployeesMapper;
import br.com.sartori.employeesmanagement.application.core.domain.Employee;
import br.com.sartori.employeesmanagement.application.ports.in.FindEmployeeByIdInputPort;
import br.com.sartori.employeesmanagement.application.ports.in.InsertEmployeeInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeesMapper employeesMapper;

    @Autowired
    InsertEmployeeInputPort insertEmployeeInputPort;

    @Autowired
    FindEmployeeByIdInputPort findEmployeeByIdInputPort;

    @PostMapping
    public ResponseEntity<EmployeeResponse> insert(@RequestBody @Valid EmployeeRequest request){
        var employee = insertEmployeeInputPort.insert(employeesMapper.toEmployee(request));
        return ResponseEntity.ok().body(new EmployeeResponse(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> findById(@PathVariable("id") final Integer id) {
        var employee = findEmployeeByIdInputPort.findById(id);
        return ResponseEntity.ok().body(new EmployeeResponse(employee));
    }
}
