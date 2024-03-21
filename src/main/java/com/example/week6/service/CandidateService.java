package com.example.week6.service;

import org.springframework.stereotype.Service;

import com.example.week6.entity.Candidate;
import com.example.week6.repository.CandidateRepository;

@Service
public class CandidateService {
    private CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public void addCandidate(Candidate candidate) {
        this.candidateRepository.save(candidate);        
    } 
    

}
