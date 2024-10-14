package com.fd.futured.service;
import com.fd.futured.entity.Teacher;
import com.fd.futured.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

  @Autowired
  TeacherRepository teacherRepository;

    // 1. Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // 2. Get teacher by ID
    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);  // Return teacher or null if not found
    }

    // 3. Create a new teacher
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // 4. Update an existing teacher by ID
    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        return teacherRepository.findById(id).map(teacher -> {
            teacher.setName(teacherDetails.getName());
            teacher.setEmail(teacherDetails.getEmail());
            // Update other fields as needed, such as coursesManaged, assignmentList, etc.
            return teacherRepository.save(teacher);
        }).orElse(null);  // Return null if teacher not found
    }

    // 5. Delete a teacher by ID
    public boolean deleteTeacher(Long id) {
        return teacherRepository.findById(id).map(teacher -> {
            teacherRepository.delete(teacher);
            return true;
        }).orElse(false);  // Return false if teacher not found
    }
}
