package com.example.demo.service;

import com.example.demo.model.service.MovieServiceModel;
import com.example.demo.model.view.MovieViewModel;

public interface MovieService {

    void createMovie(MovieServiceModel movieServiceModel);

    MovieViewModel findById(Long id);
}
