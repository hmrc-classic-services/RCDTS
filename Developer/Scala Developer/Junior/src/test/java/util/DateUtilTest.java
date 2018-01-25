package util;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DateUtilTest {

    @Test
    public void test_DateAsString() {
        LocalDateTime ldt = LocalDateTime.of(1994, 5, 18, 11, 59);
        String result = DateUtil.dateAsString(ldt);
        assertEquals("18-05-1994 11:59", result);
    }

    @Test
    public void test_DateAndTimeAsString() {
        LocalDateTime ldt = LocalDateTime.of(1994, 5, 18, 16, 36);
        String result = DateUtil.dateAsString(ldt);
        assertEquals("18-05-1994 11:59", result);
    }
}
