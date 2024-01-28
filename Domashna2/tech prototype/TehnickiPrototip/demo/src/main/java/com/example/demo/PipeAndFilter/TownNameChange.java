package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;

public class TownNameChange implements FilterData<winery> {

    public winery execute(winery input) {
        String town = input.getCity();
        town=town.toLowerCase();
        town=Character.toUpperCase(town.charAt(0)) + town.substring(1);
        input.setCity(town);
        return input;
    }
}