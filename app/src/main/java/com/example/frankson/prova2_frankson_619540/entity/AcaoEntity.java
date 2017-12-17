package com.example.frankson.prova2_frankson_619540.entity;

/**
 * Created by frankson on 16/12/17.
 */

public class AcaoEntity {

    private int id;
    private String name;
    private String image;
    private String description;
    private String site;

    public AcaoEntity(String name, String image){
        this.name = name;
        this.image = image;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public String getImage() {

        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getSite() {
        return site;
    }
}
