package projeto.app.catalogopokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import projeto.app.catalogopokemon.adapters.PokemonAdapter;
import projeto.app.catalogopokemon.entities.Pokemon;
import projeto.app.catalogopokemon.entities.Request;
import projeto.app.catalogopokemon.services.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RetrofitConfig retrofitConfig;
    ListView lvPokemons;
    List<Pokemon> lstPokemon;
    PokemonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.lvPokemons = findViewById(R.id.lvPokemons);
        this.lstPokemon = new ArrayList<>();
        this.retrofitConfig = new RetrofitConfig();
        this.adapter = new PokemonAdapter(this,lstPokemon);
        this.lvPokemons.setAdapter(adapter);
        Call<Request> call = this.retrofitConfig.getPokemonService().getAll();
        call.enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {
                Request request = response.body();
                lstPokemon.clear();
                lstPokemon.addAll(request.getResults());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Request> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Erro ao consumir API.", Toast.LENGTH_LONG).show();

            }
        });
    }
}