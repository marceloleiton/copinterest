package cl.uv.ici.arq.pinterest.user.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "user_pins")
public class PinsReqEntity {

	public PinsReqEntity() {
	}
	
	public PinsReqEntity(String pin_id, String user_name) {
		this.pin_id = pin_id;
		this.user_name = user_name;
	}

	@Id
	@Column(name = "id", nullable = false, columnDefinition = "varchar(16)")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name = "user_name", nullable = false)
	private String user_name;

	@Column(name = "pin_id", nullable = false)
	private String pin_id;
}
