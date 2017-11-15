package com.example.usuario.chucknorris;
/**
 * Created by Usuario on 14/11/2017.
 */
import retrofit2.Call;
import retrofit2.http.GET;

public interface interfazChistaco {

    public interface Getchistaco {
        @GET("Jokes/random")
        Call<chiste> getChiste();
    }
}
