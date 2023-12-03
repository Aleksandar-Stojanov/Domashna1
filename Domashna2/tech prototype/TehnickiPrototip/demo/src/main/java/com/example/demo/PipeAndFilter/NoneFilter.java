package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;

import java.io.IOException;

public class NoneFilter implements FilterData<winery> {
    public String execute(String input) {
        String [] parts=input.split(",");
        for (int i=0;i<parts.length;i++){
                if(parts[i].equals("n")){
                    parts[i]="None";
                }
                else
                    continue;
            }
            String res="";
            for (int i=0;i<parts.length;i++){
                res+=parts[i] + ",";
            }
            return res;
        }

    @Override
    public winery execute(winery input) throws IOException {
        return null;
    }
}