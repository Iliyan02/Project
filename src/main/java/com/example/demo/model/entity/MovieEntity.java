package com.example.demo.model.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "movies")
public class MovieEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column( name = "background_image", nullable = false)
    private String backgroundImage;
    @Column( name = "video_url", nullable = false)
    private String videoUrl;
    @Column( nullable = false)
    private String description;
    @Column( name = "release_date", nullable = false)
    private Instant releaseDate;
    @Column(name = "duration", nullable = false)
    private Integer duration;
    @Column(name = "rating", nullable = false)
    private double rating;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private Genre genre2;
    @ManyToOne
    private DirectorEntity directorEntity;
    @ManyToOne
    private UserEntity userEntity;

    public MovieEntity() {
    }

    public String getName() {
        return name;
    }

    public MovieEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public MovieEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public MovieEntity setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
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

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public MovieEntity setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public MovieEntity setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public DirectorEntity getDirectorEntity() {
        return directorEntity;
    }

    public MovieEntity setDirectorEntity(DirectorEntity directorEntity) {
        this.directorEntity = directorEntity;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public MovieEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public MovieEntity setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public MovieEntity setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public Genre getGenre2() {
        return genre2;
    }

    public MovieEntity setGenre2(Genre genre2) {
        this.genre2 = genre2;
        return this;
    }
}
