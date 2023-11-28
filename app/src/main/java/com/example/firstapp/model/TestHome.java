package com.example.firstapp.model;

public class TestHome{
    private String formCodeEC;
    private String formNameEC;
    private int id;
    private String mediaItemIds;
    private String description;

    public TestHome(String formCodeEC, String formNameEC, int id, String mediaItemIds, String description) {
        this.formCodeEC = formCodeEC;
        this.formNameEC = formNameEC;
        this.id = id;
        this.mediaItemIds = mediaItemIds;
        this.description = description;
    }

    public String getFormCodeEC() {
        return formCodeEC;
    }

    public void setFormCodeEC(String formCodeEC) {
        this.formCodeEC = formCodeEC;
    }

    public String getFormNameEC() {
        return formNameEC;
    }

    public void setFormNameEC(String formNameEC) {
        this.formNameEC = formNameEC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMediaItemIds() {
        return mediaItemIds;
    }

    public void setMediaItemIds(String mediaItemIds) {
        this.mediaItemIds = mediaItemIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
