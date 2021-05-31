package cl.uv.ici.arq.labs.boards.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.uv.ici.arq.labs.boards.entities.BoardEntity;


@Repository("boardRepository")
public interface BoardRepository extends JpaRepository<BoardEntity, UUID> {

    @Query(value = "SELECT * FROM users_boards", nativeQuery = true)
    public List<BoardEntity> getAll();
    
}