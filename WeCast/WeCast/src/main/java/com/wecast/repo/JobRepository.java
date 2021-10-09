package com.wecast.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wecast.request.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}
