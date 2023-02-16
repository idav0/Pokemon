package mx.edu.utez.Pokemon.controllers.trainer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Pokemon.models.trainer.Trainer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TrainerDto {

    private Long id;

    private String name;

    private String team;

    public Trainer getTrainer() {
        return new Trainer(
                getId(),
                getName(),
                getTeam(),
                null
        );
    }

}
