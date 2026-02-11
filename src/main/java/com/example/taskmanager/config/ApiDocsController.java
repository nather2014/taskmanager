package com.example.taskmanager.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
class ApiDocsController {

    @GetMapping("/")
    RedirectView index() {
        return new RedirectView("/swagger-ui/index.html");
    }
}
