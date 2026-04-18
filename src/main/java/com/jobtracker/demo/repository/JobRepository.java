package com.jobtracker.demo.repository;


import com.jobtracker.demo.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface JobRepository extends MongoRepository<Job, String> {
    List<Job> findByStatusIgnoreCase(String status);
}