package com.example.demo.controller;

import com.example.demo.PipeAndFilter.*;
import com.example.demo.model.winery;
import com.example.demo.services.WineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootApp {

    private final WineryService wineryService;

    @Autowired
    public SpringBootApp(WineryService wineryService) {
        this.wineryService = wineryService;
    }
    private void initializeOnStartup() throws IOException {
        System.out.println("Initialization logic");
        PipeAndFilter<winery> pipeAndFilter = new PipeAndFilter<>();
        TownNameChange townNameChange = new TownNameChange();
        ChangeNumber changeNumber = new ChangeNumber();
        NameChangeFilter nameChangeFilter = new NameChangeFilter();
        NoneFilter noneFilter = new NoneFilter();

        pipeAndFilter.addFilter(townNameChange);
        pipeAndFilter.addFilter(changeNumber);
        pipeAndFilter.addFilter(nameChangeFilter);
        pipeAndFilter.addFilter(noneFilter);

        List<winery> wineries = wineryService.findAll();
        List<winery> transformedWineries = new ArrayList<>();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void executeAfterStartup() throws IOException {
        initializeOnStartup();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

}
