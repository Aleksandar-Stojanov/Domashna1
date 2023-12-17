package com.example.demo.controller;

import com.example.demo.PipeAndFilter.*;
import com.example.demo.model.Users_winery;
import com.example.demo.model.winery;
import com.example.demo.services.WineryService;
import jakarta.servlet.http.HttpServletRequest;
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
            HttpServletRequest request,
            Model model
    ) throws IOException {

        List<winery> wineries;

        if (city != null && !city.isEmpty() && name != null && !name.isEmpty()) {
            wineries = wineryService.findByCityIgnoreCaseAndNameIgnoreCase(city, name);

        } else if (city != null && !city.isEmpty()) {
            wineries = wineryService.findByCityIgnoreCase(city);

        } else if (name != null && !name.isEmpty()) {
            wineries = wineryService.findByNameContainingIgnoreCase(name);

        } else {
            wineries = wineryService.findAll();
        }

        if ("on".equals(sortByRating)) {
            wineries.sort(Comparator.comparingDouble(winery::getRating).reversed());
        }

        PipeAndFilter<winery> pipeAndFilter = new PipeAndFilter<>();
        TownNameChange townNameChange = new TownNameChange();
        ChangeNumber changeNumber = new ChangeNumber();
        NameChangeFilter nameChangeFilter = new NameChangeFilter();
        NoneFilter noneFilter = new NoneFilter();
        pipeAndFilter.addFilter(townNameChange);
        pipeAndFilter.addFilter(changeNumber);
        pipeAndFilter.addFilter(nameChangeFilter);
        pipeAndFilter.addFilter(noneFilter);

        List<winery> transformedWineries = new ArrayList<>();
        for (com.example.demo.model.winery winery : wineries) {
            com.example.demo.model.winery transformedWinery = pipeAndFilter.runFilters(winery);
            transformedWineries.add(transformedWinery);
        }
        model.addAttribute("user",request.getSession().getAttribute("user"));
        model.addAttribute("wineries", transformedWineries);
        model.addAttribute("lastViewedWineries", request.getSession().getAttribute("lastViewedWineries"));
        return "home-page";
    }

    @GetMapping("/winery-details/{id}")
    public String showWineryDetails(@PathVariable Long id, Model model, HttpServletRequest request) {
        winery selectedWinery = wineryService.findById(id);

        if (selectedWinery != null) {
            model.addAttribute("winery", selectedWinery);

            Users_winery user = (Users_winery) request.getSession().getAttribute("user");
            List<winery> lastViewedWineries = (List<winery>) request.getSession().getAttribute("lastViewedWineries");
            if (lastViewedWineries == null) {
                lastViewedWineries = new ArrayList<>();
            }
            if (!lastViewedWineries.contains(selectedWinery)) {
                lastViewedWineries.add(0, selectedWinery);
                // Keep only the last 3 wineries
                if (lastViewedWineries.size() > 3) {
                    lastViewedWineries = lastViewedWineries.subList(0, 3);
                }
                request.getSession().setAttribute("lastViewedWineries", lastViewedWineries);
            }
                return "winery-details";
        } else {
            return "redirect:/wine/home";
        }
    }
}
