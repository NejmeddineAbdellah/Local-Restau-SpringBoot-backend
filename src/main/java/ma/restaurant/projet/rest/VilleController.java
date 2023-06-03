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

import ma.restaurant.projet.entity.Specialite;
import ma.restaurant.projet.entity.Ville;
import ma.restaurant.projet.service.VilleService;

@RestController
@RequestMapping("api/villes")
@CrossOrigin("*")
public class VilleController {

	@Autowired
	public VilleService villeService;

	@PostMapping("/save")
	public Ville save(@RequestBody Ville o) {
		return villeService.save(o);
	}

	@GetMapping("/")
	public List<Ville> findAll() {
		return villeService.findAll();
	}

	@GetMapping("/count")
	public long count() {
		return villeService.count();
	}

	@GetMapping("/id/{id}")
	public Ville findById(@PathVariable int id) {
		return villeService.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Ville o) {
		villeService.update(o);
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Integer id) {
		villeService.deleteById(id);
	}

	@PutMapping("/update/id/{id}")
	public Ville updateVille(@PathVariable int id, @RequestBody Ville ville) {
		Ville existingVille = villeService.findById(id);
		if (existingVille != null) {
			existingVille.setNom(ville.getNom());
			return villeService.save(existingVille);
		}
		return null;
	}

}
