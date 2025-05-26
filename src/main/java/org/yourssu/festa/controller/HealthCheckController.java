package org.yourssu.festa.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public ResponseEntity<String> HealthCheck() {
        return ResponseEntity.ok("Health Check!");
    }
}
