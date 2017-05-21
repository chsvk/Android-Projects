package com.example.vamshi.recyclerviewtest;

/**
 * Created by Vamshi on 5/20/2017.
 */

public class ModelForListItem {

    private String heading;
    private String description;

    public ModelForListItem(String heading, String description) {
        this.heading = heading;
        this.description = description;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
