package com.example.demo.services;

import com.example.demo.model.winery;
import com.example.demo.repository.WineryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineryServiceImpl implements WineryService {
    private final WineryRepository wineryRepository;

    public WineryServiceImpl(WineryRepository wineryRepository) {
        this.wineryRepository = wineryRepository;
    }

    @Override
    public winery save(String name, String phone, String mobile_phone, String additional_phone, String address, String city, String email, String website, String yellowpages_link, String catalog_link, String facebook_link, String instagram_link, String logo_url, float rating) {
        winery winery = new winery(name, phone, mobile_phone, additional_phone, address, city, email, website, yellowpages_link, catalog_link, facebook_link, instagram_link, logo_url, rating);
        wineryRepository.save(winery);

        return winery;
    }

    @Override
    public winery findById(Long id) {
        return this.wineryRepository.findById(id).orElse(null);
    }

    @Override
    public List<winery> findAll() {
        return (List<winery>) wineryRepository.findAll();
    }

    @Override
    public List<winery> findByCityIgnoreCase(String city) {
        return (List<winery>) wineryRepository.findByCityIgnoreCase(city);
    }

    @Override
    public List<winery> findByNameIgnoreCase(String name) {
        return (List<winery>) wineryRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<winery> findByCityIgnoreCaseAndNameIgnoreCase(String city, String name) {
        return (List<winery>) wineryRepository.findByCityIgnoreCaseAndNameIgnoreCase(city, name);
    }

    @Override
    public void updateRating(Long wineryId, float newRating) {
        winery winery = wineryRepository.findById(wineryId).orElse(null);

        if (winery != null) {
            winery.setRating(newRating);
            wineryRepository.save(winery);
        }
    }

    @Override
    public Float calculateAverageRating(Long wineryId) {
        winery winery = wineryRepository.findById(wineryId).orElse(null);

        if (winery != null) {
            List<Float> ratings = (List<Float>) winery.getRatings();
            if (!ratings.isEmpty()) {
                float sum = 0.0f;
                for (Float rating : ratings) {
                    sum += rating;
                }
                return sum / ratings.size();
            } else {
                return 0.0f; // or handle the case where there are no ratings
            }
        } else {
            return 0.0f; // or handle the case where the winery is not found
        }
    }
    @Override
    public void save(winery existingWinery) {
        wineryRepository.save(existingWinery);
    }

}
