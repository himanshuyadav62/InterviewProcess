package com.example.week6.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Candidate {

    @Id
    @GeneratedValue
    private Integer id; 
    private String name; 

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Resume resume; 

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Interview interview;
}
