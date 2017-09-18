package Util;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOUtilTest {

    @Test
    public void test_DateAsString() {
        LocalDateTime ldt = LocalDateTime.of(1994, 5, 18, 11, 59);
        String result = IOUtil.DateAsString(ldt, true);
        assertEquals("18-05-1994 11:59", result);
    }

    @Test
    public void test_DateAsString_NoTime() {
        LocalDateTime ldt = LocalDateTime.of(1994, 5, 18, 16, 36);
        String result = IOUtil.DateAsString(ldt, false);
        assertEquals("18-05-1994 11:59", result);
    }


}
