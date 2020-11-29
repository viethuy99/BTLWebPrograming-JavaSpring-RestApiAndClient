package Transport;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
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
//create table if not exists driver(
//		id int(11) primary key auto_increment,
//		driverName varchar(55) not null,
//		idCard int not null,
//		driverCode varchar(55) not null,
//		license varchar(55) not null,
//	    address varchar(55),
//		birth date,
//		seriority int(11) not null
//	);

