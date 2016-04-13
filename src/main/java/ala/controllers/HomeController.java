package ala.controllers;

import ala.responses.BasicResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dendelion on 2016-04-11.
 */

@RestController
@RequestMapping({"/", "/home"})
public class HomeController {

    @RequestMapping("/test")
    public BasicResponse test() {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setResult(true);
        basicResponse.setText("elo");

        return basicResponse;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public BasicResponse test(@RequestBody BasicResponse bs) {
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setResult(true);
        basicResponse.setText("elo");

        System.out.println(bs.toString());

        return basicResponse;
    }

    @RequestMapping(value = "/lol", method = RequestMethod.POST)
    public String test2(@RequestBody String text) {

        System.out.println(text);
        return "Malina";
    }
}

