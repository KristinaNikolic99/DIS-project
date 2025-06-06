package sectorservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sectorservice.model.Sector;
import sectorservice.repository.SectorRepository;

@Service
public class SectorService {

	@Autowired
	private SectorRepository sectorRepository;
	
	public List<Sector> getAllSectors() {
		return sectorRepository.findAll();
	}
	
	public Sector getSectorById(long sectorId) {
		return sectorRepository.findById(sectorId).orElse(null);
	}
	
	public Sector createSector(Sector sector) {
		return sectorRepository.save(sector);
	}
}
