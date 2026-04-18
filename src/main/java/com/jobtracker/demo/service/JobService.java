package com.jobtracker.demo.service;

import com.jobtracker.demo.model.Job;
import com.jobtracker.demo.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository repo;

    public JobService(JobRepository repo) {
        this.repo = repo;
    }

    public Job save(Job job) {
        return repo.save(job);
    }

    public List<Job> getAll() {
        return repo.findAll();
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
    public List<Job> getByStatus(String status) {
        return repo.findByStatusIgnoreCase(status);
    }
    public Job update(String id, Job job) {
        Job existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setCompanyName(job.getCompanyName());
            existing.setRole(job.getRole());
            existing.setStatus(job.getStatus());
            existing.setAppliedDate(job.getAppliedDate());
            existing.setFollowUpDate(job.getFollowUpDate());
            existing.setNotes(job.getNotes());

            return repo.save(existing);
        }
        return null;
    }
}
