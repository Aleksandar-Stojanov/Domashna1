package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;

import java.util.Arrays;

public class NameChangeFilter implements FilterData<winery> {

        public winery execute(winery input) {
            String res = input.getName();
            res=res.toLowerCase();
            String[] words = res.split("\\s");
//            res=Character.toUpperCase(res.charAt(0)) + res.substring(1);
//            String res=tmp + ",";
//            for(int i=1;i<parts.length;i++){
//                res+=parts[i] + ",";
//            }
            for (int i = 0; i < words.length; i++) {
                words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            }
            String name = String.join(" ", words);
            input.setName(name);
            return input;
        }
}
