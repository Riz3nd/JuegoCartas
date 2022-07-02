package com.riz3nd.juegocartas.entity;

import android.graphics.drawable.Drawable;

public class Pokemon {
    private int id;
    private boolean status;
    private boolean statusClick;
    private Drawable img;

    public Pokemon(int id, boolean status, Drawable img) {
        setId(id);
        setStatus(status);
        setImg(img);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public boolean isStatusClick() {
        return statusClick;
    }

    public void setStatusClick(boolean statusClick) {
        this.statusClick = statusClick;
    }
}
