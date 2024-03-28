package com.student.studentinfocrudops.studentInfo.repository;

import com.student.studentinfocrudops.studentInfo.entity.Student;
import com.student.studentinfocrudops.studentInfo.repository.customRepo.StudentCustomRepo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, Long>, StudentCustomRepo {
}
