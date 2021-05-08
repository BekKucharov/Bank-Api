package uz.kucharov.apibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.kucharov.apibank.payload.ApiResponse;
import uz.kucharov.apibank.payload.ApplicationDto;
import uz.kucharov.apibank.service.ApplicationService;

@RestController
@RequestMapping("api/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;
    @PostMapping("/add")
    public HttpEntity<?> addApplication(@RequestBody ApplicationDto applicationDto){
        ApiResponse apiResponse = applicationService.addApplication(applicationDto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse.getMessage());
    }
    @GetMapping("/{id}")
    public HttpEntity<?> checkStatus(@PathVariable Integer id){
        ApiResponse apiResponse = applicationService.checkApplicationStatus(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:404).body(apiResponse.getObject());
    }
}
