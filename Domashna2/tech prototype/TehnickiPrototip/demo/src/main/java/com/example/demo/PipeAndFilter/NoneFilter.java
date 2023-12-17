package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;

import java.io.IOException;
import java.util.Objects;

public class NoneFilter implements FilterData<winery> {
    public winery execute(winery input) {

        if (input.getName().equals("n")) {
            input.setName("None");
        }
        ;
        if ((input.getPhone()).equals("n")) {
            input.setPhone("None");
        }
        ;
        if ((input.getMobile_phone()).equals("n")) {
            input.setMobile_phone("None");
        }
        ;
        if (input.getAdditional_phone().equals("n")) {
            input.setAdditional_phone("None");
        }
        ;
        if ((input.getAddress()).equals("n")) {
            input.setAddress("None");
        }
        ;
        if ((input.getCity()).equals("n")) {
            input.setCity("None");
        }
        ;
        if ((input.getEmail()).equals("n")) {
            input.setEmail("None");
        }
        ;
        if ((input.getWebsite()).equals("n")) {
            input.setWebsite("None");
        }
        ;
        if ((input.getYellowpages_link()).equals("n")) {
            input.setYellowpages_link("None");
        }
        ;
        if ((input.getCatalog_link()).equals("n")) {
            input.setCatalog_link("None");
        }
        ;
        if ((input.getFacebook_link()).equals("n")) {
            input.setFacebook_link("None");
        }
        ;
        if ((input.getInstagram_link()).equals("n")) {
            input.setInstagram_link("None");
        }
        ;
        if ((input.getLogo_url()).equals("n")) {
            input.setLogo_url("None");
        }
        ;
        if ((input.getName()).equals("n")) {
            input.setName("None");
        }
        ;

        return input;
    }
}