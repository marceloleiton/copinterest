package cl.uv.ici.arq.labs.pins.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users_pins")
public class PinsEntity {

    @Id
    @Column(name = "pinId", nullable = false, columnDefinition = "varchar(32)")
    @GeneratedValue
    private UUID  pinId;		

    @Column(name = "image", nullable = true)
    private String image;

    @Column(name = "imageBase64", nullable = true)
    private String imageBase64;
    
    @Column(name = "url", nullable = true)
    private String url;
    
    
    @Column(name = "title", nullable = true)
    private String title;
    
    @Column(name = "code", nullable = true)
    private Integer code;
    
   
}