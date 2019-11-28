package com.example.pccom.legominifigures;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pccom.legominifigures.data.Figura;

import java.util.ArrayList;

public class AdapterFigura extends RecyclerView.Adapter<AdapterFigura.HolderFigura> implements View.OnClickListener{

    private ArrayList<Figura> listaFiguras;
    private View.OnClickListener listener;
    private Context context;

    public AdapterFigura(ArrayList<Figura> listaFiguras, Context context) {
        this.listaFiguras= listaFiguras;
        this.context = context;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return listaFiguras.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public static class HolderFigura extends RecyclerView.ViewHolder {
        ImageView imgFigura;
        TextView txtnombreFig;
        TextView txtSerieFig;
        LinearLayout fondo;


        public HolderFigura(View itemView) {
            super(itemView);
            imgFigura = itemView.findViewById(R.id.imgFigura);
            txtnombreFig = itemView.findViewById(R.id.nombreFigura);
            txtSerieFig = itemView.findViewById(R.id.serieFigura);
            fondo = itemView.findViewById(R.id.fondoFigura);

        }
    }

    @NonNull
    @Override
    public HolderFigura onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_figure, parent, false);
        v.setOnClickListener(this);
        HolderFigura holder = new HolderFigura(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFigura holder, int position) {

        holder.txtnombreFig.setText(listaFiguras.get(position).getNombre());
        holder.txtSerieFig.setText(listaFiguras.get(position).getSerie());

        rellenarImagen(listaFiguras.get(position).getSerie(),listaFiguras.get(position).getUrlImg(),holder);

        if(listaFiguras.get(position).getEnPosesion() == 0){
            holder.fondo.setBackgroundColor(context.getResources().getColor(R.color.rojo));
        }else{
            holder.fondo.setBackgroundColor(context.getResources().getColor(R.color.verde));
        }

    }

    private void rellenarImagen(String serie,String imagen,HolderFigura holder) {

        switch(serie){

            case "Serie1":
                switch (imagen){
                    case "animadora":  Glide.with(context).load(R.drawable.animadora).into(holder.imgFigura);break;
                    case "bosqui":  Glide.with(context).load(R.drawable.bosqui).into(holder.imgFigura);break;
                    case "buceador":  Glide.with(context).load(R.drawable.buceador).into(holder.imgFigura);break;
                    case "caver":  Glide.with(context).load(R.drawable.caver).into(holder.imgFigura);break;
                    case "cazador":  Glide.with(context).load(R.drawable.cazador).into(holder.imgFigura);break;
                    case "cowboy":  Glide.with(context).load(R.drawable.cowboy).into(holder.imgFigura);break;
                    case "enfermera":  Glide.with(context).load(R.drawable.enfermera).into(holder.imgFigura);break;
                    case "espacio":  Glide.with(context).load(R.drawable.espacio).into(holder.imgFigura);break;
                    case "luchador":  Glide.with(context).load(R.drawable.luchador).into(holder.imgFigura);break;
                    case "mago":  Glide.with(context).load(R.drawable.mago).into(holder.imgFigura);break;
                    case "maniqui":  Glide.with(context).load(R.drawable.maniqui).into(holder.imgFigura);break;
                    case "ninja":  Glide.with(context).load(R.drawable.ninja).into(holder.imgFigura);break;
                    case "payaso":  Glide.with(context).load(R.drawable.payaso).into(holder.imgFigura);break;
                    case "robot":  Glide.with(context).load(R.drawable.robot).into(holder.imgFigura);break;
                    case "skater":  Glide.with(context).load(R.drawable.skater).into(holder.imgFigura);break;
                    case "zombie":  Glide.with(context).load(R.drawable.zombie).into(holder.imgFigura);break;
                }
                break;


            case "Serie2":
                switch (imagen){
                    case "bruja":  Glide.with(context).load(R.drawable.bruja).into(holder.imgFigura);break;
                    case "circo":  Glide.with(context).load(R.drawable.circo).into(holder.imgFigura);break;
                    case "disco":  Glide.with(context).load(R.drawable.disco).into(holder.imgFigura);break;
                    case "espartano":  Glide.with(context).load(R.drawable.espartano).into(holder.imgFigura);break;
                    case "esquiador":  Glide.with(context).load(R.drawable.esquiador).into(holder.imgFigura);break;
                    case "estrella":  Glide.with(context).load(R.drawable.estrella).into(holder.imgFigura);break;
                    case "explorador":  Glide.with(context).load(R.drawable.explorador).into(holder.imgFigura);break;
                    case "faraon":  Glide.with(context).load(R.drawable.faraon).into(holder.imgFigura);break;
                    case "karate":  Glide.with(context).load(R.drawable.karate).into(holder.imgFigura);break;
                    case "levantador":  Glide.with(context).load(R.drawable.levantador).into(holder.imgFigura);break;
                    case "mexicano":  Glide.with(context).load(R.drawable.mexicano).into(holder.imgFigura);break;
                    case "mimo":  Glide.with(context).load(R.drawable.mimo).into(holder.imgFigura);break;
                    case "policia":  Glide.with(context).load(R.drawable.policia).into(holder.imgFigura);break;
                    case "socorrista":  Glide.with(context).load(R.drawable.socorrista).into(holder.imgFigura);break;
                    case "surfero":  Glide.with(context).load(R.drawable.surfero).into(holder.imgFigura);break;
                    case "vampiro":  Glide.with(context).load(R.drawable.vampiro).into(holder.imgFigura);break;
                }
                break;

            case "Serie3":
                switch (imagen){
                    case "alien":  Glide.with(context).load(R.drawable.alien).into(holder.imgFigura);break;
                    case "baseball":  Glide.with(context).load(R.drawable.baseball).into(holder.imgFigura);break;
                    case "indio":  Glide.with(context).load(R.drawable.chief).into(holder.imgFigura);break;
                    case "elfo":  Glide.with(context).load(R.drawable.elfo).into(holder.imgFigura);break;
                    case "gorila":  Glide.with(context).load(R.drawable.gorila).into(holder.imgFigura);break;
                    case "hula":  Glide.with(context).load(R.drawable.hula).into(holder.imgFigura);break;
                    case "momia":  Glide.with(context).load(R.drawable.momia).into(holder.imgFigura);break;
                    case "pesca":  Glide.with(context).load(R.drawable.pesca).into(holder.imgFigura);break;
                    case "piloto":  Glide.with(context).load(R.drawable.piloto).into(holder.imgFigura);break;
                    case "racer":  Glide.with(context).load(R.drawable.racer).into(holder.imgFigura);break;
                    case "rapero":  Glide.with(context).load(R.drawable.rapero).into(holder.imgFigura);break;
                    case "samurai":  Glide.with(context).load(R.drawable.samurai).into(holder.imgFigura);break;
                    case "snow":  Glide.with(context).load(R.drawable.snow).into(holder.imgFigura);break;
                    case "sumo":  Glide.with(context).load(R.drawable.sumo).into(holder.imgFigura);break;
                    case "tenis":  Glide.with(context).load(R.drawable.tenis).into(holder.imgFigura);break;
                    case "villano":  Glide.with(context).load(R.drawable.villano).into(holder.imgFigura);break;
                }
                break;



        }
    }


}
