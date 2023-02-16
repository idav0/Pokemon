package mx.edu.utez.Pokemon.controllers.trainer;

import mx.edu.utez.Pokemon.controllers.pokemon.dto.PokemonDto;
import mx.edu.utez.Pokemon.controllers.trainer.dto.TrainerDto;
import mx.edu.utez.Pokemon.models.pokemon.Pokemon;
import mx.edu.utez.Pokemon.models.trainer.Trainer;
import mx.edu.utez.Pokemon.services.trainer.TrainerService;
import mx.edu.utez.Pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokemon/trainer")
@CrossOrigin(origins = {"*"})
public class TrainerController {

    @Autowired
    private TrainerService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Trainer>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response<Trainer>> getById(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Trainer>> insert(@RequestBody TrainerDto trainer){
        return new ResponseEntity<>(
                this.service.insert(trainer.getTrainer()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Trainer>> update(@RequestBody TrainerDto trainer){
        return new ResponseEntity<>(
                this.service.update(trainer.getTrainer()),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Trainer>> delete(@PathVariable(value="id")Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }

}
