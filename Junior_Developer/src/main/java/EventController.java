import Model.Event;
import Util.IOUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class EventController {
    private static Map<String, Event>  calendar = new HashMap<>();

    public String printCalendar() {
        StringBuilder sb = new StringBuilder();
        String nl = System.lineSeparator();
        if(calendar.size() == 0) {
            sb.append("You currently have no events on your calendar");
        } else {
            sb.append("You currently have ").append(calendar.size()).append("events").append(nl);
            for(Event event : calendar.values()) {
                sb.append( event.entry()).append(nl);
            }
        }
        return sb.toString();
    }

    public void addEvent() {
        String unqiueId = Integer.toString(calendar.size() + 1);
        String title;
        int year, month, day;

        System.out.println(">> Adding event");
        title = IOUtil.readInput("> What is the title you wish to provide for this event?");
        year = Integer.parseInt(IOUtil.readInput("> What year is this event to take place?"));
        month = Integer.parseInt(IOUtil.readInput("> What month is this event to take place?"));
        day = Integer.parseInt(IOUtil.readInput("> What day is this event to take place?"));
        calendar.put(unqiueId, new Event(unqiueId, title, LocalDateTime.of(year, month, day, 0, 0)));
    }

    public void deleteEvent(String eventId) {
        calendar.remove(eventId);
    }
}
