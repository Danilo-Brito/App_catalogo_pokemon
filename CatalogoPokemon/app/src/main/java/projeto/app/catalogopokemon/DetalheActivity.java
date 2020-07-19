package projeto.app.catalogopokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import projeto.app.catalogopokemon.entities.Detalhe;
import projeto.app.catalogopokemon.entities.Pokemon;
import projeto.app.catalogopokemon.services.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalheActivity extends AppCompatActivity {

    RetrofitConfig retrofitConfig;
    TextView txtNome, txtBaseExperience;
    ImageView imgSprite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        this.txtNome = findViewById(R.id.txtNome);
        this.txtBaseExperience = findViewById(R.id.txtBaseExperience);
        this.imgSprite = findViewById(R.id.imgSprite);
        this.retrofitConfig = new RetrofitConfig();
        Pokemon pokemon = (Pokemon)getIntent().getSerializableExtra("pokemon");
        Call<Detalhe> call = this.retrofitConfig.getPokemonService().getDetalhe(pokemon.getName());
        call.enqueue(new Callback<Detalhe>() {
            @Override
            public void onResponse(Call<Detalhe> call, Response<Detalhe> response) {
                Detalhe detalhe = response.body();
                txtNome.setText(detalhe.getName());
                txtBaseExperience.setText(String.valueOf(detalhe.getBase_experience()));
                Picasso.get().load(detalhe.getSprites().getFront_shiny()).into(imgSprite);
            }

            @Override
            public void onFailure(Call<Detalhe> call, Throwable t) {
                Toast.makeText(DetalheActivity.this,"Erro ao consumir API.", Toast.LENGTH_LONG).show();
            }
        });
    }
}