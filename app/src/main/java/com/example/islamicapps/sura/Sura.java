package com.example.islamicapps.sura;

public class Sura {
    String suraName;
    String suraDetails;

    public Sura(String suraName, String suraDetails) {
        this.suraName = suraName;
        this.suraDetails = suraDetails;
    }

    public String getSuraName() {
        return suraName;
    }

    public void setSuraName(String suraName) {
        this.suraName = suraName;
    }

    public String getSuraDetails() {
        return suraDetails;
    }

    public void setSuraDetails(String suraDetails) {
        this.suraDetails = suraDetails;
    }

    public Sura() {
    }
}
