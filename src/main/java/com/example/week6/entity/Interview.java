package com.example.week6.entity;

import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Interview {
    @Id
    @GeneratedValue
    private Integer interviewId;


    
    private String interviewStatus ;
    

    private LocalDateTime interviewDateTime; 

    

    @OneToOne
    @JsonBackReference
    private Candidate candidate; 

    @OneToOne(mappedBy = "interview", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Result result; 
}
