package sectorservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sectorservice.controller.SectorController;
import sectorservice.model.Sector;

@SpringBootTest
class SectorServiceApplicationTests {
	
	@Autowired
	private SectorController sectorController;
	
	private Sector sector;
	
	@BeforeEach
	public void setUp() {
		sector = new Sector();
		sector.setSectorId(1);
		sector.setSectorDescription("Best sector in the world");
		sector.setMark("IT");
		sector.setSectorName("Information technologies");
	}

	@Test
	void saveSectorTest() {
		Sector newSector = sectorController.createSector(sector).getBody();
		assertEquals("IT", newSector.getMark());
	}
	
	@Test
	void findSectorsTest() {
		sectorController.createSector(sector).getBody();
		List<Sector> sectors = sectorController.getAllSectors().getBody();
		assertEquals(1, sectors.size());
	}
	
	@Test
	void findSectorByIdTest() {
		sectorController.createSector(sector).getBody();
		Sector findSector = sectorController.getSectorById(sector.getSectorId()).getBody();
		assertEquals(1, findSector.getSectorId());
	}

}
