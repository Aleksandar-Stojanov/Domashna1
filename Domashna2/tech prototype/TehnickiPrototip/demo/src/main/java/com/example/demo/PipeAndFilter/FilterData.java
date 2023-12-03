package com.example.demo.PipeAndFilter;

import java.io.IOException;

public interface FilterData<Winery>{
        Winery execute(Winery input) throws IOException;
}

