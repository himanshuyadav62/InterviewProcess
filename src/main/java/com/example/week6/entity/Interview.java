package com.example.week6.entity;

import jakarta.persistence.OneToOne;


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

    @OneToOne
    private Resume resume; 

    @OneToOne
    private Candidate candidate; 
}
