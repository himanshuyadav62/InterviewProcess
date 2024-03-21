package com.example.week6.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class Result {
    @Id
    @GeneratedValue
    private Integer resultId;
    
    private String results; 

    @OneToOne
    @JsonBackReference
    private Interview interview;

    @OneToOne
    @JsonBackReference
    private Resume resume; 

}
