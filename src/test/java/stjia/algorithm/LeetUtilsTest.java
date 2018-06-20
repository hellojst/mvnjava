package stjia.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetUtilsTest {

    @Test
    void canJump() {
        assertTrue(LeetUtils.canJump(new int[] {2,3,1,1,4}));
    }
}