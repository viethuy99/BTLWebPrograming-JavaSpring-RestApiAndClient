package transport.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "route")
@NoArgsConstructor(force=true)

public class route {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String finishpoint;
	private String startpoint;
	private Long distance;
	private Long difficult;
}