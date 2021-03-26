package com.example.demo.service;

import com.example.demo.model.entity.DirectorEntity;

import java.util.List;

public interface DirectorService {
    void seedDirectors();

    List<String> findAllDirectors();

    DirectorEntity findByName(String director);
}
