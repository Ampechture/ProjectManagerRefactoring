package com.springeducational.projectmanagerrefactoring.repositories;

import com.springeducational.projectmanagerrefactoring.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}
