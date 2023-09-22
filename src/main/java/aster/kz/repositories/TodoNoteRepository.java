package aster.kz.repositories;

import aster.kz.models.entities.TodoNoteEntity;
import aster.kz.models.entities.UserEntity;
import aster.kz.models.enums.NoteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoNoteRepository extends JpaRepository<TodoNoteEntity, UUID> {

    List<TodoNoteEntity> findAllByUserAndNoteStatus(UserEntity user, NoteStatus status);

    TodoNoteEntity findByUserId(UUID id);
}
