package com.wecast.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecast.request.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	 @Query( "select p from Project p where p.createdBy=:user_id")
	 public List<Project> getProjects(@Param("user_id")int user_id);
	 
	public Optional<Project> findByPid(int pid);
	
	public void deleteById(int pid);

}
