package cl.uv.ici.arq.pinterest.user.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.uv.ici.arq.pinterest.user.entities.PinsReqEntity;


@Repository("pinReqRepository")
public interface PinsReqRepository extends JpaRepository<PinsReqEntity, UUID> {
	
	@Query(value = "SELECT DISTINCT(pin_id) FROM user_pins WHERE user_name = :user_name", nativeQuery = true)
	    public List<String> getBoardsByUName(String user_name);

}