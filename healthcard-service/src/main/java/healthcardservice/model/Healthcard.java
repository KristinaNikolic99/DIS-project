package healthcardservice.model;

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
public class Healthcard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long healthcardId;
	@Column(name = "healthcard_number")
	private String healthcardNumber;
	@Column(name = "healthcard_gender")
	private String healthcardGender;
	@Column(name = "healthcard_blood")
	private String healthcardBlood;
}
