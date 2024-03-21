package com.example.week6.entity;

import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder
@Entity
public class Resume {
    @Id
    @GeneratedValue
    private Integer resumeId; 

    private String resumeName; 
    @Lob
    private byte[] data;

    @OneToOne
    @JsonBackReference
    private Candidate candidate; 

    

    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Result result; 
}
