package aster.kz.models.entities;

import aster.kz.models.enums.NoteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo_list")
public class TodoNoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;
    private String title;
    private String description;
    private String color;
    @Enumerated(EnumType.STRING)
    private NoteStatus noteStatus;
    @ManyToOne
    private UserEntity user;

    private Date createdAt;
    private Date updatedAt;
    private Date remindAt;
    private Date expiredAt;
}
