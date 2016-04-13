package ala.controllers;

import ala.entities.User;
import ala.responses.BasicResponse;
import ala.services.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dendelion on 2016-04-14.
 */

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private DatabaseService databaseService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BasicResponse registerUser(@RequestBody User user) {
        System.out.println(user.toString());
        BasicResponse basicResponse = new BasicResponse();

        databaseService.saveUser(user);

        return basicResponse;

    }
}
