 package com.studentManagementSystem.SMS.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.studentManagementSystem.SMS.entity.StudentInfo;

public interface StudentRepository extends MongoRepository<StudentInfo, String> {

    List<StudentInfo> findByNameContainingIgnoreCase(String name);
}
