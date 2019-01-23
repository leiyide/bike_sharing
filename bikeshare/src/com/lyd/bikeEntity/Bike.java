package com.lyd.bikeEntity;

public class Bike {
	private Integer bikeId;

    private Integer bikeGenerationnum;

    private Integer bikePassword;

    private Integer bikeUsenum;

    private Integer bikeIsusing;

    private String bikeArea;

    private Integer bikeIsuse;

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getBikeGenerationnum() {
        return bikeGenerationnum;
    }

    public void setBikeGenerationnum(Integer bikeGenerationnum) {
        this.bikeGenerationnum = bikeGenerationnum;
    }

    public Integer getBikePassword() {
        return bikePassword;
    }

    public void setBikePassword(Integer bikePassword) {
        this.bikePassword = bikePassword;
    }

    public Integer getBikeUsenum() {
        return bikeUsenum;
    }

    public void setBikeUsenum(Integer bikeUsenum) {
        this.bikeUsenum = bikeUsenum;
    }

    public Integer getBikeIsusing() {
        return bikeIsusing;
    }

    public void setBikeIsusing(Integer bikeIsusing) {
        this.bikeIsusing = bikeIsusing;
    }

    public String getBikeArea() {
        return bikeArea;
    }

    public void setBikeArea(String bikeArea) {
        this.bikeArea = bikeArea == null ? null : bikeArea.trim();
    }

    public Integer getBikeIsuse() {
        return bikeIsuse;
    }

    public void setBikeIsuse(Integer bikeIsuse) {
        this.bikeIsuse = bikeIsuse;
    }
}