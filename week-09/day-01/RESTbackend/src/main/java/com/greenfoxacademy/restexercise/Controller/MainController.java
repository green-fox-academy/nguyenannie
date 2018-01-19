package com.greenfoxacademy.restexercise.Controller;

import com.greenfoxacademy.restexercise.Model.*;
import com.greenfoxacademy.restexercise.Model.Error;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @RequestMapping("/")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping("/doubling")
    public Object doubling(@RequestParam(value = "input", required = false) Integer input) {
        if(input != null) {
            return new Doubling(input);
        } else {
            return new Error("Please provide an input!");
        }
    }

    @RequestMapping("/greeter")
    public Object greeting(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "title", required = false) String title) {
        if(name == null && title == null) {
            return new Error("Please provide a name or a title!");
        } else {
            return new Greeter(name, title);
        }
    }

    @RequestMapping("/appends/{appendable}")
    public Append append(@PathVariable(value = "appendable") String appendable) {
        return new Append(appendable);
    }

    @PostMapping("/dountil/{what}")
    public Object doUntil(@PathVariable(value = "what") String what, @RequestBody DoUntilGet doUntilGet) {
        int input = doUntilGet.getUntil();
        Object result;
        switch (what) {
            case "sum":
                result = new DoUntilSum(input);
                break;
            case "multiple":
                result = new DoUntilMultiple(input);
                break;
            default:
                result = new Error("Please provide an input!");
                break;
        }

        return result;
    }

    @PostMapping("/arrays")
    public Object arrays(@RequestBody ArraysRequestBody arraysRequestBody) {
        String what = arraysRequestBody.getWhat();
        int[] numbers = arraysRequestBody.getNumbers();
        Object result;

        if(what.equals("double")) {
            result = new ArraysDouble(numbers);
        } else if(what.equals("sum") || what.equals("multiple")) {
            result = new ArraySumandMultiple(what, numbers);
        } else {
            result = new Error("Please provide what to do with the numbers!");
        }
        return result;
    }
}
