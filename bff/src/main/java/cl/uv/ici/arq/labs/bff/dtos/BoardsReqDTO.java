package cl.uv.ici.arq.labs.bff.dtos;
import java.util.List;

import lombok.Data;

@Data
public class BoardsReqDTO {

	public BoardsReqDTO() {

	}

	public BoardsReqDTO(String user_name, List<String> boards_list) {
		super();
		this.user_name = user_name;
		this.boards_list = boards_list;
	}

	private String user_name;
	private List<String> boards_list;
}