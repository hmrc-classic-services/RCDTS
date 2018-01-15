import util.IOUtil;

import java.util.Scanner;

public class Application {
    private static EventController events = new EventController();
    private static boolean active = true;

    public static void main(String[] args) {
        while(active) {
            System.out.println("===================================================");
            System.out.println("=========>>>>> Event Management Tool <<<<<=========");
            System.out.println("===================================================");
            events.printCalendar();

            System.out.println("Available Actions: ");
            System.out.println("1 - Add an event");
            System.out.println("2 - Delete an event");
            System.out.println("3 - Display current events");

            Scanner in = new Scanner(System.in);
            switch ( IOUtil.readInput("What would you like to do?")) {
                case "1":
                    System.out.println(">> Adding event");
                    String title = IOUtil.readInput("> What is the title you wish to provide for this event?");
                    String date = IOUtil.readInput("> Enter the date of your event (dd/mm/yyyy): ").trim();
                    String time = IOUtil.readInput("> Enter the time of your event (hh:mm): ").trim();
                    events.addEvent(title, date, time);
                    break;
                case "2":
                    events.deleteEvent(IOUtil.readInput("Event ID:"));
                    break;
                case "3":
                    events.printCalendar();
                    break;
            }
        }
    }
}
