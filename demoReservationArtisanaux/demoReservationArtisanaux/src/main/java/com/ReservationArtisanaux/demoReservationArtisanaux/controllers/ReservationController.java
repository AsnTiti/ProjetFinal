package com.ReservationArtisanaux.demoReservationArtisanaux.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Reservation;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.AtelierService;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ParticipantService;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ReservationService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private ParticipantService participantService;
    
    @Autowired
    private AtelierService atelierService;
    

    @GetMapping("/liste")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "liste-reservations";
    }

    @GetMapping("/{id}")
    public String viewReservation(@PathVariable("id") Long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservation);
        return "view-reservation";
    }

    @GetMapping("/new")
    public String createReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        if (participantService != null) {
            List<Participant> participants = participantService.getAllParticipants();
            model.addAttribute("participants", participants);
        } else {
        	System.out.println("liste participants vide");
        }
        if (atelierService != null) {
            List<Atelier> ateliers = atelierService.getAllAteliers();
            model.addAttribute("ateliers", ateliers);
        } else {
        	System.out.println("liste ateliers vide");
        }
        return "create-reservation";
    }

    @PostMapping("/new")
    public String createReservation(@ModelAttribute("reservation") Reservation reservation) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date parsedDate;
		try {
			parsedDate = dateFormat.parse(reservation.getDateReservationString());
			reservation.setDateReservation(parsedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        reservationService.createReservation(reservation);
        return "redirect:/reservations/liste";
    }

    @GetMapping("/{id}/edit")
    public String editReservationForm(@PathVariable("id") Long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation", reservation);
        return "edit-reservation";
    }

    @PostMapping("/{id}/edit")
    public String editReservation(@PathVariable("id") Long id, @ModelAttribute("reservation") Reservation updatedReservation) {
        reservationService.updateReservation(id, updatedReservation);
        return "redirect:/reservations/liste";
    }

    @GetMapping("/{id}/delete")
    public String deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/liste";
    }
}