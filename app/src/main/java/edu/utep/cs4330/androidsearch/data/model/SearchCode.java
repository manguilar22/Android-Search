package edu.utep.cs4330.androidsearch.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public enum SearchCode {


    ALL(""),
    IMAGE("isch"),
    NEWS("nws"),
    VIDEO("vid"),
    BOOKS("books");

    public final String tbm;

    SearchCode(String tbm) {
        this.tbm = tbm;
    }

}