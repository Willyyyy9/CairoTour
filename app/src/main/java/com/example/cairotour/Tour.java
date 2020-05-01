package com.example.cairotour;

public class Tour {

    //Setting global variables
    private int titleId;
    private int subtitleId = NO_RESOURCE;
    private int audioResourceId;
    private int imageResourceId = NO_RESOURCE;
    private int urlResourceId;
    private static final int NO_RESOURCE = -1;

    //Setting Public Constructors with different number of parameters
    public Tour(int titleId, int subtitleId, int imageResourceId, int resourceId) {
        this.titleId = titleId;
        this.subtitleId = subtitleId;
        this.imageResourceId = imageResourceId;
        this.urlResourceId = resourceId;
    }

    public Tour(int titleId, int subtitleId, int resourceId) {
        this.titleId = titleId;
        this.subtitleId = subtitleId;
        this.audioResourceId = resourceId;
    }



    public Tour(int titleId, int imageResourceId) {
        this.titleId = titleId;
        this.imageResourceId = imageResourceId;
    }


    //Getters
    public int getTitleId() {
        return titleId;
    }
    public int getSubtitleId() {
        return subtitleId;
    }
    public int getAudioResourceId() {
        return audioResourceId;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public int getUrlResourceId() { return urlResourceId; }


    //checks if an image is available
    public boolean hasImage(){
        return imageResourceId != NO_RESOURCE;
    }

    //checks if a subtitle is available
    public boolean hasSubtitle(){
        return subtitleId != NO_RESOURCE;
    }
}
