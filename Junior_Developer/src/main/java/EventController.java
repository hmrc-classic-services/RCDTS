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

    public void addEvent() {
        String uniqueId = Integer.toString(calendar.size() + 1);

        System.out.println(">> Adding event");
        String title = IOUtil.readInput("> What is the title you wish to provide for this event?");
        String date = IOUtil.readInput("> Enter the date of your event (dd/mm/yyyy): ").trim();
        String time = IOUtil.readInput("> Enter the time of your event (hh:mm): ").trim();
        calendar.put(uniqueId, new Event(uniqueId, title, LocalDateTime.parse(date + time, DateTimeFormatter.ofPattern("dd/MM/yyyyHH:mm"))));
    }

    public void deleteEvent(String eventId) {
        calendar.remove(eventId);
    }
}
