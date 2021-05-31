package cl.uv.ici.arq.labs.bff.dtos;

import lombok.Data;

@Data
public class UserDTO {
	
	private String  user_name;
	private String  first_name;
	private String  last_name;
	private String  email;
	private Integer phone;
	private String  password;
}