package ma.restaurant.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.restaurant.projet.entity.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {

	Ville findByNom(String nom);
}
