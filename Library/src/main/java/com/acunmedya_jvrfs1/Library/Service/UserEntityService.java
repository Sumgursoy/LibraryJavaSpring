package com.acunmedya_jvrfs1.Library.Service;

import com.acunmedya_jvrfs1.Library.Service.dtos.UserEntityRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.UserEntityResponse;

import java.util.List;

public interface UserEntityService {
    UserEntityResponse add(UserEntityRequest request);
    UserEntityResponse update(int id, UserEntityRequest request);
    void delete(int id);
    UserEntityResponse getById(int id);
    List<UserEntityResponse> getAll();
} 