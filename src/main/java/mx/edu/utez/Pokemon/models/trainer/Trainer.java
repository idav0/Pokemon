package mx.edu.utez.Pokemon.models.trainer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Pokemon.models.pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="trainer")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(nullable = false, unique = false, length = 150)
    private String team;


    @OneToMany(mappedBy = "trainer")
    @JsonIgnore
    private List<Pokemon> pokemons;

}
