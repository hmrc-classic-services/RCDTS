package util;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RandomNumberUtilTest {

    @Test
    public void randomIntegersUpToTest_allValues() {
        List<Integer> result = RandomNumberUtil.randomIntegersUpTo(1, 2);
        assertEquals(2, result.size());
        assertEquals(0, result.get(0).intValue());
        assertEquals(1, result.get(1).intValue());
    }

    @Test
    public void randomIntegersUpToTest_oneValue() {
        List<Integer> result = RandomNumberUtil.randomIntegersUpTo(1, 1);
        assertEquals(1, result.size());
    }

    @Test(expected=RuntimeException.class)
    public void randomIntegersUpToTest_tooManyValues() {
        RandomNumberUtil.randomIntegersUpTo(1, 3);
    }

}
