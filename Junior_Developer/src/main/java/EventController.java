import model.Event;
import util.IOUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EventController {
    private static Map<String, Event>  calendar = new HashMap<>();

    public String printCalendar() {
        if(calendar.size() == 0) {
            return "You currently have no events on your calendar";
        }
        return getCalenderEvents();
    }

    private String getCalenderEvents() {
        String nl = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        sb.append("You currently have ").append(calendar.size()).append("events : ").append(nl);

        for(Event event : calendar.values()) {
            sb.append( event.entry())
               .append(nl);
        }
        return sb.toString();
    }

    public void addEvent(String title, String date, String time) {
        String uniqueId = Integer.toString(calendar.size() + 1);
        LocalDateTime dateTime = LocalDateTime.parse(date + time, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm"));
        calendar.put(uniqueId, new Event(uniqueId, title, dateTime));
    }

    public void deleteEvent(String eventId) {
        calendar.remove(eventId);
    }
}
