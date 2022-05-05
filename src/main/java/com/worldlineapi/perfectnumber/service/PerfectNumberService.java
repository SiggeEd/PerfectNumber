package com.worldlineapi.perfectnumber.service;

import java.util.ArrayList;

public interface PerfectNumberService {
    boolean checkNumIsPerfect(long n);
    ArrayList<Long> checkPerfectInRange(long start, long end);
}
