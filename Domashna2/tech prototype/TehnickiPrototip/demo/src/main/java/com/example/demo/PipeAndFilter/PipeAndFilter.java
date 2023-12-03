package com.example.demo.PipeAndFilter;

import ch.qos.logback.core.filter.Filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PipeAndFilter <Winery> {
    private List<FilterData<Winery>> filters = new ArrayList<FilterData<Winery>>();

    public void addFilter(FilterData<Winery> filter) {
        filters.add(filter);
    }

    public Winery runFilters(Winery input) throws IOException {
        for (FilterData<Winery> filter : filters) {
            input = filter.execute(input);

        }
        return input;
    }

}