package com.acunmedya_jvrfs1.Library.Service.impl;

import com.acunmedya_jvrfs1.Library.Service.EmployeeService;
import com.acunmedya_jvrfs1.Library.Service.dtos.EmployeeRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.EmployeeResponse;
import com.acunmedya_jvrfs1.Library.entity.Employee;
import com.acunmedya_jvrfs1.Library.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse add(EmployeeRequest request) {
        Employee employee = new Employee();
        mapRequestToEntity(request, employee);
        Employee savedEntity = employeeRepository.save(employee);
        return mapEntityToResponse(savedEntity);
    }

    @Override
    public EmployeeResponse update(int id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        mapRequestToEntity(request, employee);
        Employee updatedEntity = employeeRepository.save(employee);
        return mapEntityToResponse(updatedEntity);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return mapEntityToResponse(employee);
    }

    @Override
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    private void mapRequestToEntity(EmployeeRequest request, Employee entity) {
        entity.setUsername(request.getUsername());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setNationalIdentity(request.getNationalIdentity());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        entity.setPosition(request.getPosition());
    }

    private EmployeeResponse mapEntityToResponse(Employee entity) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setDateOfBirth(entity.getDateOfBirth());
        response.setNationalIdentity(entity.getNationalIdentity());
        response.setEmail(entity.getEmail());
        response.setPassword(entity.getPassword());
        response.setPosition(entity.getPosition());
        return response;
    }
} 