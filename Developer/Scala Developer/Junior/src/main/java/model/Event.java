package model;


import util.DateUtil;
import util.IOUtil;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private final String eventId;
    private String eventName;
    private LocalDateTime dateTime;

    public Event(String eventId, String eventName, LocalDateTime dateTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.dateTime = dateTime;
    }

    public String entry() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(eventId).append("]").append(eventName).append(" : ").append(DateUtil.dateAsString(dateTime));
        return sb.toString();
    }

    public boolean isAfter(Event event) {
        if(event.getDateTime().isAfter(this.dateTime)) {
            return true;
        }
        return false;
    }

    public boolean isBefore(Event event) {
        if( event.getDateTime().isBefore(this.dateTime)) {
            return true;
        }
        return false;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
