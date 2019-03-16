package com.hotel.hotelmanagement.controller;

import com.google.common.collect.ImmutableList;
import com.hotel.hotelmanagement.common.Util;
import com.hotel.hotelmanagement.model.Guest;
import com.hotel.hotelmanagement.model.Reservation;
import com.hotel.hotelmanagement.service.HotelManagementService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HotelManagementControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HotelManagementService hotelManagementService;

    @Test
    public void testGetIndex() throws Exception {
        mvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("pong\n"));
    }

    @Ignore
    @Test
    public void testGetReservations() throws Exception {
        Reservation reservation0 = new Reservation(1, ImmutableList.of(new Guest("Jane", "Doe")), 2);
        Reservation reservation1 = new Reservation(2, ImmutableList.of(new Guest("John", "Person")), 4);
        when(hotelManagementService.getReservations()).thenReturn(ImmutableList.of(reservation0, reservation1));

        String expected = Util.getFile(getClass().getClassLoader(), "reservations.json");

        mvc.perform(get("/reservations"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json(expected));
    }
}
