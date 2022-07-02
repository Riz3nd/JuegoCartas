package com.riz3nd.juegocartas.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riz3nd.juegocartas.R;
import com.riz3nd.juegocartas.entity.Pokemon;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder>{
    private LayoutInflater mInflate;
    private Context context;
    private List<Pokemon> mPokeList;
    private int contCard = 0;
    private int contCardFalse = 0;
    private int oldID = 0;

    public RecyclerAdapter(Context context, List<Pokemon> list){
        this.mInflate = LayoutInflater.from(context);
        this.context = context;
        this.mPokeList = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.card_recycler, null);
        return new RecyclerAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.viewHolder holder, int position) {
        holder.bindData(mPokeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPokeList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgview;
        public viewHolder(@NonNull View item) {
            super(item);
            imgview = item.findViewById(R.id.imageCard);
        }

        public void bindData(Pokemon pokemon) {
           imgview.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if(oldID == 0)
                       oldID = pokemon.getId();
                   switch (pokemon.getId()){
                       case 1:
                           selectItem(pokemon);
                           break;
                       case 2:
                           selectItem(pokemon);
                           break;
                       case 3:
                           selectItem(pokemon);
                           break;
                       case 4:
                           selectItem(pokemon);
                           break;
                       case 5:
                           selectItem(pokemon);
                           break;
                       case 6:
                           selectItem(pokemon);
                           break;
                       case 7:
                           selectItem(pokemon);
                           break;
                       case 8:
                           selectItem(pokemon);
                           break;
                   }
               }
           });
        }

        private void selectItem(Pokemon pokemon){
            if(!pokemon.isStatusClick()){
                if(!pokemon.isStatus() && contCard < 2){
                    System.out.println("ID 3 -> "+oldID);
                    contCard++;
                    imgview.setImageDrawable(pokemon.getImg());
                    pokemon.setStatus(true);
                    if(oldID == pokemon.getId() && contCard > 1){
                        System.out.println("Entro!!!");
                        findPoke(pokemon.getId());
                        oldID = 0;
                        contCard = 0;
                    }
                } else{
                    if (pokemon.isStatus()){
                        imgview.setImageDrawable(context.getDrawable(R.drawable.pokebola));
                        pokemon.setStatus(false);
                        if(contCardFalse <= 2){
                            contCard--;
                            contCardFalse++;
                        }
                        System.out.println("Contador -> "+contCardFalse);
                        if(oldID == pokemon.getId() && contCardFalse > 1){
                            contCardFalse = 0;
                            contCard = 0;
                            oldID = 0;
                            System.out.println("Hola -> id - "+oldID);
                        }
                    }
                }
            }
        }

        private void findPoke(int ID){
            for (int i = 0; i < mPokeList.size(); i++) {
                if(mPokeList.get(i).getId() == ID){
                    mPokeList.get(i).setStatusClick(true);
                }
            }
        }

    }
}
