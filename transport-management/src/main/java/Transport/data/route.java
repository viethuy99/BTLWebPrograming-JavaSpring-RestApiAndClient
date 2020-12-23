package Transport.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force=true)
public class route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String finishpoint;
	private String startpoint;
	private Long distance;
	private Long difficult;
}
//create table if not exists route(
//id int(11) primary key auto_increment,
//finishPoint varchar(55) not null,
//startPoint varchar(55) not null,
//distance int(11) not null,
//difficult int(11) not null
//);