package com.example.demo.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "winery")
@NoArgsConstructor
@AllArgsConstructor
public class winery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;
    private String phone;
    private String mobile_phone;
    private String additional_phone;
    private String address;
    private String city;
    private String email;
    private String website;
    private String yellowpages_link;
    private String catalog_link;
    private String facebook_link;
    private String instagram_link;
    private String description;
    private String logo_url;
    private float rating;
    private int numberofratings;

    public winery(String name, String phone, String mobile_phone, String additional_phone, String address, String city, String email, String website, String yellowpages_link, String catalog_link, String facebook_link, String instagram_link, String logo_url, float rating, int numberofratings) {
        this.name = name;
        this.phone = phone;
        this.mobile_phone = mobile_phone;
        this.additional_phone = additional_phone;
        this.address = address;
        this.city = city;
        this.email = email;
        this.website = website;
        this.yellowpages_link = yellowpages_link;
        this.catalog_link = catalog_link;
        this.facebook_link = facebook_link;
        this.instagram_link = instagram_link;
        this.logo_url = logo_url;
        this.rating = rating;
        this.numberofratings= numberofratings;
    }

    @ElementCollection

    private List<Float> ratings;

    public Collection<Float> getRatings() {
        return ratings;
    }
    public void setNumberOfRatings(int numberofratings) {
        this.numberofratings=numberofratings;
    }
    public int getNumberOfRatings() {
        return numberofratings;
    }
}