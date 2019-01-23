package com.lyd.bikeEntity;

public class Complain {
    private Integer complainId;

    private Integer complainUserId;

    private Integer complainBikeId;

    private String complainBikeArea;

    private String complainInfo;

    public Integer getComplainId() {
        return complainId;
    }

    public void setComplainId(Integer complainId) {
        this.complainId = complainId;
    }

    public Integer getComplainUserId() {
        return complainUserId;
    }

    public void setComplainUserId(Integer complainUserId) {
        this.complainUserId = complainUserId;
    }

    public Integer getComplainBikeId() {
        return complainBikeId;
    }

    public void setComplainBikeId(Integer complainBikeId) {
        this.complainBikeId = complainBikeId;
    }

    public String getComplainBikeArea() {
        return complainBikeArea;
    }

    public void setComplainBikeArea(String complainBikeArea) {
        this.complainBikeArea = complainBikeArea == null ? null : complainBikeArea.trim();
    }

    public String getComplainInfo() {
        return complainInfo;
    }

    public void setComplainInfo(String complainInfo) {
        this.complainInfo = complainInfo == null ? null : complainInfo.trim();
    }
}