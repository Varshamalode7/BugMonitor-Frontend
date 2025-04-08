package com.pgs.BugMonitor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgs.BugMonitor.entity.Project;


@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
