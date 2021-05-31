package cl.uv.ici.arq.pinterest.user.dto;

import java.util.List;


import lombok.Data;

@Data
public class PinsReqDTO {
	
	public PinsReqDTO() {

	}

	public PinsReqDTO(String user_name, List<String> pins_list) {
		super();
		this.user_name = user_name;
		this.pin_list = pins_list;
	}

	private String user_name;
	private List<String> pin_list;
}
