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
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.restaurant.projet.entity.Ville;
import ma.restaurant.projet.entity.Zone;
import ma.restaurant.projet.service.VilleService;
import ma.restaurant.projet.service.ZoneService;

@RestController
@CrossOrigin("*")
@RequestMapping("api/zones")
public class ZoneController {

	@Autowired
	public ZoneService zoneService;
	
	@Autowired
	public VilleService villeService;

	@PostMapping("/save")
	public Zone save(@RequestBody Zone o) {
		return zoneService.save(o);
	}

	@GetMapping("/")
	public List<Zone> findAll() {
		return zoneService.findAll();
	}

	@GetMapping("/id/{id}")
	public Zone findById(@PathVariable int id) {
		return zoneService.findById(id);
	}

	@PutMapping("/update/id/{id}")
		Zone update(@PathVariable int id, @RequestBody Zone zone) {
		Zone existingzone = zoneService.findById(id);
		Ville v = villeService.findById(zone.getVille().getId());
        if (existingzone!=null) {
        	existingzone.setNom(zone.getNom());
        	existingzone.setVille(v);
            return zoneService.save(existingzone);
        }
        return null;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Zone o) {
		zoneService.delete(o);	
	}

	@DeleteMapping("/delete/id/{id}")
	public void deleteById(@PathVariable Integer id) {
		zoneService.deleteById(id);
	}

	@GetMapping("/ville/zones/{nom}")
	public List<Zone> findZoneByVille(@PathVariable String nom) {
		return zoneService.findZoneByVille(nom);
	}

}
