package com.student.studentinfocrudops.studentInfo.service;

import com.student.studentinfocrudops.modelResponse.StatusResponse;
import com.student.studentinfocrudops.studentInfo.entity.Student;
import com.student.studentinfocrudops.studentInfo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCRUDOps {

    @Autowired
    private StudentRepo studentRepo;

    public StatusResponse save(Student student) {

        if (studentRepo.existsById(student.getId())) {
            return new StatusResponse(
                    false,
                    "Student already exist by given Id"
            );
        }

        if (student.getFirstName() == null
                || student.getLastName() == null
                || student.getEmail() == null
                || student.getContactNo() == null
                || student.getCourse() == null
        )
            return new StatusResponse(
                    false,
                    "Some Fields are missing"
            );

        return new StatusResponse(
                true,
                "Student created successfully",
                studentRepo.save(student)
        );
    }

    public StatusResponse updateStudent(Student student) {
        Optional<Student> studentOptional = studentRepo.findById(student.getId());

        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setContactNo(student.getContactNo());
            existingStudent.setCourse(student.getCourse());

            return new StatusResponse(
                    true,
                    "Student Updated Successfully",
                    studentRepo.save(existingStudent)
            );
        } else {
            return new StatusResponse(
                    false,
                    "Student not found with ID"
            );
        }
    }

    public StatusResponse deleteById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (!student.isPresent()) {
            return new StatusResponse(
                    false,
                    "Student Not Exist for Given id"
            );
        }

        studentRepo.deleteById(id);
        return new StatusResponse(
                true,
                "Student Deleted Successfully"
        );
    }

    public StatusResponse getById(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (!student.isPresent()) {
            return new StatusResponse(
                    false,
                    "Student Not Exist for Given id"
            );
        }

        return new StatusResponse(
                true,
                "Student Retrieved Successfully",
                student
        );
    }

    public StatusResponse deleteAll() {
        List<Student> allStudents = studentRepo.findAll();

        studentRepo.deleteAll(allStudents);
        return new StatusResponse(
                true,
                "All Students Deleted Successfully"
        );
    }

    public StatusResponse getAll(Integer page, Integer size) {
        List<Student> allStudents = studentRepo.getAllWithPaginated(page, size);

        return new StatusResponse(
                true,
                "All Students Retrieved Successfully",
                allStudents
        );
    }
}
