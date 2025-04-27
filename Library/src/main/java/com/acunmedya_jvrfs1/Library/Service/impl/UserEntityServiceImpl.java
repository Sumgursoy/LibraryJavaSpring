package com.acunmedya_jvrfs1.Library.Service.impl;

import com.acunmedya_jvrfs1.Library.Service.UserEntityService;
import com.acunmedya_jvrfs1.Library.Service.dtos.UserEntityRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.UserEntityResponse;
import com.acunmedya_jvrfs1.Library.entity.UserEntity;
import com.acunmedya_jvrfs1.Library.Repository.userEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    @Autowired
    private userEntityRepository userEntityRepository;

    @Override
    public UserEntityResponse add(UserEntityRequest request) {
        UserEntity userEntity = new UserEntity();
        mapRequestToEntity(request, userEntity);
        UserEntity savedEntity = userEntityRepository.save(userEntity);
        return mapEntityToResponse(savedEntity);
    }

    @Override
    public UserEntityResponse update(int id, UserEntityRequest request) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        mapRequestToEntity(request, userEntity);
        UserEntity updatedEntity = userEntityRepository.save(userEntity);
        return mapEntityToResponse(updatedEntity);
    }

    @Override
    public void delete(int id) {
        userEntityRepository.deleteById(id);
    }

    @Override
    public UserEntityResponse getById(int id) {
        UserEntity userEntity = userEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return mapEntityToResponse(userEntity);
    }

    @Override
    public List<UserEntityResponse> getAll() {
        return userEntityRepository.findAll().stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    private void mapRequestToEntity(UserEntityRequest request, UserEntity entity) {
        entity.setUsername(request.getUsername());
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setNationalIdentity(request.getNationalIdentity());
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
    }

    private UserEntityResponse mapEntityToResponse(UserEntity entity) {
        UserEntityResponse response = new UserEntityResponse();
        response.setId(entity.getId());
        response.setUsername(entity.getUsername());
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setDateOfBirth(entity.getDateOfBirth());
        response.setNationalIdentity(entity.getNationalIdentity());
        response.setEmail(entity.getEmail());
        response.setPassword(entity.getPassword());
        return response;
    }
} 