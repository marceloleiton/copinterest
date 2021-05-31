package cl.uv.ici.arq.labs.boards.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.uv.ici.arq.labs.boards.entities.PinsReqEntity;


@Repository("pinReqRepository")
public interface PinsReqRepository extends JpaRepository<PinsReqEntity, UUID> {
	
	@Query(value = "SELECT DISTINCT(pin_id) FROM boards_pins WHERE BOARD_ID = :boardId", nativeQuery = true)
	    public List<String> getBoardsByUName(String boardId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM boards_pins where pin_id = :pin_id and BOARD_ID = :boardId", nativeQuery = true)
	 	public void deletePinID(String pin_id,String boardId);
}