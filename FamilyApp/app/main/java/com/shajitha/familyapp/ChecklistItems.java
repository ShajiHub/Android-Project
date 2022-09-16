package com.shajitha.familyapp;

public class ChecklistItems {

    public static final int listLayout = 1;
    public static final int imageLayout = 2;

    private int chooseLayout;
    private String text;

    // constructor
    public ChecklistItems(int chooseLayout, String text)
    {
        this.text = text;
        this.chooseLayout = chooseLayout;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int img;
    private String dispText;

    // public constructor for the second layout
    public ChecklistItems(int viewType, int img, String dispText) {
        this.img = img;
        this.dispText = dispText;
        this.chooseLayout = viewType;
    }


    public int getimg() {
        return img;
    }

    public void setimg(int img) { this.img = img; }


    public String getdispText() {
        return dispText;
    }

    public void setdispText(String dispText)
    {
        this.dispText = dispText;
    }


    public int getchooseLayout() {
        return chooseLayout;
    }

    public void setchooseLayout(int chooseLayout)
    {
        this.chooseLayout = chooseLayout;
    }

}
