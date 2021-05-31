package cl.uv.ici.arq.pinterest.user.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.uv.ici.arq.pinterest.user.entities.BoardsReqEntity;


@Repository("boardReqRepository")
public interface BoardReqRepository extends JpaRepository<BoardsReqEntity, UUID> {
	
	@Query(value = "SELECT DISTINCT(board_id) FROM user_boards WHERE user_name = :user_name", nativeQuery = true)
	    public List<String> getBoardsByUName(String user_name);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM user_boards where board_id = :board_id and user_name = :user_name", nativeQuery = true)
	 	public void deleteBoardID(String board_id,String user_name);
}