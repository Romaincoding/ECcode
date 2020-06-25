package com.codflix.backend.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Serie extends Media{
    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", genreId=" + genreId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", summary='" + summary + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", seasons=" + seasons +
                ", episods=" + episods +
                '}';
    }

    private int id;
    private int genreId;
    private String title;
    private String type;
    private String status;
    private Date releaseDate;
    private String summary;
    private String trailerUrl;
    private String imageUrl;
    private int seasons;
    private int episods;

    public Serie(int id, int genreId, String title, String type, String status, Date releaseDate, String summary, String trailerUrl, String imageUrl, int id1, int genreId1, String title1, String type1, String status1, Date releaseDate1, String summary1, String trailerUrl1, String imageUrl1, int seasons, int episods) {
        super(id, genreId, title, type, status, releaseDate, summary, trailerUrl, imageUrl);
        this.id = id1;
        this.genreId = genreId1;
        this.title = title1;
        this.type = type1;
        this.status = status1;
        this.releaseDate = releaseDate1;
        this.summary = summary1;
        this.trailerUrl = trailerUrl1;
        this.imageUrl = imageUrl1;
        this.seasons = seasons;
        this.episods = episods;
    }


    public int getId() {
        return id;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getReleaseDate() {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
        String releaseDateFormated = formater.format(releaseDate);
        return releaseDateFormated;
    }

    public String getSummary() {
        return summary;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
