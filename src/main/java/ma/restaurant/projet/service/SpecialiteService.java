package ma.restaurant.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.restaurant.projet.dao.IDAo;
import ma.restaurant.projet.entity.Specialite;
import ma.restaurant.projet.repository.SpecialiteRepository;

@Service
public class SpecialiteService implements IDAo<Specialite> {

	@Autowired
	SpecialiteRepository specialiteRepository;

	@Override
	public Specialite save(Specialite o) {
		return specialiteRepository.save(o);
	}

	@Override
	public List<Specialite> findAll() {
		return specialiteRepository.findAll();
	}

	@Override
	public Specialite findById(int id) {
		return specialiteRepository.findById(id).get();
	}

	@Override
	public void update(Specialite o) {
		specialiteRepository.save(o);
	}

	@Override
	public void delete(Specialite o) {
		specialiteRepository.delete(o);
	}

	public void deleteById(Integer id) {
		specialiteRepository.deleteById(id);
	}
}
