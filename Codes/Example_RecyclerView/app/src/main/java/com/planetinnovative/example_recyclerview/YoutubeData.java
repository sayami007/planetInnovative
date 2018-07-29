package com.planetinnovative.example_recyclerview;

public class YoutubeData {
    private String title;
    private int favImage;
    private int mainImage;

    public YoutubeData(String title, int favImage, int mainImage) {
        this.title = title;
        this.favImage = favImage;
        this.mainImage = mainImage;
    }

    public String getTitle() {
        return title;
    }

    public int getFavImage() {
        return favImage;
    }

    public int getMainImage() {
        return mainImage;
    }
}
