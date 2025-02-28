package com.telusko.part29springsecex.repo;

import com.telusko.part29springsecex.model.Student_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Student_Entity, Integer> {

    Student_Entity findByUsername(String username);
}
