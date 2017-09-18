package Util;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class IOUtil {

    private static Console console = null;
    private static Logger logger = LogManager.getLogger(IOUtil.class);

    /**
     * Prompts a user for their input then returns the string.
     * If an error occurs "" is returned.
     * @param prompt
     * @return
     */
    public static String readInput(String prompt) {
        String input = "";
        try {
            console = System.console();
            if (console != null) {
                input = console.readLine("> " + prompt);
            }
        } catch (Exception ex) {
            logger.error("An exception was encountered while reading user input with prompt: " + prompt, ex);
        }
        return input;
    }

    public static String DateAsString(LocalDateTime dateTime, boolean includeTime) {
        DateTimeFormatter formatter = null;
        if (includeTime) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        } else {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        }
        return dateTime.format(formatter);
    }

}
