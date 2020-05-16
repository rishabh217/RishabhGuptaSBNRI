package com.rishabhgupta.sbnri.model;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("open_issues_count")
    public String open_issues_count = "";

    @SerializedName("name")
    public String name = "";

    @SerializedName("description")
    public String description = "";

    public Data(String open_issues_count, String name, String description) {
        this.open_issues_count = open_issues_count;
        this.name = name;
        this.description = description;
    }

    public Data() {
    }
}
