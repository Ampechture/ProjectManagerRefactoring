package com.springeducational.projectmanagerrefactoring.MainCode.entity.repository;

import com.springeducational.projectmanagerrefactoring.MainCode.entity.Task;
import com.springeducational.projectmanagerrefactoring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface tasksUserRepository extends JpaRepository<User, Task> {

}
