package aster.kz.models.dtos;

import aster.kz.models.entities.UserEntity;
import aster.kz.models.enums.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoNote {

    private UUID id;
    private String title;
    private String description;
    private String color;
    private NoteStatus noteStatus;
    private UserEntity user;

}
