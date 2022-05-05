package com.worldlineapi.perfectnumber.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Service
public class PerfectNumberImplementation implements PerfectNumberService{
    @Override
    public boolean checkNumIsPerfect(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .reduce(1, (sum, test) -> n % test == 0 ? sum + test + (n / test) : sum) == n;
    }

    @Override
    public ArrayList<Long> checkPerfectInRange(long start, long end) {
        ArrayList<Long> perfectNums = new ArrayList<>();
        LongStream.rangeClosed(start,end).filter(this::checkNumIsPerfect).forEach(perfectNums::add);
        return perfectNums;
    }
}
