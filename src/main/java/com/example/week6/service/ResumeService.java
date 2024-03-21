package com.example.week6.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.week6.entity.Candidate;
import com.example.week6.entity.Resume;
import com.example.week6.repository.CandidateRepository;
import com.example.week6.repository.ResumeRepository;

@Service
public class ResumeService {
    private ResumeRepository resumeRepository;
    private CandidateRepository candidateRepository ;

    public ResumeService(ResumeRepository resumeRepository, CandidateRepository candidateRepository) {
        this.resumeRepository = resumeRepository;
        this.candidateRepository = candidateRepository;
    }

    public String addResume(MultipartFile multipartFile, int candidateId) {
        Resume resume = new Resume(); 
        Optional<Candidate> candidate = this.candidateRepository.findById(candidateId); 
        if (!candidate.isPresent()) {
            return "candidate not found"; 
        }
        try {
            resume.setResumeName(multipartFile.getOriginalFilename());
            resume.setData(multipartFile.getBytes());
            resume.setCandidate(candidate.get());
            this.resumeRepository.save(resume);
        } catch (Exception e) {
             return "file could not be uploaded " + e.toString(); 
        }
        

        return "resume added successfully"; 
    } 
}
