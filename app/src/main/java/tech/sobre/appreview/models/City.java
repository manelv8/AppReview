package tech.sobre.appreview.models;

import com.google.gson.annotations.SerializedName;

public class City {

    int id;
    String name;

    @SerializedName("main")
    Weather weather;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
