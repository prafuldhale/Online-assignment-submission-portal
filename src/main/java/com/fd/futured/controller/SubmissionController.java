package com.fd.futured.controller;

import com.fd.futured.entity.Submission;
import com.fd.futured.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submissions")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    // 1. Get all submissions
    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

    // 2. Get submission by ID
    @GetMapping("/{id}")
    public ResponseEntity<Submission> getSubmissionById(@PathVariable Long id) {
        Submission submission = submissionService.getSubmissionById(id);
        return submission != null ? ResponseEntity.ok(submission) : ResponseEntity.notFound().build();
    }

    // 3. Create new submission
    @PostMapping
    public ResponseEntity<Submission> createSubmission(@RequestBody Submission submission) {
        Submission savedSubmission = submissionService.createSubmission(submission);
        return ResponseEntity.ok(savedSubmission);
    }

    // 4. Update submission
    @PutMapping("/{id}")
    public ResponseEntity<Submission> updateSubmission(@PathVariable Long id, @RequestBody Submission submissionDetails) {
        Submission updatedSubmission = submissionService.updateSubmission(id, submissionDetails);
        return updatedSubmission != null ? ResponseEntity.ok(updatedSubmission) : ResponseEntity.notFound().build();
    }

    // 5. Delete submission
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubmission(@PathVariable Long id) {
        boolean deleted = submissionService.deleteSubmission(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
