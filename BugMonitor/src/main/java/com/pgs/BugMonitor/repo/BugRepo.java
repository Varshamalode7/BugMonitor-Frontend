package com.pgs.BugMonitor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgs.BugMonitor.entity.Bug;

public interface BugRepo extends JpaRepository<Bug, Integer> {

}
