package transport.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor(force=true)
public class coach {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String productor;
	private String platenumber;
	private String color;
	private String model;
	private Long numberofseats;
	private Long usedyear;
	private Date lastrepair;
}