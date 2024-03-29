package com.esercizio.live2903.entites.enums;

public enum RecordStatusEnum {

    AVAILABLE("available"),

    NOAVAILABLE("not available");

    private String recordStatusEnum;

    RecordStatusEnum(String recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }

    public String getRecordStatusEnum() {
        return recordStatusEnum;
    }

    public void setRecordStatusEnum(String recordStatusEnum) {
        this.recordStatusEnum = recordStatusEnum;
    }
}
