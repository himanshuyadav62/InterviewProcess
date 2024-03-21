package com.example.week6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.week6.service.ResumeService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ResumeController {
    
    private ResumeService resumeService; 
    

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }


    @PostMapping("/candidate/{candidateId}/resume")
    public ResponseEntity<String> addREsumEntity(@RequestParam("file") MultipartFile multipartFile,@PathVariable int candidateId) {

        return new ResponseEntity<>(this.resumeService.addResume(multipartFile,candidateId),HttpStatus.OK); 

    }
    
}
