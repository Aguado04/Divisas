package com.mcas2.recyclertutorial;

public class DivisasEventModel {
    public String eventName;
    public String eventPrice;
    public int eventImage;
    private double conversionRate;

    public DivisasEventModel(String eventName, String eventPrice, int eventImage, String conversionRate) {
        this.eventName = eventName;
        this.eventPrice = eventPrice;
        this.eventImage = eventImage;
        this.conversionRate = Double.parseDouble(conversionRate);
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventPrice() {
        return eventPrice;
    }

    public int getEventImage() {
        return eventImage;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}