package mx.edu.utez.Pokemon.services.pokemon;

import mx.edu.utez.Pokemon.models.pokemon.Pokemon;
import mx.edu.utez.Pokemon.models.pokemon.PokemonRepository;
import mx.edu.utez.Pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Pokemon>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<Pokemon> getOne(Long id){
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "El registro no se encontró"
        );

    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert (Pokemon pokemon){

        Optional<Pokemon> exists = this.repository.findById(pokemon.getId()!=null?pokemon.getId():0L);
        if(exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "El registro ya se encuentra registrada"
            );

        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Registro ingresado correctamente"
        );


    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update (Pokemon pokemon) {

        if (!this.repository.existsById(pokemon.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El registro no se encontró"
            );

        return new Response<>(
                this.repository.saveAndFlush(pokemon),
                false,
                200,
                "Registro actualizado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> delete (Long id) {

        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return new Response<>(
                    null,
                    false,
                    200,
                    "Registro eliminado correctamente"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "El registro no se encontró"
        );
    }




}
