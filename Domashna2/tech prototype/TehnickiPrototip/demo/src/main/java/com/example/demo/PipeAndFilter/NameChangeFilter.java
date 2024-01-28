package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;


public class NameChangeFilter implements FilterData<winery> {
    public winery execute(winery input) {
        String res = input.getName();
        res=res.toLowerCase();
        String[] words = res.split("\\s");
        for (int i = 0; i < words.length; i++) {
            words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
        }
        String name = String.join(" ", words);
        input.setName(name);
        return input;
    }
}
