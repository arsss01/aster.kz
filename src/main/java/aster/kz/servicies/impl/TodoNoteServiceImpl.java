package aster.kz.servicies.impl;

import aster.kz.models.entities.TodoNoteEntity;
import aster.kz.models.enums.NoteStatus;
import aster.kz.repositories.TodoNoteRepository;
import aster.kz.models.entities.UserEntity;
import aster.kz.repositories.UserRepository;
import aster.kz.servicies.TodoNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TodoNoteServiceImpl implements TodoNoteService {

    private final UserRepository userRepository;
    private final TodoNoteRepository todoNoteRepository;

    public void getAllByUserAndStatus(NoteStatus status, Model model, Principal principal) {
        UserEntity user = userRepository.findByUsername(principal.getName());
        List<TodoNoteEntity> currentUsersNotes = todoNoteRepository.findAllByUserAndNoteStatus(user, status);
        model.addAttribute("currentUsersNotes", currentUsersNotes);
    }

    @Override
    public void findNoteDetails(UUID id, Model model) {
        Optional<TodoNoteEntity> noteDetails = todoNoteRepository.findById(id);
        model.addAttribute("noteDetails", Arrays.asList(noteDetails.get()));
        todoNoteRepository.findById(id);
    }

    public void deleteNoteById(UUID id) {
        todoNoteRepository.deleteById(id);
    }

    public void findNoteById(UUID id, Model model) {
        TodoNoteEntity noteEdit = todoNoteRepository.findById(id).get();
        model.addAttribute("NoteEdit", noteEdit);
    }

    public void saveNote(TodoNoteEntity todoNoteEntity, Principal principal) {

        todoNoteEntity.setUser(userRepository.findByUsername(principal.getName()));
        if (todoNoteEntity.getId() == null) {
            todoNoteEntity.setCreatedAt(new Date());
            todoNoteEntity.setNoteStatus(NoteStatus.ACTIVE);
        } else {
            Optional<TodoNoteEntity> todoEntity = todoNoteRepository.findById(todoNoteEntity.getId());
            todoEntity.ifPresent(noteEntity -> {
                todoNoteEntity.setCreatedAt(noteEntity.getCreatedAt());
                todoNoteEntity.setNoteStatus(noteEntity.getNoteStatus());
            });
        }
        todoNoteEntity.setUpdatedAt(new Date());
        todoNoteRepository.save(todoNoteEntity);
    }

    public void updateStatus(UUID id, NoteStatus status, Model model) {
        Optional<TodoNoteEntity> note = todoNoteRepository.findById(id);
        note.get().setNoteStatus(status);
        todoNoteRepository.save(note.get());
//        model.addAttribute()
    }
}
