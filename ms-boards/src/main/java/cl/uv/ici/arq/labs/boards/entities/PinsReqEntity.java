package cl.uv.ici.arq.labs.boards.entities;

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
@Table(name = "boards_pins")
public class PinsReqEntity {

	public PinsReqEntity() {
		
	}
	
	public PinsReqEntity(String pin_id, String boardId) {
		this.pin_id = pin_id;
		this.boardId = boardId;
	}
	
    @Id
	@Column(name = "id", nullable = false, columnDefinition = "varchar(32)")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID  id;		

    @Column(name = "boardId", nullable = false)
    private String boardId;

    @Column(name = "pin_id", nullable = false)
    private String pin_id;

    

}
