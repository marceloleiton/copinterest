package cl.uv.ici.arq.labs.bff.dtos;

import java.util.List;


import lombok.Data;

@Data
public class PinsReqDTO {
	
	public PinsReqDTO() {

	}

	public PinsReqDTO(String boardId, List<String> pins_list) {
		super();
		this.boardId = boardId;
		this.pins_list = pins_list;
	}

	private String boardId;
	private List<String> pins_list;
}