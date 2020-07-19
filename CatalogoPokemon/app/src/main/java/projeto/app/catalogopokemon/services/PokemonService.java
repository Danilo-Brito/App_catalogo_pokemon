package projeto.app.catalogopokemon.services;

import projeto.app.catalogopokemon.entities.Detalhe;
import projeto.app.catalogopokemon.entities.Request;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    @GET("pokemon")
    Call<Request> getAll();

    @GET("pokemon/{nomeDoPokemon}")
    Call<Detalhe> getDetalhe(@Path("nomeDoPokemon") String nomeDoPokemon);
    
}
