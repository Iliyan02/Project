package com.example.demo.model.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String firstImageUrl;
    @Column(nullable = false)
    private String secondImageUrl;
    @Column(nullable = false)
    private String videoUrl;
    @Column(nullable = false)
    private String rating;
    @Column(nullable = false)
    private Integer duration;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Instant year;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private UserEntity userEntity;


    public String getName() {
        return name;
    }

    public MovieEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public MovieEntity setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
        return this;
    }

    public String getSecondImageUrl() {
        return secondImageUrl;
    }

    public MovieEntity setSecondImageUrl(String secondImageUrl) {
        this.secondImageUrl = secondImageUrl;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public MovieEntity setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MovieEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Instant getYear() {
        return year;
    }

    public MovieEntity setYear(Instant year) {
        this.year = year;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public MovieEntity setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public MovieEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public MovieEntity setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public MovieEntity setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }
}
