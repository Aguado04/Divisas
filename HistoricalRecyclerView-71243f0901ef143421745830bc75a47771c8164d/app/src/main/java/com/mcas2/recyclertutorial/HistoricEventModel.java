package com.mcas2.recyclertutorial;

public class HistoricEventModel {
    public String eventName;
    public String eventDate;
    public int eventImage;
    private double conversionRate;

    public HistoricEventModel(String eventName, String eventDate, int eventImage, String conversionRate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventImage = eventImage;
        this.conversionRate = Double.parseDouble(conversionRate);
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public int getEventImage() {
        return eventImage;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}