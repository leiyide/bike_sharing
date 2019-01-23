package com.lyd.bikeEntity;

public class Service {
    private Integer serviceId;

    private Integer serviceUserId;

    private Integer serviceBikeId;

    private String serviceBikeArea;

    private String serviceInfo;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceUserId() {
        return serviceUserId;
    }

    public void setServiceUserId(Integer serviceUserId) {
        this.serviceUserId = serviceUserId;
    }

    public Integer getServiceBikeId() {
        return serviceBikeId;
    }

    public void setServiceBikeId(Integer serviceBikeId) {
        this.serviceBikeId = serviceBikeId;
    }

    public String getServiceBikeArea() {
        return serviceBikeArea;
    }

    public void setServiceBikeArea(String serviceBikeArea) {
        this.serviceBikeArea = serviceBikeArea == null ? null : serviceBikeArea.trim();
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo == null ? null : serviceInfo.trim();
    }
}