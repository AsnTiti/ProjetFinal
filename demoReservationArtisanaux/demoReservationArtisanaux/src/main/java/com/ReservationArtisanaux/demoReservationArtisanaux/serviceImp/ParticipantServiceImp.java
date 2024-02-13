package com.ReservationArtisanaux.demoReservationArtisanaux.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Participant;
import com.ReservationArtisanaux.demoReservationArtisanaux.repository.ArtisanRepository;
import com.ReservationArtisanaux.demoReservationArtisanaux.repository.ParticipantRepository;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ParticipantService;

@Service
public class ParticipantServiceImp implements ParticipantService {
	
	/*private final ParticipantRepository participantRepository; // Déclaration du repository pour les produits.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //ProduitRepository.
    public ParticipantServiceImp(ParticipantRepository participantRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.participantRepository = participantRepository; 
    }
    
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant); // Appel du repository pour enregistrer le produit.
    }
    
     // Implémentation de la méthode pour obtenir un produit par son ID.
    public Optional<Participant> getParticipantById(int id) {
        return participantRepository.findById((long) id); // Appel du repository pour trouver le produit.
    }
    // Implémentation de la méthode pour obtenir tous les produits.
    public List<Participant> getAllParticipant() {
        return participantRepository.findAll(); // Appel du repository pour obtenir tous les produits.
    }*/
	@Autowired
    private ParticipantRepository participantRepository;

    @Override
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    @Override
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Participant updateParticipant(Long id, Participant updatedParticipant) {
        Participant existingParticipant = participantRepository.findById(id).orElse(null);
        if (existingParticipant != null) {
            // Mettez à jour les propriétés nécessaires
            existingParticipant.setNom(updatedParticipant.getNom());
            existingParticipant.setEmail(updatedParticipant.getEmail());
            existingParticipant.setTelephone(updatedParticipant.getTelephone());

            return participantRepository.save(existingParticipant);
        }
        return null;
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }

	

}
