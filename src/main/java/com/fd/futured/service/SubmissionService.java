package com.fd.futured.service;

import com.fd.futured.entity.Submission;
import com.fd.futured.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    // 1. Get all submissions
    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    // 2. Get submission by ID
    public Submission getSubmissionById(Long id) {
        return submissionRepository.findById(id).orElse(null);
    }

    // 3. Create new submission
    public Submission createSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    // 4. Update submission
    public Submission updateSubmission(Long id, Submission submissionDetails) {
        Submission submission = submissionRepository.findById(id).orElse(null);
        if (submission != null) {
            submission.setStatus(submissionDetails.getStatus());
            submission.setFilesSubmitted(submissionDetails.getFilesSubmitted());
            submission.setSubmissionTime(submissionDetails.getSubmissionTime());
            return submissionRepository.save(submission);
        }
        return null;
    }

    // 5. Delete submission
    public boolean deleteSubmission(Long id) {
        if (submissionRepository.existsById(id)) {
            submissionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
