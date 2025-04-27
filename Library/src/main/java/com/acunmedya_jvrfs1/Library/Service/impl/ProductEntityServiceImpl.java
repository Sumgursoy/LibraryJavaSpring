package com.acunmedya_jvrfs1.Library.Service.impl;

import com.acunmedya_jvrfs1.Library.Service.ProductEntityService;
import com.acunmedya_jvrfs1.Library.Service.dtos.ProductEntityRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.ProductEntityResponse;
import com.acunmedya_jvrfs1.Library.entity.productEntity;
import com.acunmedya_jvrfs1.Library.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductEntityServiceImpl implements ProductEntityService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntityResponse add(ProductEntityRequest request) {
        productEntity product = new productEntity();
        mapRequestToEntity(request, product);
        productEntity savedEntity = productRepository.save(product);
        return mapEntityToResponse(savedEntity);
    }

    @Override
    public ProductEntityResponse update(int id, ProductEntityRequest request) {
        productEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        mapRequestToEntity(request, product);
        productEntity updatedEntity = productRepository.save(product);
        return mapEntityToResponse(updatedEntity);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductEntityResponse getById(int id) {
        productEntity product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapEntityToResponse(product);
    }

    @Override
    public List<ProductEntityResponse> getAll() {
        return productRepository.findAll().stream()
                .map(this::mapEntityToResponse)
                .collect(Collectors.toList());
    }

    private void mapRequestToEntity(ProductEntityRequest request, productEntity entity) {
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setStock(request.getStock());
    }

    private ProductEntityResponse mapEntityToResponse(productEntity entity) {
        ProductEntityResponse response = new ProductEntityResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setPrice(entity.getPrice());
        response.setStock(entity.getStock());
        return response;
    }
} 