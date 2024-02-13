package com.ReservationArtisanaux.demoReservationArtisanaux.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ArtisanService;


@Controller
@RequestMapping("/artisans")
public class ArtisanControlleur {

    @Autowired
    private ArtisanService artisanService;

    @GetMapping("/liste")
    public String listArtisans(Model model) {
        List<Artisan> artisans = artisanService.getAllArtisans();
        model.addAttribute("artisans", artisans);
        return "liste-artisans";
    }

    @GetMapping("/{id}")
    public String viewArtisan(@PathVariable("id") Long id, Model model) {
        Artisan artisan = artisanService.getArtisanById(id);
        model.addAttribute("artisan", artisan);
        return "view-artisan";
    }

    @GetMapping("/new")
    public String createArtisanForm(Model model) {
        Artisan artisan = new Artisan();
        model.addAttribute("artisan", artisan);
        return "create-artisan";
    }

    @PostMapping("/new")
    public String createArtisan(@ModelAttribute("artisan") Artisan artisan) {
        artisanService.createArtisan(artisan);
        return "redirect:/artisans/liste";
    }

    @GetMapping("/{id}/edit")
    public String editArtisanForm(@PathVariable("id") Long id, Model model) {
        Artisan artisan = artisanService.getArtisanById(id);
        model.addAttribute("artisan", artisan);
        return "edit-artisan";
    }

    @PostMapping("/{id}/edit")
    public String editArtisan(@PathVariable("id") Long id, @ModelAttribute("artisan") Artisan updatedArtisan) {
        artisanService.updateArtisan(id, updatedArtisan);
        return "redirect:/artisans/liste";
    }

    @GetMapping("/{id}/delete")
    public String deleteArtisan(@PathVariable("id") Long id) {
        artisanService.deleteArtisan(id);
        return "redirect:/artisans/liste";
    }
}
