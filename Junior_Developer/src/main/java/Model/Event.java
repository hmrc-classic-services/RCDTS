package Model;


import Util.IOUtil;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private final String eventId;
    private String eventName;
    private LocalDateTime dateTime;
    private String description;
    private List<User> attendees;

    public Event(String eventId, String eventName, LocalDateTime dateTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.dateTime = dateTime;
    }

    public String entry() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(eventId).append("]").append(eventName).append(" : ").append(IOUtil.DateAsString(dateTime,true));
        return sb.toString();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}
