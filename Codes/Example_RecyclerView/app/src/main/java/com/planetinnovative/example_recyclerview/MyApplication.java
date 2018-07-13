package com.planetinnovative.example_recyclerview;

public class MyApplication {
    private int appImage;
    private String appTitle;

    public MyApplication(int appImage, String appTitle) {
        this.appImage = appImage;
        this.appTitle = appTitle;
    }

    public int getAppImage() {
        return appImage;
    }

    public String getAppTitle() {
        return appTitle;
    }

}
