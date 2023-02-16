package mx.edu.utez.Pokemon.utils;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Esta clase no forma parte de nuestro
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Response<T> {

    private T data;
    private boolean error;
    private int Status;
    private String message;



}
