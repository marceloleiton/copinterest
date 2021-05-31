package cl.uv.ici.arq.pinterest.user.service;

import java.util.List;

import cl.uv.ici.arq.pinterest.user.dto.BoardsReqDTO;
import cl.uv.ici.arq.pinterest.user.dto.PinsReqDTO;
import cl.uv.ici.arq.pinterest.user.dto.UserDTO;
import cl.uv.ici.arq.pinterest.user.entities.BoardsReqEntity;

public interface UserService {

	public UserDTO createUser(UserDTO user);
	public UserDTO getUser(String user_name);
	public List<UserDTO> allUsers();

	public Boolean unfollowBoard(String boardID,String user_name);
	public BoardsReqEntity folowBoard(String user_name,String boardID);
	public BoardsReqDTO getUserBoards(String user_name);
	
	public PinsReqDTO getUserPins(String user_name);
	
}