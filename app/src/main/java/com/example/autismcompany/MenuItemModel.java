package com.example.autismcompany;

public class MenuItemModel {
    private String title;
    private String price;
    private String description;
    private int imageResId; // Если используем локальные ресурсы

    public MenuItemModel(String title, String price, String description, int imageResId) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
