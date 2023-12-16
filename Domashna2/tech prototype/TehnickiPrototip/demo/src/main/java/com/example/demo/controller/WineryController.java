package com.example.demo.controller;

import com.example.demo.PipeAndFilter.*;
import com.example.demo.model.winery;
import com.example.demo.services.WineryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping(value = "/wine")
@Validated
@CrossOrigin(origins = "*")
public class WineryController {
    private final WineryService wineryService;

    public WineryController(WineryService wineryService) {
        this.wineryService = wineryService;
    }


@GetMapping("/home")
public String showAllWineries(
        @RequestParam(required = false) String city,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String sortByRating,
        Model model
) throws IOException {

    List<winery> wineries;


    if (city != null && !city.isEmpty() && name != null && !name.isEmpty()) {
        wineries = wineryService.findByCityIgnoreCaseAndNameIgnoreCase(city, name);

    } else if (city != null && !city.isEmpty()) {
        wineries = wineryService.findByCityIgnoreCase(city);

    } else if (name != null && !name.isEmpty()) {
        wineries = wineryService.findByNameIgnoreCase(name);

    } else {
        wineries = wineryService.findAll();
    }

    if ("on".equals(sortByRating)) {
        wineries.sort(Comparator.comparingDouble(winery::getRating).reversed());
    }

    PipeAndFilter<winery> pipeAndFilter = new PipeAndFilter<>();
//            NameChangeFilter nameChangeFilter = new NameChangeFilter();
    TownNameChange townNameChange = new TownNameChange();
//            NoneFilter noneFilter = new NoneFilter();
    ChangeNumber changeNumber = new ChangeNumber();

//            pipeAndFilter.addFilter(nameChangeFilter);
    pipeAndFilter.addFilter(townNameChange);
//            pipeAndFilter.addFilter(noneFilter);
    pipeAndFilter.addFilter(changeNumber);


    List<winery> transformedWineries = new ArrayList<>();
    for(com.example.demo.model.winery winery : wineries){
        com.example.demo.model.winery transformedWinery = pipeAndFilter.runFilters(winery);
        transformedWineries.add(transformedWinery);
    }
//proba

    model.addAttribute("wineries", wineries);
    return "home-page";
}
    @GetMapping("/winery-details/{id}")
    public String showWineryDetails(@PathVariable Long id, Model model) {
        winery selectedWinery = wineryService.findById(id);

        if (selectedWinery != null) {
            model.addAttribute("winery", selectedWinery);
            return "winery-details";
        } else {
            return "redirect:/wine/home";
        }
    }
}
