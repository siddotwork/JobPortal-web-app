package com.accenture.app.Job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long id=1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {

        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobs.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void removeJobById(Long id) {
        jobs.removeIf(job->job.getId().equals(id));
    }

    @Override
    public void updateJobById(Long id, Job modifiedEntry) {
        Job j=getJobById(id);
        j.setId(modifiedEntry.getId());
        j.setDescription(modifiedEntry.getDescription());
        j.setTitle(modifiedEntry.getTitle());
        j.setLocation(modifiedEntry.getLocation());
        j.setMaxSalary(modifiedEntry.getMaxSalary());
        j.setMinSalary(modifiedEntry.getMinSalary());
    }


}
