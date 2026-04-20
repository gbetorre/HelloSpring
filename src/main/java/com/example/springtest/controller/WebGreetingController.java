package com.example.springtest.controller;

import com.example.springtest.dto.GreetingRequest;
import com.example.springtest.dto.GreetingResponse;
import com.example.springtest.service.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/web/greetings")
public class WebGreetingController {

    private final GreetingService greetingService;

    public WebGreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    /**
     * Show the input form.
     */
    @GetMapping
    public String showForm() {
        return "index"; // Translates to /WEB-INF/jsp/index.jsp
    }

    /**
     * Process the form submission and show the result page.
     */
    @PostMapping
    public String submitForm(@RequestParam("name") String name, Model model) {
        // We reuse the same request DTO and service as the REST API
        GreetingRequest request = new GreetingRequest(name);
        GreetingResponse response = greetingService.generateGreeting(request);

        // Add the result data to the model so the JSP can access it
        model.addAttribute("greeting", response);
        model.addAttribute("originalName", name);

        return "result"; // Translates to /WEB-INF/jsp/result.jsp
    }
}
