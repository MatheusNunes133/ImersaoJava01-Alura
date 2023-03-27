package org.api.requisicao.models;

public class MovieModel {

    private String id;
    private int rank;
    private String title;
    private String fullTitle;
    private int year;
    private String image;
    private String crew;
    private double imDbRating;
    private int imDbRatingCount;

    public MovieModel(){}

    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public int getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getCrew() {
        return crew;
    }

    public double getImDbRating() {
        return imDbRating;
    }

    public int getImDbRatingCount() {
        return imDbRatingCount;
    }
}
