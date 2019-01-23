package com.lyd.bikeEntity;

public class Column {
    private Integer columnId;

    private String columnName;

    private Integer columnFirstid;

    private String columnUrl;

    private Integer columnPermissionid;

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public Integer getColumnFirstid() {
        return columnFirstid;
    }

    public void setColumnFirstid(Integer columnFirstid) {
        this.columnFirstid = columnFirstid;
    }

    public String getColumnUrl() {
        return columnUrl;
    }

    public void setColumnUrl(String columnUrl) {
        this.columnUrl = columnUrl == null ? null : columnUrl.trim();
    }

    public Integer getColumnPermissionid() {
        return columnPermissionid;
    }

    public void setColumnPermissionid(Integer columnPermissionid) {
        this.columnPermissionid = columnPermissionid;
    }
}