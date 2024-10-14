package com.fd.futured.controller;

import com.fd.futured.entity.Assignment;
import com.fd.futured.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // 1. Get all assignments
    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    // 2. Get assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Assignment assignment = assignmentService.getAssignmentById(id);
        return assignment != null ? ResponseEntity.ok(assignment) : ResponseEntity.notFound().build();
    }

    // 3. Create new assignment
    @PostMapping
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment savedAssignment = assignmentService.createAssignment(assignment);
        return ResponseEntity.ok(savedAssignment);
    }

    // 4. Update assignment
    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        Assignment updatedAssignment = assignmentService.updateAssignment(id, assignment);
        return updatedAssignment != null ? ResponseEntity.ok(updatedAssignment) : ResponseEntity.notFound().build();
    }

    // 5. Delete assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        boolean deleted = assignmentService.deleteAssignment(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
