package com.acunmedya_jvrfs1.Library.Controller;

import com.acunmedya_jvrfs1.Library.Service.ApplicantService;
import com.acunmedya_jvrfs1.Library.Service.dtos.ApplicantRequest;
import com.acunmedya_jvrfs1.Library.Service.dtos.ApplicantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<ApplicantResponse> add(@RequestBody ApplicantRequest request) {
        return ResponseEntity.ok(applicantService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicantResponse> update(@PathVariable int id, @RequestBody ApplicantRequest request) {
        return ResponseEntity.ok(applicantService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        applicantService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicantResponse> getById(@PathVariable int id) {
        return ResponseEntity.ok(applicantService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ApplicantResponse>> getAll() {
        return ResponseEntity.ok(applicantService.getAll());
    }
} 