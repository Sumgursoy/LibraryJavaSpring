package com.acunmedya_jvrfs1.Library.controller;

import com.acunmedya_jvrfs1.Library.Repository.ProductRepository;
import com.acunmedya_jvrfs1.Library.entity.productEntity;
import com.acunmedya_jvrfs1.Library.service.ProductService;
import com.acunmedya_jvrfs1.Library.dto.CreateProductRequest;
import com.acunmedya_jvrfs1.Library.dto.CreateProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public List<productEntity> getProduct(){
        return productRepository.findAll();
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<productEntity> getById(@PathVariable int id){
        Optional<productEntity> product = productRepository.findById(id);

        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return productService.add(request);

    }
}
