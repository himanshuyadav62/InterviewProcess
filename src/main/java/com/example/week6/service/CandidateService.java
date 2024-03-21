package com.example.week6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.week6.entity.Candidate;
import com.example.week6.entity.Interview;
import com.example.week6.entity.Result;
import com.example.week6.entity.Resume;
import com.example.week6.repository.CandidateRepository;
import com.example.week6.repository.InterviewRepositroy;
import com.example.week6.repository.ResultRepository;

@Service
public class CandidateService {
    private CandidateRepository candidateRepository;
    private InterviewRepositroy interviewRepositroy;
    private ResultRepository resultRepository;  
     

    public CandidateService(CandidateRepository candidateRepository, InterviewRepositroy interviewRepositroy,
            ResultRepository resultRepository) {
        this.candidateRepository = candidateRepository;
        this.interviewRepositroy = interviewRepositroy;
        this.resultRepository = resultRepository;
    }

    public void addCandidate(Candidate candidate) {
        if(candidate != null)
            this.candidateRepository.save(candidate);         
    }

    // scheduling interview 
    public String scheduleInteview(Interview interview, int candidateId) {
        Optional<Candidate> cOptional = this.candidateRepository.findById(candidateId); 
        if(!cOptional.isPresent()){
            return "candidate not found"; 
        }
        Candidate candidate = cOptional.get();  
        candidate.setInterview(interview);
        interview.setCandidate(candidate);
        this.interviewRepositroy.save(interview); 
        return "interview scheduled for " + candidate.getName() + " on " + interview.getInterviewDateTime(); 
    }

    // linking results with resumes
    public String addResult(Result result, int candidateId, int interviewId) {
        Optional<Candidate> cOptional = this.candidateRepository.findById(candidateId); 
        if(!cOptional.isPresent()){
            return "candidate not found"; 
        }
        Optional<Interview> iOptional = this.interviewRepositroy.findById(interviewId); 
        if(!iOptional.isPresent()){
            return "no interview found"; 
        }

        Candidate candidate = cOptional.get(); 
        Interview interview = iOptional.get(); 
        if(!interview.equals(candidate.getInterview())){
            return "candidate does not have valid interview"; 
        }
        Resume resume = candidate.getResume(); 

        if(resume != null){
            result.setResume(resume);
        }
        result.setInterview(interview);
        this.resultRepository.save(result); 
       return "Result updated Successfully"; 
    }

    public List<Candidate> findAllCandidate() {
        return this.candidateRepository.findAll(); 
    }

    public String getCandidateResults(int candidateId) {
         Optional<Candidate> cOptional = this.candidateRepository.findById(candidateId); 
         if(!cOptional.isPresent()){
            return "candidate not found"; 
         }
         Interview interview = cOptional.get().getInterview(); 
         if(interview == null){
            return "no interview scheduled"; 
         }

         String result = interview.getResult().getResults(); 
         if(result == null){
            return "results are awaited"; 
         }
         return result; 
    } 
}
