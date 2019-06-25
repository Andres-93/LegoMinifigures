package com.example.pccom.legominifigures;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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


        public HolderFigura(View itemView) {
            super(itemView);
            imgFigura = itemView.findViewById(R.id.imgFigura);
            txtnombreFig = itemView.findViewById(R.id.nombreFigura);
            txtSerieFig = itemView.findViewById(R.id.serieFigura);

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






        }
    }


}
