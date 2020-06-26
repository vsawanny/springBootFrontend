package com.zetcode.controller;

import com.zetcode.bean.User;

import com.microsoft.applicationinsights.TelemetryClient;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 

@Controller
public class MyController {

  
    @Autowired
     TelemetryClient telemetryClient;

    
    
    @GetMapping("/addUser")
    public String sendForm(User user) {
        //track a custom event  
        telemetryClient.trackEvent("Sending a custom event...");

        //trace a custom trace
        telemetryClient.trackTrace("Sending a custom trace....");
        return "addUser";
    }


    @PostMapping("/addUser")
    public String processForm(User user) {

        return "showMessage";
    }
    
   
}
