package com.example.myunspashphotoapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListPhotos
{

    @SerializedName("results")
    @Expose
    private List<Photo> results = new ArrayList<Photo>();
    @SerializedName("total")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public List<Photo> getResults() {
        return results;
    }

    public void setResults(List<Photo> results) {
        this.results = results;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ListPhotos(List<Photo> results, Integer totalResults, Integer totalPages) {
        this.results = results;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
    }
}
