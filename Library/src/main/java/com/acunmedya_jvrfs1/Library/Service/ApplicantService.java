package com.acunmedya_jvrfs1.Library.Service;

import com.acunmedya_jvrfs1.Library.Service.dtos.ApplicantRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.ApplicantResponse;

import java.util.List;

public interface ApplicantService {
    ApplicantResponse add(ApplicantRequest request);
    ApplicantResponse update(int id, ApplicantRequest request);
    void delete(int id);
    ApplicantResponse getById(int id);
    List<ApplicantResponse> getAll();
} 