package com.example.demo.service.impl;

import com.example.demo.model.entity.DirectorEntity;
import com.example.demo.model.entity.MovieEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.service.MovieServiceModel;
import com.example.demo.model.view.MovieViewModel;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DirectorService;
import com.example.demo.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final DirectorService directorService;

    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper modelMapper, UserRepository userRepository, DirectorService directorService) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.directorService = directorService;
    }

    @Override
    public void createMovie(MovieServiceModel movieServiceModel) {
        MovieEntity movieEntity = modelMapper.map(movieServiceModel, MovieEntity.class);
        UserEntity creator = userRepository.findByUsername(movieServiceModel.getUser())
                .orElseThrow(() -> new IllegalArgumentException("Creator" + movieServiceModel.getUser() + "could not be found"));

        movieEntity.setUserEntity(creator);

        DirectorEntity directorEntity = directorService.findByName(movieServiceModel.getDirector());

        movieEntity.setDirectorEntity(directorEntity);
        movieRepository.save(movieEntity);
    }

    @Override
    public MovieViewModel findById(Long id) {
        return movieRepository
                .findById(id)
                .map(movieEntity -> {
                    MovieViewModel movieViewModel  = modelMapper
                            .map(movieEntity, MovieViewModel.class);
                    movieViewModel.setDirector(movieEntity.getDirectorEntity().getName());
                    return movieViewModel;
                }).orElseThrow(IllegalArgumentException::new);
    }
}
