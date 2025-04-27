package com.acunmedya_jvrfs1.Library.Service;

import com.acunmedya_jvrfs1.Library.Service.dtos.InstructorRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.InstructorResponse;

import java.util.List;

public interface InstructorService {
    InstructorResponse add(InstructorRequest request);
    InstructorResponse update(int id, InstructorRequest request);
    void delete(int id);
    InstructorResponse getById(int id);
    List<InstructorResponse> getAll();
} 