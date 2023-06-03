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
import ma.restaurant.projet.service.SpecialiteService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("api/specialite")
@CrossOrigin("*")
public class SpecialiteController {

	@Autowired
	SpecialiteService specialiteService;

	@PostMapping("/save")
	public Specialite save(@RequestBody Specialite o) {
		return specialiteService.save(o);
	}

	@GetMapping("/all")
	public List<Specialite> findAll() {
		return specialiteService.findAll();
	}

	@GetMapping("/id/{id}")
	public Specialite findById(@PathVariable int id) {
		return specialiteService.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Specialite o) {
		specialiteService.save(o);
	}

	@PutMapping("/update/id/{id}")
	public Specialite updateSpecialite(@PathVariable int id, @RequestBody Specialite specialite) {
		Specialite existingSpecialite = specialiteService.findById(id);
		if (existingSpecialite != null) {
			existingSpecialite.setNom(specialite.getNom());
			return specialiteService.save(existingSpecialite);
		}
		return null;
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Integer id) {
		specialiteService.deleteById(id);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Specialite o) {
		specialiteService.delete(o);
	}

}
