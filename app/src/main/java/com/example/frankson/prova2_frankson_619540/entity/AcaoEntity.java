package com.example.frankson.prova2_frankson_619540.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by frankson on 16/12/17.
 */

public class AcaoEntity {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("site")
    @Expose
    private String site;

    public long getId() { return id; }

    public String getName() { return name;}

    public String getImage() { return image;}

    public String getDescription() {
        return description;
    }

    public String getSite() {
        return site;
    }
}
