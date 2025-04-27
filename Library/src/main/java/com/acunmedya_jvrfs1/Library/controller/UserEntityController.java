package com.acunmedya_jvrfs1.Library.Controller;

import com.acunmedya_jvrfs1.Library.Service.UserEntityService;
import com.acunmedya_jvrfs1.Library.Service.dtos.UserEntityRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.UserEntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserEntityController {

    @Autowired
    private UserEntityService userEntityService;

    @PostMapping
    public ResponseEntity<UserEntityResponse> add(@RequestBody UserEntityRequest request) {
        return ResponseEntity.ok(userEntityService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntityResponse> update(@PathVariable int id, @RequestBody UserEntityRequest request) {
        return ResponseEntity.ok(userEntityService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userEntityService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntityResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(userEntityService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserEntityResponse>> getAll() {
        return ResponseEntity.ok(userEntityService.getAll());
    }
} 