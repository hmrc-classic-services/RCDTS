import Util.IOUtil;

public class application {
    static EventController events = new EventController();

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("=========>>>>> Event Management Tool <<<<<=========");
        System.out.println("===================================================");
        events.printCalendar();

        System.out.println("Avaliable Actions: ");
        System.out.println("1 - Add an event");
        System.out.println("2 - Delete an event");

        switch(IOUtil.readInput("What would you like to do?")) {
            case "1":
                events.addEvent();
                break;
            case "2":
                events.deleteEvent(IOUtil.readInput("Event ID: "));
                break;
        }
    }
}
