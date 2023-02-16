package mx.edu.utez.Pokemon.models.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Pokemon.models.trainer.Trainer;

import javax.persistence.*;

@Entity
@Table(name="pokemon")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(nullable = false, unique = false, length = 150)
    private String type;

    @Column(nullable = false, unique = false, length = 150)
    private int powerLevel;

    @Column(nullable = false, unique = false, length = 150)
    private int healthPoints;

    @Column(nullable = false, unique = false, length = 150)
    private int attackPoints;

    @Column(nullable = false, unique = false, length = 150)
    private int defensePoints;


    @ManyToOne
    @JoinColumn(name="trainer_id",nullable = false)
    private Trainer trainer;


}
