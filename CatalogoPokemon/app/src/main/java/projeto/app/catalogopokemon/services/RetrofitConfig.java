package projeto.app.catalogopokemon.services;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    Retrofit retrofit;
    private static final String BASE_PATH = "https://pokeapi.co/api/v2/";
    public RetrofitConfig(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_PATH).addConverterFactory(JacksonConverterFactory.create()).build();

    }

    public PokemonService getPokemonService(){
        return retrofit.create(PokemonService.class);
    }
}
