package mx.edu.utez.Pokemon.controllers.pokemon;

import mx.edu.utez.Pokemon.controllers.pokemon.dto.PokemonDto;
import mx.edu.utez.Pokemon.models.pokemon.Pokemon;
import mx.edu.utez.Pokemon.services.pokemon.PokemonService;
import mx.edu.utez.Pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokemon/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> getById(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>> insert(@RequestBody PokemonDto category){
        return new ResponseEntity<>(
                this.service.insert(category.getPokemon()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Pokemon>> update(@RequestBody PokemonDto category){
        return new ResponseEntity<>(
                this.service.update(category.getPokemon()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> delete(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }


}
