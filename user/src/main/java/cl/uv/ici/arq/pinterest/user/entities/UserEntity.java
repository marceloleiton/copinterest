package cl.uv.ici.arq.pinterest.user.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {	

    @Id
    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "phone", nullable = true)
    private String phone;
    
    @Column(name = "password", nullable = false)
    private String password;
}