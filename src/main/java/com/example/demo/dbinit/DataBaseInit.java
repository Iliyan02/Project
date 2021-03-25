package com.example.demo.dbinit;

import com.example.demo.service.DirectorService;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {
    private final UserService userService;
    private final DirectorService directorService;

    public DataBaseInit(UserService userService, DirectorService directorService) {
        this.userService = userService;
        this.directorService = directorService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.seedUsers();
        directorService.seedDirectors();
    }
}
