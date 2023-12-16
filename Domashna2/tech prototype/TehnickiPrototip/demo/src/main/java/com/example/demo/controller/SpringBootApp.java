package com.example.demo.controller;

import com.example.demo.PipeAndFilter.ChangeNumber;
import com.example.demo.PipeAndFilter.PipeAndFilter;
import com.example.demo.PipeAndFilter.TownNameChange;
import com.example.demo.model.winery;
import com.example.demo.services.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootApp {

    @Autowired
    private WineryService wineryService;
    private void initializeOnStartup() throws IOException {
        System.out.println("Initialization logic");
        PipeAndFilter<winery> pipeAndFilter = new PipeAndFilter<>();
        TownNameChange townNameChange = new TownNameChange();
        ChangeNumber changeNumber = new ChangeNumber();

        pipeAndFilter.addFilter(townNameChange);
        pipeAndFilter.addFilter(changeNumber);

        List<winery> wineries = wineryService.findAll();

        List<winery> transformedWineries = new ArrayList<>();
        for(com.example.demo.model.winery winery : wineries){
            com.example.demo.model.winery transformedWinery = pipeAndFilter.runFilters(winery);
            transformedWineries.add(transformedWinery);

            transformedWineries.forEach(System.out::println);

        }
    }
    @EventListener(ApplicationReadyEvent.class)
    public void executeAfterStartup() throws IOException {
        initializeOnStartup();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
