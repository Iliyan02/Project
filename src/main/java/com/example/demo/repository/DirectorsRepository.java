package com.example.demo.repository;

import com.example.demo.model.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorsRepository extends JpaRepository<DirectorEntity, Long> {
}
