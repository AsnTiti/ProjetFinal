package com.ReservationArtisanaux.demoReservationArtisanaux.controllers;

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
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Participant;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ArtisanService;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ParticipantService;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/liste")
    public String listParticipants(Model model) {
        List<Participant> participants = participantService.getAllParticipants();
        model.addAttribute("participants", participants);
        return "liste-participants";
    }

    @GetMapping("/{id}")
    public String viewParticipant(@PathVariable("id") Long id, Model model) {
        Participant participant = participantService.getParticipantById(id);
        model.addAttribute("participant", participant);
        return "view-participant";
    }

    @GetMapping("/new")
    public String createParticipantForm(Model model) {
        Participant participant = new Participant();
        model.addAttribute("participant", participant);
        return "create-participant";
    }

    @PostMapping("/new")
    public String createParticipant(@ModelAttribute("participant") Participant participant) {
        participantService.createParticipant(participant);
        return "redirect:/participants/liste";
    }

    @GetMapping("/{id}/edit")
    public String editParticipantForm(@PathVariable("id") Long id, Model model) {
        Participant participant = participantService.getParticipantById(id);
        model.addAttribute("participant", participant);
        return "edit-participant";
    }

    @PostMapping("/{id}/edit")
    public String editParticipant(@PathVariable("id") Long id, @ModelAttribute("participant") Participant updatedParticipant) {
        participantService.updateParticipant(id, updatedParticipant);
        return "redirect:/participants/liste";
    }

    @GetMapping("/{id}/delete")
    public String deleteParticipant(@PathVariable("id") Long id) {
        participantService.deleteParticipant(id);
        return "redirect:/participants/liste";
    }
}