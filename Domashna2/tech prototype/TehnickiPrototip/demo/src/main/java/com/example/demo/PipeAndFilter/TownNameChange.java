package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;

import java.util.Arrays;

public class TownNameChange implements FilterData<winery> {

    public winery execute(winery input) {
        String town = input.getCity();
        town=town.toLowerCase();
        town=Character.toUpperCase(town.charAt(0)) + town.substring(1);
//        parts[5]=tmp;
//        String res="";
//        for(int i=0;i<parts.length;i++){
//            res+=parts[i] + ",";
//        }
        input.setCity(town);
        return input;
    }

}
