package com.example.week6.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.week6.entity.Candidate;
import com.example.week6.entity.Interview;
import com.example.week6.entity.Result;
import com.example.week6.service.CandidateService;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



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

    @PostMapping("/candidate/{candidateId}/interview")
    public ResponseEntity<String> sheduleInterviewEntity(@RequestBody Interview interview,@PathVariable int candidateId) {
        
        return new ResponseEntity<>(this.candidateService.scheduleInteview(interview,candidateId),HttpStatus.OK);
    }

    @PostMapping("/candidate/{candidateId}/interview/{interviewId}/result")
    public ResponseEntity<String> addResulEntity(@RequestBody Result result,@PathVariable int candidateId,@PathVariable int interviewId) {
        
        return new ResponseEntity<>(this.candidateService.addResult(result,candidateId,interviewId),HttpStatus.OK); 
    }
    

    @GetMapping("/candidate")
    public List<Candidate> getCandidate() {
        return this.candidateService.findAllCandidate(); 
    }

    @GetMapping("/candidate/{candidateId}/result")
    public ResponseEntity<String> getCandidateResultEntity(@PathVariable int candidateId) {
        return new ResponseEntity<String>(this.candidateService.getCandidateResults(candidateId),HttpStatus.OK );
    }
}
