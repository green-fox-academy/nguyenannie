package com.greenfoxacademy.restexercise.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.restexercise.Model.*;
import com.greenfoxacademy.restexercise.Model.Error;
import com.greenfoxacademy.restexercise.Service.LogServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    private final LogServiceDbImpl logServiceDb;

    @Autowired
    public MainController(LogServiceDbImpl logServiceDb) {
        this.logServiceDb = logServiceDb;
    }

    @RequestMapping("/doubling")
    public Object doubling(@RequestParam(value = "input", required = false) Integer input) {
        String endpoint = "/doubling";
        String data;
        Log log = new Log();
        log.setEndPoint(endpoint);
        if(input != null) {
            data = "input=" + input;
            log.setData(data);
            logServiceDb.save(log);
            return new Doubling(input);
        } else {
            data = "";
            log.setData(data);
            logServiceDb.save(log);
            return new Error("Please provide an input!");
        }
    }

    @RequestMapping("/greeter")
    public Object greeting(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "title", required = false) String title) {
        String endpoint = "/greeter";
        String data;
        Log log = new Log();
        log.setEndPoint(endpoint);
        if(name == null && title == null) {
            data = "";
            log.setData("");
            logServiceDb.save(log);
            return new Error("Please provide a name or a title!");
        } else {
            data = "name=" + name + "&title=" + title;
            log.setData(data);
            logServiceDb.save(log);
            return new Greeter(name, title);
        }
    }

    @RequestMapping("/appends/{appendable}")
    public Append append(@PathVariable(value = "appendable") String appendable) {
        Log log = new Log("/appends/{appendable}", "appendable=" + appendable);
        logServiceDb.save(log);
        return new Append(appendable);
    }

    @PostMapping("/dountil/{what}")
    public Object doUntil(@PathVariable(value = "what") String what, @RequestBody DoUntilGet doUntilGet) {
        int input = doUntilGet.getUntil();
        Object result;

        ObjectMapper mapper = new ObjectMapper();
        String requestBodyInString;

        try {
            requestBodyInString = mapper.writeValueAsString(doUntilGet);
        } catch (JsonProcessingException e) {
            requestBodyInString = null;
            e.printStackTrace();
        }

        Log log = new Log();
        log.setData(requestBodyInString);
        String endpoint = "/dountil/";

        switch (what) {
            case "sum":
                endpoint += "sum";
                result = new DoUntilSum(input);
                break;
            case "multiple":
                endpoint += "multiple";
                result = new DoUntilMultiple(input);
                break;
            default:
                endpoint += "";
                result = new Error("Please provide an input!");
                break;
        }

        log.setEndPoint(endpoint);
        logServiceDb.save(log);

        return result;
    }

    @PostMapping("/arrays")
    public Object arrays(@RequestBody ArraysRequestBody arraysRequestBody) {
        String what = arraysRequestBody.getWhat();
        int[] numbers = arraysRequestBody.getNumbers();
        Object result;

        ObjectMapper mapper = new ObjectMapper();
        String requestBodyInString;
        try {
            requestBodyInString = mapper.writeValueAsString(arraysRequestBody);
        } catch (JsonProcessingException e) {
            requestBodyInString = null;
            e.printStackTrace();
        }

        Log log = new Log("/arrays", requestBodyInString);
        logServiceDb.save(log);

        switch (what) {
            case "double":
                result = new ArraysDouble(numbers);
                break;
            case "sum":
                result = new ArraySumandMultiple(what, numbers);
                break;
            case "multiple":
                result = new ArraySumandMultiple(what, numbers);
                break;
            default:
                result = new Error("Please provide what to do with the numbers!");
                break;
        }

        return result;
    }

    @RequestMapping("/log")
    public LogEndPoint getLog() {
        return new LogEndPoint(logServiceDb);
    }
}
