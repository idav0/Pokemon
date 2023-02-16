package mx.edu.utez.Pokemon.controllers.pokemon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Pokemon.models.pokemon.Pokemon;
import mx.edu.utez.Pokemon.models.trainer.Trainer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {


    private Long id;

    private String name;

    private String type;

    private int powerLevel;

    private int healthPoints;

    private int attackPoints;

    private int defensePoints;

    private Trainer trainer;

    public Pokemon getPokemon(){
        return new Pokemon(
                getId(),
                getName(),
                getType(),
                getPowerLevel(),
                getHealthPoints(),
                getAttackPoints(),
                getDefensePoints(),
                getTrainer()
        );
    }

}
