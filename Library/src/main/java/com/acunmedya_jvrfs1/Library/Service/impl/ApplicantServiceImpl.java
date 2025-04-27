package com.acunmedya_jvrfs1.Library.Service.impl;

import com.acunmedya_jvrfs1.Library.Service.ApplicantService;
import com.acunmedya_jvrfs1.Library.Service.dtos.ApplicantRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.ApplicantResponse;
import com.acunmedya_jvrfs1.Library.entity.Applicant;
import com.acunmedya_jvrfs1.Library.Repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public ApplicantResponse add(ApplicantRequest request) {
        Applicant applicant = new Applicant();
        mapRequestToEntity(request, applicant);
        Applicant savedEntity = applicantRepository.save(applicant);
        return mapEntityToResponse(savedEntity);
    }

    @Override
    public ApplicantResponse update(int id, ApplicantRequest request) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + id));
        mapRequestToEntity(request, applicant);
        Applicant updatedEntity = applicantRepository.save(applicant);
        return mapEntityToResponse(updatedEntity);
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public ApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + id));
        return mapEntityToResponse(applicant);
    }

    @Override
    public List<ApplicantResponse> getAll() {
        return applicantRepository.findAll().stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    private void mapRequestToEntity(ApplicantRequest request, Applicant entity) {
        entity.setUsername(request.getUsername());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setNationalIdentity(request.getNationalIdentity());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        entity.setAbout(request.getAbout());
    }

    private ApplicantResponse mapEntityToResponse(Applicant entity) {
        ApplicantResponse response = new ApplicantResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setDateOfBirth(entity.getDateOfBirth());
        response.setNationalIdentity(entity.getNationalIdentity());
        response.setEmail(entity.getEmail());
        response.setPassword(entity.getPassword());
        response.setAbout(entity.getAbout());
        return response;
    }
} 