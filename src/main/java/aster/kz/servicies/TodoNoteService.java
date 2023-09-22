package aster.kz.servicies;

import aster.kz.models.enums.NoteStatus;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.UUID;

public interface TodoNoteService {
    void getAllByUserAndStatus(NoteStatus status, Model model, Principal principal);

    void findNoteDetails(UUID id, Model model);
}
