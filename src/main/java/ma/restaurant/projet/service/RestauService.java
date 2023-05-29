package ma.restaurant.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.restaurant.projet.dao.IDAo;
import ma.restaurant.projet.entity.Restau;
import ma.restaurant.projet.entity.Zone;
import ma.restaurant.projet.repository.RestauRepository;

@Service
public class RestauService implements IDAo<Restau> {

	@Autowired
	public RestauRepository restauRepository;

	@Autowired
	public ZoneService zoneService;

	@Override
	public Restau save(Restau o) {
		return restauRepository.save(o);
	}

	@Override
	public List<Restau> findAll() {
		return restauRepository.findAll();
	}

	@Override
	public Restau findById(int id) {
		return restauRepository.findById(id).get();
	}

	@Override
	public void update(Restau o) {
		restauRepository.save(o);
	}

	@Override
	public void delete(Restau o) {
		restauRepository.delete(o);
	}

	public List<Restau> findRestauByZone(String nom) {
		Zone zone = zoneService.findByNom(nom);
		return zone.getRestau();

	}

	public List<Restau> findRestauBySpec(String znom, String snom) {
		return restauRepository.findRestauBySpec(znom, snom);
	}

	public List<Restau> findRestauBySerie(String znom, String snom) {
		return restauRepository.findRestauBySerie(znom, snom);
	}

	public List<Restau> findRestauByVilleAndZone(String ville, String zone) {

		return restauRepository.findRestauByVilleAndZone(ville, zone);
	}

	public List<Restau> findRestauByVilleAndZoneAndSerie(String ville, String zone, String serie) {

		return restauRepository.findRestauByVilleAndZoneAndSerie(ville, zone, serie);
	}
}
