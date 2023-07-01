package com.example.cryptotracker.model;

public class CryptoResponse {

    private String name;
    private double current_price;
    private double market_cap;
    private double total_volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }

    public double getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(double market_cap) {
        this.market_cap = market_cap;
    }

    public double getTotal_volume() {
        return total_volume;
    }

    public void setTotal_volume(double total_volume) {
        this.total_volume = total_volume;
    }
}
