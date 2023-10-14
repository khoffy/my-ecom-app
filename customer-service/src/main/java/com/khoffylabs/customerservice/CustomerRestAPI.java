package com.khoffylabs.customerservice;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerRestAPI {
    @GetMapping("/customers")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Map<String, Object> customer() {
        return Map.of("name", "Khoffy",
                "email", "khoffy.tipoh@gmail.com");
    }

}
