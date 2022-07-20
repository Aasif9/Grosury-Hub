package com.example.grosury.Model;

public class ProductDetail {
    int productDetailImage;
    String productDetailName,productQuantity;
    int productPrice,productDiscount;


    public ProductDetail(int productDetailImage, String productDetailName, int productPrice, int productDiscount, String productQuantity) {
        this.productDetailImage = productDetailImage;
        this.productDetailName = productDetailName;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productQuantity = productQuantity;
    }

    public ProductDetail(){

    }

    public int getProductDetailImage() {
        return productDetailImage;
    }

    public void setProductDetailImage(int productDetailImage) {
        this.productDetailImage = productDetailImage;
    }

    public String getProductDetailName() {
        return productDetailName;
    }

    public void setProductDetailName(String productDetailName) {
        this.productDetailName = productDetailName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
