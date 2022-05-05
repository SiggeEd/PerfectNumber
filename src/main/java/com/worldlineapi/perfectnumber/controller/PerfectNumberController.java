package com.worldlineapi.perfectnumber.controller;

import com.worldlineapi.perfectnumber.service.PerfectNumberImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        /*
        if(perfectNumberImplementation.checkNumIsPerfect(n))
        {
            return "true";
        }
        return "false";

         */
    }

    @RequestMapping(method = RequestMethod.POST, value = "/perfectnumber/inrange")
    @ResponseBody
    public ArrayList<Long> checkPerfectInRange(@RequestParam(value = "start")long start,@RequestParam(value = "end") long end) throws InternalException
    {
        if(start >= end)
        {
            throw new InternalException("start must be smaller than end");
        }
        return perfectNumberImplementation.checkPerfectInRange(start, end);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static class InternalException extends RuntimeException
    {
        public InternalException(String message)
        {
            super(message);
        }
    }



}
