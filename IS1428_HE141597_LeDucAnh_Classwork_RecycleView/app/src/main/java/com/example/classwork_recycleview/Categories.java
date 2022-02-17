package com.example.classwork_recycleview;

import java.io.Serializable;

public class Categories implements Serializable {
    private int resourceImage;
    private String name;
    private String detail;

    public Categories(int resourceImage, String name, String detail) {
        this.resourceImage = resourceImage;
        this.name = name;
        this.detail = detail;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
