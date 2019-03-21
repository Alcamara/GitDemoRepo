package com.example.myapplist;

public class AppListingModel {

    private int id;
    private String appName, appVersion, contactEmail, domainName, imageUrl;


    public AppListingModel(int id, String appName, String appVersion, String contactEmail, String domainName, String imageUrl) {
        this.id = id;
        this.appName = appName;
        this.appVersion = appVersion;
        this.contactEmail = contactEmail;
        this.domainName = domainName;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
