package com.example.demo.PipeAndFilter;

import com.example.demo.model.winery;
import java.util.Arrays;

public class ChangeNumber implements FilterData<winery>{

    public winery execute(winery input) {

        String[] parts = new String[]{input.getPhone()};
        String tmp = Arrays.toString(parts);
        if (!tmp.equals("None")) {
            String formattedNumber = tmp.replaceAll("[^0-9]", "");
            if (formattedNumber.startsWith("07")) {
                formattedNumber = formattedNumber.substring(1);
                tmp = "+389" + formattedNumber;
                input.setPhone(tmp);
            }

        }
        String tmp2 = input.getMobile_phone();
        if (!tmp2.equals("None")) {
            String formattedNumber = tmp2.replaceAll("[^0-9]", "");
            if (formattedNumber.startsWith("07")) {
                formattedNumber = formattedNumber.substring(1);
                tmp2 = "+389" + formattedNumber;
                input.setMobile_phone(tmp2);
            }

        }
        String tmp3 = input.getAdditional_phone();
        if (!tmp3.equals("None")) {
            String formattedNumber = tmp3.replaceAll("[^0-9]", "");
            if (formattedNumber.startsWith("07")) {
                formattedNumber = formattedNumber.substring(1);
                tmp3 = "+389" + formattedNumber;
                input.setAdditional_phone(tmp3);
            }
        }
        return input;
    }
}