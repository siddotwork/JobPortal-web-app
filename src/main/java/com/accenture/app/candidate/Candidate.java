package com.accenture.app.candidate;

import com.accenture.app.job.Job;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String resumeLink;

    @ManyToMany
    private List<Job> appliedJobs;
}
