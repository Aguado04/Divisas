package com.mcas2.recyclertutorial;

public class HistoricEventModel {
    public String eventName;
    public String eventDate;
    public int eventImage;

    public HistoricEventModel(String eventName, String eventDate, int eventImage) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventImage = eventImage;

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
}

