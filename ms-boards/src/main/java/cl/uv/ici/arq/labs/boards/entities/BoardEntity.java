package cl.uv.ici.arq.labs.boards.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users_boards")
public class BoardEntity {

    @Id
    @Column(name = "boardId", nullable = false, columnDefinition = "varchar(32)")
    @GeneratedValue
    private UUID  boardId;		

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "category", nullable = true)
    private String category;
    
    @Column(name = "description", nullable = true)
    private String description;
    
    
    @Column(name = "initial_pins", nullable = true)
    private String initial_pins;
    
    @Column(name = "images", nullable = true)
    private String images;
    
    @Column(name = "cover", nullable = true)
    private String cover;
    

}
