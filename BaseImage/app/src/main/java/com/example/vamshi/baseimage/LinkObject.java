package com.example.vamshi.baseimage;

import android.net.Uri;

/**
 * Created by Vamshi on 5/22/2017.
 */

public class LinkObject {

    public String Imagelink;
    public int position;

    public LinkObject(String imagelink, int position) {
        Imagelink = imagelink;
        this.position = position;
    }

    public String getImagelink() {
        return Imagelink;
    }

    public int getPosition() {
        return position;
    }
}
