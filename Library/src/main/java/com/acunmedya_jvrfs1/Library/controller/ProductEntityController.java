package com.acunmedya_jvrfs1.Library.Controller;

import com.acunmedya_jvrfs1.Library.Service.ProductEntityService;
import com.acunmedya_jvrfs1.Library.Service.dtos.ProductEntityRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.ProductEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductEntityController {

    @Autowired
    private ProductEntityService productEntityService;

    @PostMapping
    public ResponseEntity<ProductEntityResponse> add(@RequestBody ProductEntityRequest request) {
        return ResponseEntity.ok(productEntityService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntityResponse> update(@PathVariable int id, @RequestBody ProductEntityRequest request) {
        return ResponseEntity.ok(productEntityService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        productEntityService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntityResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(productEntityService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductEntityResponse>> getAll() {
        return ResponseEntity.ok(productEntityService.getAll());
    }
} 