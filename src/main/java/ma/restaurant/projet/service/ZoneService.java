package ma.restaurant.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.restaurant.projet.dao.IDAo;
import ma.restaurant.projet.entity.Ville;
import ma.restaurant.projet.entity.Zone;
import ma.restaurant.projet.repository.ZoneRepository;

@Service
public class ZoneService implements IDAo<Zone> {

	@Autowired
	public ZoneRepository zoneRepository;

	@Autowired
	public VilleService villeService;

	@Override
	public Zone save(Zone o) {
		return zoneRepository.save(o);
	}

	@Override
	public List<Zone> findAll() {
		return zoneRepository.findAll();
	}

	@Override
	public Zone findById(int id) {
		return zoneRepository.findById(id).get();
	}

	@Override
	public void update(Zone o) {
		zoneRepository.save(o);
	}

	@Override
	public void delete(Zone o) {
		zoneRepository.delete(o);
	}

	public void deleteById(Integer id) {
		zoneRepository.deleteById(id);
	}

	public List<Zone> findZoneByVille(String nom) {
		Ville ville = villeService.findByName(nom);
		return ville.getZone();
	}

	public Zone findByNom(String nom) {
		return zoneRepository.findByNom(nom);
	}

}
