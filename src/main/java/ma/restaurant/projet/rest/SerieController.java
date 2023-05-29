package ma.restaurant.projet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.restaurant.projet.entity.Serie;
import ma.restaurant.projet.service.SerieService;

@RestController
@RequestMapping("api/series")
public class SerieController {

	@Autowired
	SerieService serieService;

	@PostMapping("/save")
	public Serie save(@RequestBody Serie o) {
		return serieService.save(o);
	}

	@GetMapping("/all")
	public List<Serie> findAll() {
		return serieService.findAll();
	}

	@GetMapping("/id/{id}")
	public Serie findById(@PathVariable int id) {
		return serieService.findById(id);
	}

	@PutMapping("/update/id/{id}")
	public Serie update(@PathVariable int id, @RequestBody Serie o) {
		Serie existingSerie = serieService.findById(id);
		if (existingSerie != null) {
			existingSerie.setNom(o.getNom());
			return serieService.save(existingSerie);
		}
		return null;
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Integer id) {
		serieService.deleteById(id);

	}

}
