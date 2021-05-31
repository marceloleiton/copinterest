package cl.uv.ici.arq.labs.pins.dtos;


import lombok.Data;

@Data
public class PinsDTO {

	private String pinId;
	private String image;
	private String imageBase64;
	private String url;
	private String title;
	private Integer code;
		
}
