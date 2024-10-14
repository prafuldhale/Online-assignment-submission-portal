package com.fd.futured.service;

import com.fd.futured.entity.Assignment;
import com.fd.futured.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    // Get all assignments
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    // Get assignment by ID
    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    // Create new assignment
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Update assignment
    public Assignment updateAssignment(Long id, Assignment assignmentDetails) {
        return assignmentRepository.findById(id).map(assignment -> {
            // Update fields with the provided details
            assignment.setTitle(assignmentDetails.getTitle());
            assignment.setDescription(assignmentDetails.getDescription());
            // Set other fields here as needed
            return assignmentRepository.save(assignment);
        }).orElse(null);
    }


    // Delete assignment
    public boolean deleteAssignment(Long id) {
        return assignmentRepository.findById(id).map(assignment -> {
            assignmentRepository.delete(assignment);
            return true;
        }).orElse(false);
    }
}
