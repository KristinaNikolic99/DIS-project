package sectorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
