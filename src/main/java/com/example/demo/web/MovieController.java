package com.example.demo.web;

import com.example.demo.model.binding.MovieAddBindingModel;
import com.example.demo.model.service.MovieServiceModel;
import com.example.demo.model.view.MovieViewModel;
import com.example.demo.service.DirectorService;
import com.example.demo.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.ZoneId;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final DirectorService directorService;
    private final ModelMapper modelMapper;
    private final MovieService movieService;

    public MovieController(DirectorService directorService, ModelMapper modelMapper, MovieService movieService) {
        this.directorService = directorService;
        this.modelMapper = modelMapper;
        this.movieService = movieService;
    }

    @ModelAttribute("movieAddBindingModel")
    public MovieAddBindingModel createBindingModel() {
        return new MovieAddBindingModel();
    }


    @GetMapping("/add")
    public String add(Model model){

        model.addAttribute("directors", directorService.findAllDirectors());
        return "add-movie";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid MovieAddBindingModel movieAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails principal){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("movieAddBindingModel", movieAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.movieAddBindingModel", bindingResult);
            return "redirect:/add";
        }


        MovieServiceModel movieServiceModel =
                modelMapper.map(movieAddBindingModel, MovieServiceModel.class);

        movieServiceModel.setUser(principal.getUsername());

        movieServiceModel.setReleaseDate(movieAddBindingModel.
                getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toInstant());

        movieService.createMovie(movieServiceModel);

        return "redirect:/home";
    }

    @GetMapping("/movie-page-details/{id}")
    public String details(@PathVariable Long id, Model model){
        MovieViewModel movieViewModel = movieService.findById(id);

        model.addAttribute("movie", movieViewModel);

        return "movie-page-details";
    }


}
