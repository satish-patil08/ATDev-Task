package com.student.studentinfocrudops.studentInfo.repository.customRepo;

import com.student.studentinfocrudops.studentInfo.entity.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentCustomRepoImpl implements StudentCustomRepo {

    private final MongoTemplate mongoTemplate;

    public StudentCustomRepoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Student> getAllWithPaginated(Integer page, Integer size) {
        Query query = new Query(new Criteria());

        if (page != null && size != null) query.with(PageRequest.of(page - 1, size));

        return mongoTemplate.find(query, Student.class);
    }
}
