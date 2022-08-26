package ru.netology.ProductManager;

public class Smartphone extends Product {

    protected String smartphoneName;
    protected String smartphoneMaker;

    public Smartphone(int id, String productName, int price, String smartphoneName, String smartphoneMaker) {
        super(id, productName, price);
        this.smartphoneName = smartphoneName;
        this.smartphoneMaker = smartphoneMaker;
    }


    public String getSmartphoneName() {
        return smartphoneName;
    }

    public void setSmartphoneName(String smartphoneName) {
        this.smartphoneName = smartphoneName;
    }

    public String getSmartphoneMaker() {
        return smartphoneMaker;
    }

    public void setSmartphoneMaker(String smartphoneMaker) {
        this.smartphoneMaker = smartphoneMaker;
    }

}
