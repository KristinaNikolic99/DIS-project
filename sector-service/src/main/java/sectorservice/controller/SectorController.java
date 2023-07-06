package sectorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sectorservice.model.Sector;
import sectorservice.service.SectorService;

@RestController
@RequestMapping(value = "api/sector")
public class SectorController {

	@Autowired
	private SectorService sectorService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Sector>> getAllSectors() {
		return new ResponseEntity<List<Sector>>(sectorService.getAllSectors(), HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Sector> getSectorById(@PathVariable("id") long sectorId) {
		Sector sector = sectorService.getSectorById(sectorId);
		if(sector != null) {
			return new ResponseEntity<Sector>(sector, HttpStatus.OK);
		}
		return new ResponseEntity<Sector>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Sector> createSector(@RequestBody Sector sector) {
		Sector newSector = sectorService.createSector(sector);
		if(newSector == null) {
			return new ResponseEntity<Sector>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Sector>(newSector, HttpStatus.CREATED);
	}
}
