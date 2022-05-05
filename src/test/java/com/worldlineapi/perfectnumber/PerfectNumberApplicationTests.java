package com.worldlineapi.perfectnumber;

import com.worldlineapi.perfectnumber.controller.PerfectNumberController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PerfectNumberApplicationTests {

    PerfectNumberController perfectNumberController = new PerfectNumberController();

    @Test
    void testSinglePerfectNumber()
    {
        long[] perfectNumArray = {6, 28, 496, 8128, 33550336};
        long[] nonPerfectNumArray = {7, 39, 3943, 432432};

        for(long i : perfectNumArray)
        {
            assertTrue(perfectNumberController.checkNum(i));
        }
        for(long i : nonPerfectNumArray)
        {
            assertFalse(perfectNumberController.checkNum(i));
        }
    }


    @Test
    public void testPerfectNumberInRange(){

        Random rand = new Random();
        long firstNum = rand.nextLong(2, 5);
        long secondNum = rand.nextLong(8500, 10000);
        System.out.println(firstNum);
        System.out.println(secondNum);
        ArrayList<Long> perfectNums = new ArrayList<>();
        perfectNums.add((long) 6);
        perfectNums.add((long) 28);
        perfectNums.add((long) 496);
        perfectNums.add((long) 8128);
        Assertions.assertIterableEquals(perfectNums, perfectNumberController.checkPerfectInRange(firstNum, secondNum));
    }


}
