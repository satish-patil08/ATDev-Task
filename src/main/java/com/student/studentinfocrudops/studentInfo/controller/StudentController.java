package com.student.studentinfocrudops.studentInfo.controller;

import com.student.studentinfocrudops.modelResponse.StatusResponse;
import com.student.studentinfocrudops.studentInfo.entity.Student;
import com.student.studentinfocrudops.studentInfo.service.StudentCRUDOps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentCRUDOps studentCRUDOps;

    @PostMapping("/save")
    public StatusResponse saveStudent(@RequestBody Student student) {
        return studentCRUDOps.save(student);
    }

    @PutMapping("/update-student")
    public StatusResponse updateStudent(@RequestBody Student student) {
        return studentCRUDOps.updateStudent(student);
    }

    @DeleteMapping("/delete/by-id")
    public StatusResponse deleteById(@RequestParam Long id) {
        return studentCRUDOps.deleteById(id);
    }

    @GetMapping("/get/by-id")
    public StatusResponse getById(@RequestParam Long id) {
        return studentCRUDOps.getById(id);
    }

    @DeleteMapping("/delete/all")
    public StatusResponse deleteAllStudents() {
        return studentCRUDOps.deleteAll();
    }

    @GetMapping("/get/all")
    public StatusResponse getAllStudents(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        return studentCRUDOps.getAll(page, size);
    }
}
