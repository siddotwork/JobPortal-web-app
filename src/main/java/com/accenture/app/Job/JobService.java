package com.accenture.app.Job;


import java.util.ArrayList;
import java.util.List;


public interface JobService {

    List<Job> findAll();

    void createJob(Job job);


    Job getJobById(Long id);

    void removeJobById(Long id);

    void updateJobById(Long id, Job modifiedEntry);
}
