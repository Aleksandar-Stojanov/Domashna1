package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;

import java.util.Arrays;

public class NameChangeFilter implements FilterData<winery> {

        public winery execute(winery input) {
            String res = input.getName();
            res=res.toLowerCase();
            res=Character.toUpperCase(res.charAt(0)) + res.substring(1);
//            String res=tmp + ",";
//            for(int i=1;i<parts.length;i++){
//                res+=parts[i] + ",";
//            }
            input.setName(res);
            return input;
        }
}
