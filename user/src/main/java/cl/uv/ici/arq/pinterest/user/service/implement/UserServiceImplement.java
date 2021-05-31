package cl.uv.ici.arq.pinterest.user.service.implement;

import java.util.List;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.uv.ici.arq.pinterest.user.dto.BoardsReqDTO;
import cl.uv.ici.arq.pinterest.user.dto.PinsReqDTO;
import cl.uv.ici.arq.pinterest.user.dto.UserDTO;
import cl.uv.ici.arq.pinterest.user.entities.BoardsReqEntity;
import cl.uv.ici.arq.pinterest.user.entities.UserEntity;
import cl.uv.ici.arq.pinterest.user.mapper.Mapper;
import cl.uv.ici.arq.pinterest.user.repositories.BoardReqRepository;
import cl.uv.ici.arq.pinterest.user.repositories.PinsReqRepository;
import cl.uv.ici.arq.pinterest.user.repositories.UserRepository;
import cl.uv.ici.arq.pinterest.user.service.UserService;

@Service("userService")
public class UserServiceImplement implements UserService {

	@Autowired
	UserRepository userRepository;
	
	private UserEntity mapUserEntity(UserDTO userDTO) {
		UserEntity user = new UserEntity();
		user.setUser_name(userDTO.getUser_name());
		user.setFirst_name(userDTO.getFirst_name());
		user.setLast_name(userDTO.getLast_name());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		UserEntity userEntity = this.mapUserEntity(userDTO);
		userEntity = this.userRepository.save(userEntity);
		userDTO = (UserDTO) Mapper.map(userEntity, UserDTO.class);
		return userDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDTO> allUsers() {
		return (List<UserDTO>) Mapper.mapAsList(userRepository.getAll(),
				new TypeToken<List<UserDTO>>() {
				}.getType());
	}

	@Override
	public UserDTO getUser(String user_name) {
		return (UserDTO) Mapper
				.map(this.userRepository.getByUName(user_name).get(0), UserDTO.class);
	}

	@Autowired
	private BoardReqRepository boardReqRepository;
	
	@Override
	public Boolean unfollowBoard(String board_id,String user_name) {
		boolean delete = true;
		this.boardReqRepository.deleteBoardID(board_id,user_name);
		return delete;
	}

	@Override
	public BoardsReqEntity folowBoard(String user_name,String board_id) {
		//boolean added = true;
		BoardsReqEntity boardEntity = new BoardsReqEntity(board_id,user_name);
		boardEntity = this.boardReqRepository.save(boardEntity);
		return boardEntity;
	}

	@Override
	public BoardsReqDTO getUserBoards(String user_name) {
		return new BoardsReqDTO(user_name, (boardReqRepository.getBoardsByUName(user_name)));
	}

	@Autowired
	PinsReqRepository pinRepository;
	
	@Override
	public PinsReqDTO getUserPins(String user_name) {
		return new PinsReqDTO(user_name, (pinRepository.getBoardsByUName(user_name)));
	}
	

}
