package com.example.demo.service.impl;

import com.example.demo.model.entity.DirectorEntity;
import com.example.demo.repository.DirectorsRepository;
import com.example.demo.service.DirectorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class DirectorServiceImpl implements DirectorService {
    private final Gson gson;
    private final DirectorsRepository directorsRepository;
    private final Resource directorsFile;


    public DirectorServiceImpl(Gson gson, DirectorsRepository directorsRepository, @Value("classpath:init/directors.json") Resource directorsFile) {
        this.gson = gson;
        this.directorsRepository = directorsRepository;
        this.directorsFile = directorsFile;
    }


    @Override
    public void seedDirectors() {
        if (directorsRepository.count() == 0){
            try {
                DirectorEntity[] directorEntities =
                        gson.fromJson(Files.readString(Path.of(directorsFile.getURI())), DirectorEntity[].class);

                Arrays.stream(directorEntities)
                        .forEach(directorsRepository::save);

            } catch (Exception e){
                throw new IllegalStateException("Cannot seed directors");
            }
        }
    }
}
