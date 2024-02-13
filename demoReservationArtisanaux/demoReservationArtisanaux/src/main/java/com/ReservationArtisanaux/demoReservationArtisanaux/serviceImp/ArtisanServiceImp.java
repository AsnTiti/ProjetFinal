package com.ReservationArtisanaux.demoReservationArtisanaux.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReservationArtisanaux.demoReservationArtisanaux.entity.Artisan;
import com.ReservationArtisanaux.demoReservationArtisanaux.repository.ArtisanRepository;
import com.ReservationArtisanaux.demoReservationArtisanaux.services.ArtisanService;
@Service
public class ArtisanServiceImp implements ArtisanService {
   
	
	/* private final ArtisanRepository artisanRepository; // Déclaration du repository pour les produits.

	    @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de
	    //ProduitRepository.
	    public ArtisanServiceImp(ArtisanRepository artisanRepository) {
	    	// Affectation du repository injecté au champ de la classe.
	        this.artisanRepository = artisanRepository; 
	    }
	    
	    public Artisan saveArtisan(Artisan artisan) {
	        return artisanRepository.save(artisan); // Appel du repository pour enregistrer le produit.
	    }
	    
	     // Implémentation de la méthode pour obtenir un produit par son ID.
	    public Optional<Artisan> getArtisanById(int id) {
	        return artisanRepository.findById((long) id); // Appel du repository pour trouver le produit.
	    }
	    // Implémentation de la méthode pour obtenir tous les produits.
	    public List<Artisan> getAllArtisans() {
	        return artisanRepository.findAll(); // Appel du repository pour obtenir tous les produits.
	    }*/
	@Autowired
    private ArtisanRepository artisanRepository;

	public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }

    @Override
    public Artisan getArtisanById(Long id) {
        return artisanRepository.findById(id).orElse(null);
    }

    @Override
    public Artisan createArtisan(Artisan artisan) {
        return artisanRepository.save(artisan);
    }

    @Override
    public Artisan updateArtisan(Long id, Artisan updatedArtisan) {
        Artisan existingArtisan = artisanRepository.findById(id).orElse(null);
        if (existingArtisan != null) {
            // Mettez à jour les propriétés nécessaires
            existingArtisan.setNom(updatedArtisan.getNom());
            existingArtisan.setEmail(updatedArtisan.getEmail());
            existingArtisan.setTelephone(updatedArtisan.getTelephone());

            return artisanRepository.save(existingArtisan);
        }
        return null;
    }

    @Override
    public void deleteArtisan(Long id) {
        artisanRepository.deleteById(id);
    }

}


