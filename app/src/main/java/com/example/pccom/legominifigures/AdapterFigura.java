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

    public void cambioLista(ArrayList<Figura> listaFigurasNew){
        listaFiguras = listaFigurasNew;

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

            case "Serie4":
                switch (imagen){
                    case "artista":  Glide.with(context).load(R.drawable.artista).into(holder.imgFigura);break;
                    case "chicasurfer":  Glide.with(context).load(R.drawable.chicasurfer).into(holder.imgFigura);break;
                    case "cientifico":  Glide.with(context).load(R.drawable.cien).into(holder.imgFigura);break;
                    case "futbol":  Glide.with(context).load(R.drawable.futbol).into(holder.imgFigura);break;
                    case "gnomo":  Glide.with(context).load(R.drawable.gnomo).into(holder.imgFigura);break;
                    case "hockey":  Glide.with(context).load(R.drawable.hockey).into(holder.imgFigura);break;
                    case "hombrelobo":  Glide.with(context).load(R.drawable.hombrelobo).into(holder.imgFigura);break;
                    case "kimono":  Glide.with(context).load(R.drawable.kimono).into(holder.imgFigura);break;
                    case "monster":  Glide.with(context).load(R.drawable.mosnter).into(holder.imgFigura);break;
                    case "mosquetero":  Glide.with(context).load(R.drawable.mosquetero).into(holder.imgFigura);break;
                    case "nave":  Glide.with(context).load(R.drawable.nave).into(holder.imgFigura);break;
                    case "nuclear":  Glide.with(context).load(R.drawable.nuclear).into(holder.imgFigura);break;
                    case "patinadora":  Glide.with(context).load(R.drawable.patinadora).into(holder.imgFigura);break;
                    case "punk":  Glide.with(context).load(R.drawable.punk).into(holder.imgFigura);break;
                    case "skater":  Glide.with(context).load(R.drawable.skaterurbano).into(holder.imgFigura);break;
                    case "viking":  Glide.with(context).load(R.drawable.vikingo).into(holder.imgFigura);break;
                }
                break;

            case "Serie5":
                switch (imagen){
                    case "boxeo":  Glide.with(context).load(R.drawable.boxer).into(holder.imgFigura);break;
                    case "cavergirl":  Glide.with(context).load(R.drawable.cave).into(holder.imgFigura);break;
                    case "cleopatra":  Glide.with(context).load(R.drawable.cleopatra).into(holder.imgFigura);break;
                    case "detec":  Glide.with(context).load(R.drawable.detective).into(holder.imgFigura);break;
                    case "enanomalo":  Glide.with(context).load(R.drawable.enanomalo).into(holder.imgFigura);break;
                    case "fitness":  Glide.with(context).load(R.drawable.fitness).into(holder.imgFigura);break;
                    case "gangster":  Glide.with(context).load(R.drawable.gangster).into(holder.imgFigura);break;
                    case "gladiador":  Glide.with(context).load(R.drawable.gladiador).into(holder.imgFigura);break;
                    case "graduado":  Glide.with(context).load(R.drawable.graduado).into(holder.imgFigura);break;
                    case "guardiareal":  Glide.with(context).load(R.drawable.guardiareal).into(holder.imgFigura);break;
                    case "lagarto":  Glide.with(context).load(R.drawable.lagarto).into(holder.imgFigura);break;
                    case "lenador":  Glide.with(context).load(R.drawable.lenadopr).into(holder.imgFigura);break;
                    case "payasopeque":  Glide.with(context).load(R.drawable.payasopeque).into(holder.imgFigura);break;
                    case "pescahielo":  Glide.with(context).load(R.drawable.pescahielo).into(holder.imgFigura);break;
                    case "snowchico":  Glide.with(context).load(R.drawable.snowchico).into(holder.imgFigura);break;
                    case "zoo":  Glide.with(context).load(R.drawable.zookeper).into(holder.imgFigura);break;
                }
                break;

            case "Serie6":
                switch (imagen){
                    case "alienclasico":  Glide.with(context).load(R.drawable.alienclasico).into(holder.imgFigura);break;
                    case "bandido":  Glide.with(context).load(R.drawable.bandido).into(holder.imgFigura);break;
                    case "carnicero":  Glide.with(context).load(R.drawable.carnicero).into(holder.imgFigura);break;
                    case "chicaskate":  Glide.with(context).load(R.drawable.chicaskate).into(holder.imgFigura);break;
                    case "cirujano":  Glide.with(context).load(R.drawable.cirujano).into(holder.imgFigura);break;
                    case "dormilon":  Glide.with(context).load(R.drawable.dormilon).into(holder.imgFigura);break;
                    case "genio":  Glide.with(context).load(R.drawable.genio).into(holder.imgFigura);break;
                    case "lepre":  Glide.with(context).load(R.drawable.leprechaun).into(holder.imgFigura);break;
                    case "libertad":  Glide.with(context).load(R.drawable.libertad).into(holder.imgFigura);break;
                    case "luchador":  Glide.with(context).load(R.drawable.luchadorescoces).into(holder.imgFigura);break;
                    case "mecanico":  Glide.with(context).load(R.drawable.mecanico).into(holder.imgFigura);break;
                    case "minotauro":  Glide.with(context).load(R.drawable.minotauro).into(holder.imgFigura);break;
                    case "romano":  Glide.with(context).load(R.drawable.romano).into(holder.imgFigura);break;
                    case "chicagalactica":  Glide.with(context).load(R.drawable.chicaintergalactica).into(holder.imgFigura);break;
                    case "flamenco":  Glide.with(context).load(R.drawable.flamenco).into(holder.imgFigura);break;
                    case "robot":  Glide.with(context).load(R.drawable.robotreloj).into(holder.imgFigura);break;
                }
                break;
            case "Serie7":
                switch (imagen){
                    case "azteca":  Glide.with(context).load(R.drawable.azteca).into(holder.imgFigura);break;
                    case "caperucita":  Glide.with(context).load(R.drawable.caperuticta).into(holder.imgFigura);break;
                    case "chicaviking":  Glide.with(context).load(R.drawable.chicaviking).into(holder.imgFigura);break;
                    case "conejo":  Glide.with(context).load(R.drawable.conejo).into(holder.imgFigura);break;
                    case "escoces":  Glide.with(context).load(R.drawable.escoces).into(holder.imgFigura);break;
                    case "guerreromalo":  Glide.with(context).load(R.drawable.guerreromalo).into(holder.imgFigura);break;
                    case "hippie":  Glide.with(context).load(R.drawable.hippie).into(holder.imgFigura);break;
                    case "hombrejungla":  Glide.with(context).load(R.drawable.hombrejungla).into(holder.imgFigura);break;
                    case "motorista":  Glide.with(context).load(R.drawable.motorista).into(holder.imgFigura);break;
                    case "nadadora":  Glide.with(context).load(R.drawable.nadadora).into(holder.imgFigura);break;
                    case "novia":  Glide.with(context).load(R.drawable.novia).into(holder.imgFigura);break;
                    case "patrulla":  Glide.with(context).load(R.drawable.patrulla).into(holder.imgFigura);break;
                    case "programador":  Glide.with(context).load(R.drawable.programador).into(holder.imgFigura);break;
                    case "reyoceano":  Glide.with(context).load(R.drawable.reyoceano).into(holder.imgFigura);break;
                    case "rockera":  Glide.with(context).load(R.drawable.rockera).into(holder.imgFigura);break;
                    case "tenistaace":  Glide.with(context).load(R.drawable.tenistaace).into(holder.imgFigura);break;
                }
                break;
            case "Serie8":
                switch (imagen){
                    case "alemanpan":  Glide.with(context).load(R.drawable.alemanpan).into(holder.imgFigura);break;
                    case "alienvillano":  Glide.with(context).load(R.drawable.alienvillano).into(holder.imgFigura);break;
                    case "anim":  Glide.with(context).load(R.drawable.anim).into(holder.imgFigura);break;
                    case "buzo":  Glide.with(context).load(R.drawable.buzo).into(holder.imgFigura);break;
                    case "capitanpirata":  Glide.with(context).load(R.drawable.capitanpirata).into(holder.imgFigura);break;
                    case "conquistador":  Glide.with(context).load(R.drawable.conquistador).into(holder.imgFigura);break;
                    case "cowgirl":  Glide.with(context).load(R.drawable.cowgirl).into(holder.imgFigura);break;
                    case "dj":  Glide.with(context).load(R.drawable.dj).into(holder.imgFigura);break;
                    case "espian":  Glide.with(context).load(R.drawable.espian).into(holder.imgFigura);break;
                    case "hada":  Glide.with(context).load(R.drawable.hada).into(holder.imgFigura);break;
                    case "hombrenegocios":  Glide.with(context).load(R.drawable.hombrenegocios).into(holder.imgFigura);break;
                    case "jugadoramericanofutbol":  Glide.with(context).load(R.drawable.jugadoramericanofutbol).into(holder.imgFigura);break;
                    case "robotmalo":  Glide.with(context).load(R.drawable.robotmalo).into(holder.imgFigura);break;
                    case "santa":  Glide.with(context).load(R.drawable.santa).into(holder.imgFigura);break;
                    case "skiadora":  Glide.with(context).load(R.drawable.skiadora).into(holder.imgFigura);break;
                    case "vampiromur":  Glide.with(context).load(R.drawable.vampiromur).into(holder.imgFigura);break;
                }
                break;
            case "Serie9":
                switch (imagen){
                    case "adivina":  Glide.with(context).load(R.drawable.adivina).into(holder.imgFigura);break;
                    case "alienvengador":  Glide.with(context).load(R.drawable.alienvengador).into(holder.imgFigura);break;
                    case "buenoymalo":  Glide.with(context).load(R.drawable.buenoymalo).into(holder.imgFigura);break;
                    case "camarero":  Glide.with(context).load(R.drawable.camarero).into(holder.imgFigura);break;
                    case "ciclope":  Glide.with(context).load(R.drawable.ciclope).into(holder.imgFigura);break;
                    case "disfrazpollo":  Glide.with(context).load(R.drawable.disfrazpollo).into(holder.imgFigura);break;
                    case "elfa":  Glide.with(context).load(R.drawable.elfa).into(holder.imgFigura);break;
                    case "emperadorromano":  Glide.with(context).load(R.drawable.emperadorromano).into(holder.imgFigura);break;
                    case "estrellahollywood":  Glide.with(context).load(R.drawable.estrellahollywood).into(holder.imgFigura);break;
                    case "fontaneto":  Glide.with(context).load(R.drawable.fontaneto).into(holder.imgFigura);break;
                    case "guerreroheroico":  Glide.with(context).load(R.drawable.guerreroheroico).into(holder.imgFigura);break;
                    case "juez":  Glide.with(context).load(R.drawable.juez).into(holder.imgFigura);break;
                    case "patinadoraderby":  Glide.with(context).load(R.drawable.patinadoraderby).into(holder.imgFigura);break;
                    case "police":  Glide.with(context).load(R.drawable.police).into(holder.imgFigura);break;
                    case "robotcombate":  Glide.with(context).load(R.drawable.robotcombate).into(holder.imgFigura);break;
                    case "sirena":  Glide.with(context).load(R.drawable.sirena).into(holder.imgFigura);break;
                }
                break;



        }
    }


}
