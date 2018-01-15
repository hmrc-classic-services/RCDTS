package util;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class IOUtil {

    private static Console console = null;
    private static Logger logger = LogManager.getLogger(IOUtil.class);
    private static final Scanner in = new Scanner(System.in);
    /**
     * Prompts a user for their input then returns the string.
     * If an error occurs "" is returned.
     * @param prompt
     * @return
     */
    public static String readInput(String prompt) {
        String input = "";
        try {
            System.out.println(prompt);
            input = in.next();
        } catch (Exception ex) {
            logger.error("An exception was encountered while reading user input with prompt: " + prompt, ex);
        }
        return input;
    }

}
