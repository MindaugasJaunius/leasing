package com.homework.leasing.api.model.response;

public class LeasingApplicationStatusResponse {

    private String status;

    private String carVinNumber;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarVinNumber() {
        return carVinNumber;
    }

    public void setCarVinNumber(String carVinNumber) {
        this.carVinNumber = carVinNumber;
    }

}
