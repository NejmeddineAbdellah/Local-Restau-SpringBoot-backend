package ma.restaurant.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.restaurant.projet.entity.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	List<Zone> findZoneByVille(String nom);

	Zone findByNom(String nom);

	List<Zone> findByVilleId(int id);

}
