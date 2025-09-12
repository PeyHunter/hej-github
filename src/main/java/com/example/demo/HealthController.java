package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/healthz")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/chatgpt-key")
    public String chatgptKey() {
        return System.getenv("CHATGPT_API_KEY");
    }
}