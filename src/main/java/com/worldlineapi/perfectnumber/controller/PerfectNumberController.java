package com.worldlineapi.perfectnumber.controller;

import com.worldlineapi.perfectnumber.service.PerfectNumberImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PerfectNumberController {

    @Autowired
    PerfectNumberImplementation perfectNumberImplementation = new PerfectNumberImplementation();


    @RequestMapping(method = RequestMethod.POST, value = "/perfectnumber/single")
    @ResponseBody
    public boolean checkNum(@RequestParam(value = "num") long n)
    {
        return perfectNumberImplementation.checkNumIsPerfect(n);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/perfectnumber/inrange")
    @ResponseBody
    public ArrayList<Long> checkPerfectInRange(@RequestParam(value = "start")long start,@RequestParam(value = "end") long end)
    {
        return perfectNumberImplementation.checkPerfectInRange(start, end);
    }



}
