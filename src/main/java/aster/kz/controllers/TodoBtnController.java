package aster.kz.controllers;

import aster.kz.models.dtos.TodoNote;
import aster.kz.models.entities.TodoNoteEntity;
import aster.kz.models.enums.NoteStatus;
import aster.kz.servicies.impl.TodoNoteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TodoBtnController {

    private final TodoNoteServiceImpl todoNoteService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/add-btn")
    public String addButton() {
        return "addNote";
    }

    @PostMapping(value = "/delete-btn")
    public String deleteButton(@RequestParam UUID id, Model model, Principal principal) {
        todoNoteService.deleteNoteById(id);
        todoNoteService.getAllByUserAndStatus(NoteStatus.ACTIVE, model, principal);
        return "todoList";
    }

    @GetMapping(value = "/edit-btn")
    public String editButton(@RequestParam UUID id, Model model) {
        todoNoteService.findNoteById(id, model);
        return "updateNote";
    }

    @GetMapping(value = "/submit-note")
    public String submitNote(TodoNote todoNote, Principal principal) {
        TodoNoteEntity todoNoteEntity = modelMapper.map(todoNote, TodoNoteEntity.class);
        todoNoteService.saveNote(todoNoteEntity, principal);
        return "addNote";
    }

    @GetMapping(value = "/submit-note-edit")
    public String submitNoteEdit(TodoNote todoNote, Principal principal, Model model) {
        TodoNoteEntity todoNoteEntity = modelMapper.map(todoNote, TodoNoteEntity.class);
        todoNoteService.saveNote(todoNoteEntity, principal);
        todoNoteService.getAllByUserAndStatus(NoteStatus.ACTIVE, model, principal);
        return "todoList";
    }

    @GetMapping(value = "/update-status")
    public String updateStatus(@RequestParam UUID id, @RequestParam NoteStatus status, Model model) {
        todoNoteService.updateStatus(id, status, model);
        return "todoList";
    }
}
