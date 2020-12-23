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
@Table(name = "travel")
@NoArgsConstructor(force=true)

public class travel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String drivername;
	private String extradrivername;
	private Long totalcustomer;
	private Long priceticket;
	private long routeid;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getDrivername() {
//		return drivername;
//	}
//	public void setDrivername(String drivername) {
//		this.drivername = drivername;
//	}
//	public String getExtradrivername() {
//		return extradrivername;
//	}
//	public void setExtradrivername(String extradrivername) {
//		this.extradrivername = extradrivername;
//	}
//	public Long getTotalcustomer() {
//		return totalcustomer;
//	}
//	public void setTotalcustomer(Long totalcustomer) {
//		this.totalcustomer = totalcustomer;
//	}
//	public Long getPriceticket() {
//		return priceticket;
//	}
//	public void setPriceticket(Long priceticket) {
//		this.priceticket = priceticket;
//	}
//	public long getRouteid() {
//		return routeid;
//	}
//	public void setRouteid(long routeid) {
//		this.routeid = routeid;
//	}

}