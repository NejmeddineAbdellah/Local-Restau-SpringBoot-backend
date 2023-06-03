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

import ma.restaurant.projet.entity.Restau;
import ma.restaurant.projet.service.RestauService;

@RestController
@RequestMapping("api/restaus")
@CrossOrigin("*")
public class RestauController {

	@Autowired
	public RestauService restauService;

	@PostMapping("/save")
	public Restau save(@RequestBody Restau o) {
		return restauService.save(o);
	}

	@GetMapping("/")
	List<Restau> findAll() {
		return restauService.findAll();
	}

	@GetMapping("/restau/id/{id}")
	public Restau findById(@PathVariable int id) {
		return restauService.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Restau o) {
		restauService.update(o);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Restau o) {
		restauService.delete(o);
	}

	@GetMapping("/ville/zones/{nom}")
	public List<Restau> findRestauByZone(@PathVariable String nom) {
		return restauService.findRestauByZone(nom);
	}

	@GetMapping("/zone/{znom}/spec/{snom}")
	public List<Restau> findRestauBySpec(@PathVariable String znom, @PathVariable String snom) {
		return restauService.findRestauBySpec(znom, snom);
	}

	@GetMapping("/zone/{znom}/serie/{snom}")
	public List<Restau> findRestauBySerie(@PathVariable String znom, @PathVariable String snom) {
		return restauService.findRestauBySerie(znom, snom);
	}
	
	@GetMapping("/filter/{ville}/{zone}")
	public List<Restau> findRestauByVilleAndZone(@PathVariable String ville,@PathVariable String zone) {
		
		return restauService.findRestauByVilleAndZone(ville, zone);
	}
	
	@GetMapping("/filter2/{ville}/{zone}/{serie}")
	public List<Restau> findRestauByVilleAndZoneAndSerie(@PathVariable String ville,@PathVariable String zone,@PathVariable String serie) {
		
		return restauService.findRestauByVilleAndZoneAndSerie(ville,zone, serie);
	}

}
