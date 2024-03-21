package com.example.week6.entity;

import jakarta.persistence.OneToOne;
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

    @Lob
    private byte[] data;

    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL)
    private Candidate candidate; 

    @OneToOne(mappedBy = "resume", cascade = CascadeType.ALL)
    private Interview interview; 
}
