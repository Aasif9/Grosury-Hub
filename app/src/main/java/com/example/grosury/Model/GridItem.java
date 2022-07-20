package com.example.grosury.Model;

public class GridItem {

    int productImage;
    String productName;
    public GridItem() {
    }

    public GridItem(int productImage, String productName) {
        this.productImage = productImage;
        this.productName = productName;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

