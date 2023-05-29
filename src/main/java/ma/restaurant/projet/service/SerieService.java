package ma.restaurant.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.restaurant.projet.dao.IDAo;
import ma.restaurant.projet.entity.Serie;
import ma.restaurant.projet.repository.SerieRepository;

@Service
public class SerieService implements IDAo<Serie> {

	@Autowired
	SerieRepository serieRepository;

	@Override
	public Serie save(Serie o) {
		return serieRepository.save(o);
	}

	@Override
	public List<Serie> findAll() {
		return serieRepository.findAll();
	}

	@Override
	public Serie findById(int id) {
		return serieRepository.findById(id).get();
	}

	@Override
	public void update(Serie o) {
		serieRepository.save(o);
	}

	@Override
	public void delete(Serie o) {

	}

	public void deleteById(Integer id) {
		serieRepository.deleteById(id);
	}

}
