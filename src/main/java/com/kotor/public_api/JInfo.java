package com.kotor.public_api;

public class JInfo {
    private String сity;
    private int members;
    private String link;
    private double latitude;
    private double longitude;

    public JInfo(String сity, int members, String link, double latitude, double longitude) {
        this.сity = сity;
        this.members = members;
        this.link = link;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getСity() {
        return сity;
    }

    public void setСity(String сity) {
        this.сity = сity;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
