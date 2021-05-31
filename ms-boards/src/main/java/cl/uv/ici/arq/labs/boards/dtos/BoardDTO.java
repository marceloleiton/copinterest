package cl.uv.ici.arq.labs.boards.dtos;

import lombok.Data;

@Data
public class BoardDTO {

	private String boardId;
	private String name;
	private String category;
	private String description;
	private String initial_pins;
	private String images;
	private String cover;
	
}
