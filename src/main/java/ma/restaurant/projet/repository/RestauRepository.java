package ma.restaurant.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.restaurant.projet.entity.Restau;

public interface RestauRepository extends JpaRepository<Restau, Integer> {

	List<Restau> findRestauByZone(String nom);

	@Query("select distinct r from Restau r join r.specialite s join r.zone z where z.nom =:znom and s.nom =:snom")
	List<Restau> findRestauBySpec(@Param("znom") String znom, @Param("snom") String snom);

	@Query("select distinct r from Restau r where r.zone.nom =:znom and r.serie.nom =:snom")
	List<Restau> findRestauBySerie(@Param("znom") String znom, @Param("snom") String snom);
	
	@Query("SELECT r FROM Restau r JOIN r.zone z JOIN z.ville v WHERE v.nom =?1 AND z.nom =?2")
	 List<Restau> findRestauByVilleAndZone(String ville, String zone);
	
	@Query("SELECT r FROM Restau r JOIN r.zone z JOIN z.ville  v JOIN r.serie s WHERE v.nom =?1 AND z.nom =?2 and s.nom=?3")
	 List<Restau> findRestauByVilleAndZoneAndSerie(String ville, String zone,String serie);

}
