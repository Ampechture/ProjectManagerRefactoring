package com.ngu.restclienttemplate.MainCode.entity.repository;

import com.ngu.restclienttemplate.MainCode.entity.Task;
import com.ngu.restclienttemplate.entity.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface tasksUserRepository extends JpaRepository<User, Task> {

}
