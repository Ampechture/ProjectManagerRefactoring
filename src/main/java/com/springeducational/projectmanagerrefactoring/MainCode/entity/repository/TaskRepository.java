package com.springeducational.projectmanagerrefactoring.MainCode.entity.repository;

import com.springeducational.projectmanagerrefactoring.MainCode.entity.Task;
import com.springeducational.projectmanagerrefactoring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    boolean existsByprojectName(String projectName);


    List<Task> findAllByusersIdentity(User user);
}
