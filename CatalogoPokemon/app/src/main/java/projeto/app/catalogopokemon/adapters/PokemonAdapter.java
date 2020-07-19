package projeto.app.catalogopokemon.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import projeto.app.catalogopokemon.DetalheActivity;
import projeto.app.catalogopokemon.R;
import projeto.app.catalogopokemon.entities.Pokemon;

public class PokemonAdapter extends BaseAdapter {
    private Context context;
    private List<Pokemon> lstPokemon;

    public PokemonAdapter(Context context, List<Pokemon> lstPokemon) {
        this.context = context;
        this.lstPokemon = lstPokemon;
    }

    @Override
    public int getCount() {
        return lstPokemon.size();
    }

    @Override
    public Object getItem(int position) {
        return lstPokemon.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View minhaView = LayoutInflater.from(context).inflate(R.layout.pokemon_item,parent,false);
        TextView txtNome = minhaView.findViewById(R.id.txtNome);
        Pokemon pokemon = this.lstPokemon.get(position);
        txtNome.setText(pokemon.getName());
        minhaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, DetalheActivity.class);
                it.putExtra("pokemon",pokemon);
                context.startActivity(it);
            }
        });
        return minhaView;
    }
}
