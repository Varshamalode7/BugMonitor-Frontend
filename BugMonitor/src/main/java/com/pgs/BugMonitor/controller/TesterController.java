package com.pgs.BugMonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pgs.BugMonitor.entity.Bug;
import com.pgs.BugMonitor.repo.BugRepo;


@RestController("/bugs")
public class TesterController {

    @Autowired
    private BugRepo bugRepo;

    // View all bugs
    @GetMapping
    public List<Bug> getAllBugs() {
        return bugRepo.findAll();
    }
    

    @PostMapping
    public Bug addBug(@RequestBody Bug bug) {
        return bugRepo.save(bug);
    }


}
