package com.example.grosury.Model;

public class TopSeller {
    private int image;
    private String offer;
    public TopSeller() {
    }

    public TopSeller(int image) {
        this.image = image;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

}
