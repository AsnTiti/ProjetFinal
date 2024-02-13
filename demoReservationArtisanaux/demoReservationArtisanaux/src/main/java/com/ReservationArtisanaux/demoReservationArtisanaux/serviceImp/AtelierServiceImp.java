package com.ReservationArtisanaux.demoReservationArtisanaux.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Atelier;
import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Participant;
import com.ReservationArtisanaux.demoReservationArtisanaux.repository.AtelierRepository;
import com.ReservationArtisanaux.demoReservationArtisanaux.repository.ParticipantRepository;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.AtelierService;

@Service
public class AtelierServiceImp implements AtelierService{
	
	/*private final AtelierRepository atelierRepository; // Déclaration du repository pour les produits.

    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
    //ProduitRepository.
    public AtelierServiceImp(AtelierRepository atelierRepository) {
    	// Affectation du repository injecté au champ de la classe.
        this.atelierRepository = atelierRepository; 
    }
    
    public Atelier saveAtelier(Atelier atelier) {
        return atelierRepository.save(atelier); // Appel du repository pour enregistrer le produit.
    }
    
     // Implémentation de la méthode pour obtenir un produit par son ID.
    public Optional<Atelier> getAtelierById(int id) {
        return atelierRepository.findById((long) id); // Appel du repository pour trouver le produit.
    }
    // Implémentation de la méthode pour obtenir tous les produits.
    public List<Atelier> getAllAtelier() {
        return atelierRepository.findAll(); // Appel du repository pour obtenir tous les produits.
    }*/
	
	@Autowired
    private AtelierRepository atelierRepository;

    @Override
    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }

    @Override
    public Atelier getAtelierById(Long id) {
        return atelierRepository.findById(id).orElse(null);
    }

    @Override
    public Atelier createAtelier(Atelier atelier) {
        return atelierRepository.save(atelier);
    }

    @Override
    public Atelier updateAtelier(Long id, Atelier updatedAtelier) {
        Atelier existingAtelier = atelierRepository.findById(id).orElse(null);
        if (existingAtelier != null) {
            // Mettez à jour les propriétés nécessaires
            existingAtelier.setNom(updatedAtelier.getNom());
            existingAtelier.setDateAtelier(updatedAtelier.getDateAtelier());
            existingAtelier.setLieu(updatedAtelier.getLieu());

            return atelierRepository.save(existingAtelier);
        }
        return null;
    }

    @Override
    public void deleteAtelier(Long id) {
        atelierRepository.deleteById(id);
    }
    

}
