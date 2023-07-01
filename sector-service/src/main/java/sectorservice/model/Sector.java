package sectorservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Sector {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sectorId;
	@Column(name = "sector_name")
	private String sectorName;
	private String mark;
	@Column(name = "sector_description")
	private String sectorDescription;
}
