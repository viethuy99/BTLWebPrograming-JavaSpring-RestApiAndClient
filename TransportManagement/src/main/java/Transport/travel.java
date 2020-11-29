package Transport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class travel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String drivername;
	private String extradrivername;
	private Long totalcustomer;
	private Long routeid;

}

//create table if not exists travel(
//	id int(11) primary key auto_increment,
//    driverName varchar(55) not null,
//    extraDriverName varchar(55) not null,
//    totalCustomer int(11) not null,
//    priceTicket int(20) not null,
//	route_id int(11) not null
//
//);