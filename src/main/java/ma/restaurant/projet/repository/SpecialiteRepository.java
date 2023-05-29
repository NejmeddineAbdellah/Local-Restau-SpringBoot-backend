package ma.restaurant.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.restaurant.projet.entity.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

}
