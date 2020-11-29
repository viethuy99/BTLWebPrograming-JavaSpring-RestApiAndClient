package transport.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "driver")
@NoArgsConstructor(force=true)
public class driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String drivername;
	private Long idcard;
	private String drivercode;
	private String license;
	private String address;
	private Date birth;
	private Long serniority;

}
