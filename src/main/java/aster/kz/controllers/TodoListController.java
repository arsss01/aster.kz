package aster.kz.controllers;

import aster.kz.models.enums.NoteStatus;
import aster.kz.servicies.TodoNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TodoListController {

    private final TodoNoteService todoNoteService;

    @RequestMapping(path = "/todo", method = {RequestMethod.GET, RequestMethod.POST})
    public String PassingNotesListGet(@RequestParam (required = false) NoteStatus status, Model model, Principal principal) {
        if (status == null) {
            status = NoteStatus.ACTIVE;
        }
        todoNoteService.getAllByUserAndStatus(status, model, principal);
        return "todoList";
    }

    @GetMapping(value="/details")
    public String findNoteDetails(@RequestParam UUID id, Model model) {

        todoNoteService.findNoteDetails(id, model);
        return "noteDetails";
    }
}
