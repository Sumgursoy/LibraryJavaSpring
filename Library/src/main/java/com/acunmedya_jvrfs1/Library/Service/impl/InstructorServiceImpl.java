package com.acunmedya_jvrfs1.Library.Service.impl;

import com.acunmedya_jvrfs1.Library.Service.InstructorService;
import com.acunmedya_jvrfs1.Library.Service.dtos.InstructorRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.InstructorResponse;
import com.acunmedya_jvrfs1.Library.entity.Instructer;
import com.acunmedya_jvrfs1.Library.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public InstructorResponse add(InstructorRequest request) {
        Instructer instructor = new Instructer();
        mapRequestToEntity(request, instructor);
        Instructer savedEntity = instructorRepository.save(instructor);
        return mapEntityToResponse(savedEntity);
    }

    @Override
    public InstructorResponse update(int id, InstructorRequest request) {
        Instructer instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
        mapRequestToEntity(request, instructor);
        Instructer updatedEntity = instructorRepository.save(instructor);
        return mapEntityToResponse(updatedEntity);
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public InstructorResponse getById(int id) {
        Instructer instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found with id: " + id));
        return mapEntityToResponse(instructor);
    }

    @Override
    public List<InstructorResponse> getAll() {
        return instructorRepository.findAll().stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    private void mapRequestToEntity(InstructorRequest request, Instructer entity) {
        entity.setUsername(request.getUsername());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setNationalIdentity(request.getNationalIdentity());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        entity.setCompanyName(request.getCompanyName());
    }

    private InstructorResponse mapEntityToResponse(Instructer entity) {
        InstructorResponse response = new InstructorResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setDateOfBirth(entity.getDateOfBirth());
        response.setNationalIdentity(entity.getNationalIdentity());
        response.setEmail(entity.getEmail());
        response.setPassword(entity.getPassword());
        response.setCompanyName(entity.getCompanyName());
        return response;
    }
} 