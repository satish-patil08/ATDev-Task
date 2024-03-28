package com.student.studentinfocrudops.studentInfo.repository.customRepo;

import com.student.studentinfocrudops.studentInfo.entity.Student;

import java.util.List;

public interface StudentCustomRepo {
    List<Student> getAllWithPaginated(Integer page, Integer size);
}
