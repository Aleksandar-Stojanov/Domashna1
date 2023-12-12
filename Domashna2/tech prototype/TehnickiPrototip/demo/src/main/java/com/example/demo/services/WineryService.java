package com.example.demo.services;

import com.example.demo.model.winery;

import java.util.List;

public interface WineryService {
    public List<winery> findAll();
    List<winery> findByCityIgnoreCase(String city);
    List<winery> findByNameIgnoreCase(String name);
    List<winery> findByCityIgnoreCaseAndNameIgnoreCase(String city, String name);
    winery save(String name, String phone, String mobile_phone, String additional_phone, String address, String city, String email, String website, String yellowpages_link, String catalog_link, String facebook_link, String instagram_link, String logo_url, float rating);
    winery findById(Long id);

    void updateRating(Long wineryId, float newRating);

    Float calculateAverageRating(Long wineryId);

    void save(winery existingWinery);
}