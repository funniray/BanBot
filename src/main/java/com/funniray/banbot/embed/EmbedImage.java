package com.funniray.banbot.embed;

public class EmbedImage {

    public String url;
    public int height;
    public int width;

    public EmbedImage(String url) {
        this.url = url;
    }

    public EmbedImage(String url, int height, int width) {
        this.url = url;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
