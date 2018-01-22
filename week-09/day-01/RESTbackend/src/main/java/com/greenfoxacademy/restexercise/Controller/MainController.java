package com.greenfoxacademy.restexercise.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.restexercise.Model.*;
import com.greenfoxacademy.restexercise.Model.ArraysEndpoint.ArraySumandMultiple;
import com.greenfoxacademy.restexercise.Model.ArraysEndpoint.ArraysDouble;
import com.greenfoxacademy.restexercise.Model.ArraysEndpoint.ArraysRequestBody;
import com.greenfoxacademy.restexercise.Model.DoUntilEndPoint.DoUntilGet;
import com.greenfoxacademy.restexercise.Model.DoUntilEndPoint.DoUntilMultiple;
import com.greenfoxacademy.restexercise.Model.DoUntilEndPoint.DoUntilSum;
import com.greenfoxacademy.restexercise.Model.Error;
import com.greenfoxacademy.restexercise.Model.LogEndpoint.Log;
import com.greenfoxacademy.restexercise.Model.LogEndpoint.LogPages;
import com.greenfoxacademy.restexercise.Model.LogEndpoint.LogResponse;
import com.greenfoxacademy.restexercise.Model.SithEndPoint.Sith;
import com.greenfoxacademy.restexercise.Model.SithEndPoint.SithRequestBody;
import com.greenfoxacademy.restexercise.Model.TranslateEndPoint.TranslateRequestBody;
import com.greenfoxacademy.restexercise.Model.TranslateEndPoint.TranslateResponse;
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

        saveLog(endpoint, doUntilGet);

        return result;
    }

    @PostMapping("/arrays")
    public Object arrays(@RequestBody ArraysRequestBody arraysRequestBody) {
        String what = arraysRequestBody.getWhat();
        int[] numbers = arraysRequestBody.getNumbers();
        Object result;

        saveLog("/arrays", arraysRequestBody);

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
    public Object getLog(@RequestParam(value = "count", required = false) Integer count,
                              @RequestParam(value = "page", required = false) Integer page) {
        if(count == null || page == null) {
            return new LogResponse(logServiceDb);
        } else {
            return new LogPages(logServiceDb, count, page);
        }
    }

    @PostMapping("/sith")
    public Object sithEndpoint(@RequestBody SithRequestBody sithRequestBody) {

        saveLog("/sith", sithRequestBody);

        if(sithRequestBody != null) {
            return new Sith(sithRequestBody.getText());
        } else {
            return new Error("Feed me some text you have to, padawan young you are. Hmmm.");
        }
    }

    @PostMapping("/translate")
    public Object translate(@RequestBody TranslateRequestBody translateRequestBody) {

        saveLog("/translate", translateRequestBody);

        if(translateRequestBody.getText() == null || translateRequestBody.getLang() == null) {
            return new Error("I can't translate that!");
        } else {
            return new TranslateResponse(translateRequestBody.getText());
        }
    }

    private void saveLog(String endpoint, Object requestBody) {
        ObjectMapper mapper = new ObjectMapper();
        String requestBodyInString;
        try {
            requestBodyInString = mapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            requestBodyInString = null;
            e.printStackTrace();
        }

        Log log = new Log(endpoint, requestBodyInString);
        logServiceDb.save(log);
    }

}
