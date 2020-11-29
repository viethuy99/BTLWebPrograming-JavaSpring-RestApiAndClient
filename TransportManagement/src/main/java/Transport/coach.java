package Transport;

import lombok.Data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class coach {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	private String productor;
	private String platenumber;
	private String color;
	private String model;
	private Long numberofseats;
	private Long usedyear;
	private Date lastrepair;
}