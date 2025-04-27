package com.acunmedya_jvrfs1.Library.Service;

import com.acunmedya_jvrfs1.Library.Service.dtos.EmployeeRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse add(EmployeeRequest request);
    EmployeeResponse update(int id, EmployeeRequest request);
    void delete(int id);
    EmployeeResponse getById(int id);
    List<EmployeeResponse> getAll();
} 