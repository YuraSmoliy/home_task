package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CityController {

    Servise servise = new Servise();
    String lastSystemCity = "lviv";

    @RequestMapping(value = "/begin", method = RequestMethod.GET)
    public String begin(@RequestParam(name = "name", required = false, defaultValue = "Lviv") String name,
                        Map<String, Object> model) {
        servise.readFile();
        model.put("next", name);
        return "next";
    }

    @RequestMapping(value = "/next", method = RequestMethod.GET)
    public String next(@RequestParam(name = "next", required = false, defaultValue = "Some word")
                    String name, Map<String, Object> model) {
        String systemValue = servise.comperCityEnd(name);
        if (servise.checkCustomerResponse(name, lastSystemCity)) {
            lastSystemCity = systemValue;
            model.put("next", systemValue);
        } else {
            model.put("next", "Your city is wrong, try again, last my answer was " + lastSystemCity);
        }
        return "next";
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public String end(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Map<String, Object> model) {
        model.put("end", "Thanks for game");
        return "end";
    }
}