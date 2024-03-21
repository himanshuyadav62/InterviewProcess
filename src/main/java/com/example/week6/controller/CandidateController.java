package com.example.week6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.week6.entity.Candidate;
import com.example.week6.service.CandidateService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CandidateController {

    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/candidate")
    public ResponseEntity<String> addCandidateEntity(@RequestBody Candidate candidate) {
        try {
            this.candidateService.addCandidate(candidate);
            return new ResponseEntity<>("candidate added successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.OK);
        }
    }

}
