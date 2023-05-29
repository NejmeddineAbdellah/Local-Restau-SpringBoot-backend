package ma.restaurant.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.restaurant.projet.dao.IDAo;
import ma.restaurant.projet.entity.Ville;
import ma.restaurant.projet.entity.Zone;
import ma.restaurant.projet.repository.VilleRepository;
import ma.restaurant.projet.repository.ZoneRepository;

@Service
public class VilleService implements IDAo<Ville> {

	@Autowired
	public VilleRepository villeRepository;
	@Autowired
	ZoneRepository zoneRepository;

	@Override
	public Ville save(Ville o) {
		return villeRepository.save(o);
	}

	@Override
	public List<Ville> findAll() {

		return villeRepository.findAll();
	}

	@Override
	public Ville findById(int id) {
		return villeRepository.findById(id).get();
	}

	@Override
	public void update(Ville o) {
		villeRepository.save(o);
	}

	@Override
	public void delete(Ville t) {
		List<Zone> z1 = zoneRepository.findByVilleId(t.getId());
		for (Zone z : z1) {

			zoneRepository.delete(z);
		}

		villeRepository.delete(t);
	}

	public long count() {
		return villeRepository.count();
	}

	public void deleteById(Integer id) {
		List<Zone> z1 = zoneRepository.findByVilleId(id);
		for (Zone z : z1) {

			zoneRepository.delete(z);
		}

		villeRepository.deleteById(id);
	}

	public Ville findByName(String nom) {
		return villeRepository.findByNom(nom);
	}

}
