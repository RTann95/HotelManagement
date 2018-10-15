package com.hotel.hotelmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HotelManagementController {

    private static Logger LOG = Logger.getLogger(HotelManagementController.class.getName());

    @RequestMapping("/")
    public String index() {
        LOG.info("Received call to '/'");
        return "Hello, World!\n";
    }
}
