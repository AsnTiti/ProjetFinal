package com.ReservationArtisanaux.demoReservationArtisanaux.controllers;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Atelier;
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Participant;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ArtisanService;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.AtelierService;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ParticipantService;
@Controller
@RequestMapping("/ateliers")
public class AtelierController {

    @Autowired
    private AtelierService atelierService;
    
    @Autowired
    private ArtisanService artisanService;

    @GetMapping("/liste")
    public String listAteliers(Model model) {
        List<Atelier> ateliers = atelierService.getAllAteliers();
        model.addAttribute("ateliers", ateliers);
        return "liste-ateliers";
    }

    @GetMapping("/{id}")
    public String viewAtelier(@PathVariable("id") Long id, Model model) {
        Atelier atelier = atelierService.getAtelierById(id);
        model.addAttribute("atelier", atelier);
        return "view-atelier";
    }

    @GetMapping("/new")
    public String createAtelierForm(Model model) {
       
    	 Atelier atelier = new Atelier();
         model.addAttribute("atelier", atelier);
    	if (artisanService != null) {
            List<Artisan> artisans = artisanService.getAllArtisans();
            model.addAttribute("artisans", artisans);
        } else {
        	System.out.println("liste artisans vide");
        }
    	
        return "create-atelier";
    }
    @PostMapping("/new")
    public String createAtelier(@ModelAttribute("atelier") Atelier atelier) {
    	// Convertir la chaîne de date en java.util.Date
    	
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date parsedDate;
			try {
				parsedDate = dateFormat.parse(atelier.getDateAtelierString());
				atelier.setDateAtelier(parsedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        atelierService.createAtelier(atelier);
        return "redirect:/ateliers/liste";
    }

    @GetMapping("/{id}/edit")
    public String editAtelierForm(@PathVariable("id") Long id, Model model) {
        Atelier atelier = atelierService.getAtelierById(id);
        model.addAttribute("atelier", atelier);
        return "edit-atelier";
    }

    @PostMapping("/{id}/edit")
    public String editAtelier(@PathVariable("id") Long id, @ModelAttribute("atelier") Atelier updatedAtelier) {
        atelierService.updateAtelier(id, updatedAtelier);
        return "redirect:/ateliers/liste";
    }

    @GetMapping("/{id}/delete")
    public String deleteAtelier(@PathVariable("id") Long id) {
        atelierService.deleteAtelier(id);
        return "redirect:/ateliers/liste";
    }
}
