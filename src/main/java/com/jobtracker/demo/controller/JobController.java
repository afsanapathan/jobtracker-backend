package com.jobtracker.demo.controller;

import com.jobtracker.demo.model.Job;
import com.jobtracker.demo.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jobs")
@CrossOrigin
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    // ✅ CREATE (Add Job)
    @PostMapping
    public Job addJob(@RequestBody Job job) {
        return service.save(job);
    }

    // ✅ READ (Get All Jobs)
    @GetMapping
    public List<Job> getJobs() {
        return service.getAll();
    }

    // ✅ UPDATE (Update Job)
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable String id, @RequestBody Job job) {
        return service.update(id, job);
    }

    // ✅ DELETE (Delete Job)
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable String id) {
        service.delete(id);
    }

    // ✅ FILTER (Get Jobs by Status)
    @GetMapping("/status/{status}")
    public List<Job> getByStatus(@PathVariable String status) {
        return service.getByStatus(status);
    }
}