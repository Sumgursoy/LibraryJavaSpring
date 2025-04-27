package com.acunmedya_jvrfs1.Library.Service;

import com.acunmedya_jvrfs1.Library.Service.dtos.ProductEntityRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.ProductEntityResponse;

import java.util.List;

public interface ProductEntityService {
    ProductEntityResponse add(ProductEntityRequest request);
    ProductEntityResponse update(int id, ProductEntityRequest request);
    void delete(int id);
    ProductEntityResponse getById(int id);
    List<ProductEntityResponse> getAll();
} 