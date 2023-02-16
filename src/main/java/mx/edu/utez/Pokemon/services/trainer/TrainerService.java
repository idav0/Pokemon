package mx.edu.utez.Pokemon.services.trainer;


import mx.edu.utez.Pokemon.models.trainer.Trainer;
import mx.edu.utez.Pokemon.models.trainer.TrainerRepository;
import mx.edu.utez.Pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainerService {

    @Autowired
    private TrainerRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Trainer>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<Trainer> getOne(Long id){
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
    public Response<Trainer> insert (Trainer trainer){

        Optional<Trainer> exists = this.repository.findById(trainer.getId()!=null?trainer.getId():0L);
        if(exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "El registro ya se encuentra registrada"
            );

        return new Response<>(
                this.repository.saveAndFlush(trainer),
                false,
                200,
                "Registro ingresado correctamente"
        );


    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<Trainer> update (Trainer trainer) {

        if (!this.repository.existsById(trainer.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El registro no se encontró"
            );

        return new Response<>(
                this.repository.saveAndFlush(trainer),
                false,
                200,
                "Registro actualizado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Trainer> delete (Long id) {

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
