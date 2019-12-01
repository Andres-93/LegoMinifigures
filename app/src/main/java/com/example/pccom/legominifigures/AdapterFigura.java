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
            case "Serie10":
                switch (imagen){
                    case "abuelo":  Glide.with(context).load(R.drawable.abuelo).into(holder.imgFigura);break;
                    case "bibliotecaria":  Glide.with(context).load(R.drawable.blibliotecaria).into(holder.imgFigura);break;
                    case "capitanbarco":  Glide.with(context).load(R.drawable.capitanbarco).into(holder.imgFigura);break;
                    case "chicaabeja":  Glide.with(context).load(R.drawable.chicaabeja).into(holder.imgFigura);break;
                    case "comandanteromano":  Glide.with(context).load(R.drawable.comandanteromano).into(holder.imgFigura);break;
                    case "guerreroindio":  Glide.with(context).load(R.drawable.guerreroindio).into(holder.imgFigura);break;
                    case "influencer":  Glide.with(context).load(R.drawable.influencer).into(holder.imgFigura);break;
                    case "jugadorbaseball":  Glide.with(context).load(R.drawable.jugadorbaseball).into(holder.imgFigura);break;
                    case "mecanicomoto":  Glide.with(context).load(R.drawable.mecanicomoto).into(holder.imgFigura);break;
                    case "medusa":  Glide.with(context).load(R.drawable.medusa).into(holder.imgFigura);break;
                    case "mrgold":  Glide.with(context).load(R.drawable.mrgold).into(holder.imgFigura);break;
                    case "mujerguerrera":  Glide.with(context).load(R.drawable.mujerguerrera).into(holder.imgFigura);break;
                    case "paintball":  Glide.with(context).load(R.drawable.paintball).into(holder.imgFigura);break;
                    case "paracaidista":  Glide.with(context).load(R.drawable.paracaidista).into(holder.imgFigura);break;
                    case "payasotriste":  Glide.with(context).load(R.drawable.payasotriste).into(holder.imgFigura);break;
                    case "pintor":  Glide.with(context).load(R.drawable.pintor).into(holder.imgFigura);break;
                    case "soldadorevolucionario":  Glide.with(context).load(R.drawable.soldadorevolucionario).into(holder.imgFigura);break;
                }
                break;
            case "Serie11":
                switch (imagen){
                    case "abuela":  Glide.with(context).load(R.drawable.abuela).into(holder.imgFigura);break;
                    case "barbaro":  Glide.with(context).load(R.drawable.barbaro).into(holder.imgFigura);break;
                    case "camareraochentera":  Glide.with(context).load(R.drawable.camareraochentera).into(holder.imgFigura);break;
                    case "chicacientifica":  Glide.with(context).load(R.drawable.chicacientifica).into(holder.imgFigura);break;
                    case "chicapretz":  Glide.with(context).load(R.drawable.chicapretz).into(holder.imgFigura);break;
                    case "chicarobot":  Glide.with(context).load(R.drawable.chicarobot).into(holder.imgFigura);break;
                    case "elfonavidad":  Glide.with(context).load(R.drawable.elfonavidad).into(holder.imgFigura);break;
                    case "espanta":  Glide.with(context).load(R.drawable.espanta).into(holder.imgFigura);break;
                    case "gengibre":  Glide.with(context).load(R.drawable.gengibre).into(holder.imgFigura);break;
                    case "guerreroisla":  Glide.with(context).load(R.drawable.guerreroisla).into(holder.imgFigura);break;
                    case "mechmalo":  Glide.with(context).load(R.drawable.mechmalo).into(holder.imgFigura);break;
                    case "montanero":  Glide.with(context).load(R.drawable.montanero).into(holder.imgFigura);break;
                    case "poli":  Glide.with(context).load(R.drawable.poli).into(holder.imgFigura);break;
                    case "saxo":  Glide.with(context).load(R.drawable.saxo).into(holder.imgFigura);break;
                    case "soldador":  Glide.with(context).load(R.drawable.soldador).into(holder.imgFigura);break;
                    case "yeti":  Glide.with(context).load(R.drawable.yeti).into(holder.imgFigura);break;
                }
                break;
            case "Serie12":
                switch (imagen){
                    case "bufon":  Glide.with(context).load(R.drawable.bufon).into(holder.imgFigura);break;
                    case "chicagenio":  Glide.with(context).load(R.drawable.chicagenio).into(holder.imgFigura);break;
                    case "chicocerdo":  Glide.with(context).load(R.drawable.chicocerdo).into(holder.imgFigura);break;
                    case "diosaguerrera":  Glide.with(context).load(R.drawable.diosaguerrera).into(holder.imgFigura);break;
                    case "estrellarock":  Glide.with(context).load(R.drawable.estrellarock).into(holder.imgFigura);break;
                    case "gotica":  Glide.with(context).load(R.drawable.gotica).into(holder.imgFigura);break;
                    case "guardacostas":  Glide.with(context).load(R.drawable.guardacostas).into(holder.imgFigura);break;
                    case "hechizero":  Glide.with(context).load(R.drawable.hechizero).into(holder.imgFigura);break;
                    case "huno":  Glide.with(context).load(R.drawable.huno).into(holder.imgFigura);break;
                    case "mineroespacial":  Glide.with(context).load(R.drawable.mineroespacial).into(holder.imgFigura);break;
                    case "mosqueteroespada":  Glide.with(context).load(R.drawable.mosqueteroespada).into(holder.imgFigura);break;
                    case "princesacuento":  Glide.with(context).load(R.drawable.princesacuento).into(holder.imgFigura);break;
                    case "prospector":  Glide.with(context).load(R.drawable.prospector).into(holder.imgFigura);break;
                    case "rastreador":  Glide.with(context).load(R.drawable.rastreador).into(holder.imgFigura);break;
                    case "repartidorpizza":  Glide.with(context).load(R.drawable.repartidorpizza).into(holder.imgFigura);break;
                    case "videogamer":  Glide.with(context).load(R.drawable.videogamer).into(holder.imgFigura);break;
                }
                break;
            case "Serie13":
                switch (imagen){
                    case "carpintero":  Glide.with(context).load(R.drawable.carpintero).into(holder.imgFigura);break;
                    case "chicaciclope":  Glide.with(context).load(R.drawable.chicaciclope).into(holder.imgFigura);break;
                    case "chicaunicornio":  Glide.with(context).load(R.drawable.chicaunicornio).into(holder.imgFigura);break;
                    case "discodiva":  Glide.with(context).load(R.drawable.discodiva).into(holder.imgFigura);break;
                    case "encantadorserpientes":  Glide.with(context).load(R.drawable.encantadorserpientes).into(holder.imgFigura);break;
                    case "esgrima":  Glide.with(context).load(R.drawable.esgrima).into(holder.imgFigura);break;
                    case "goblin":  Glide.with(context).load(R.drawable.goblin).into(holder.imgFigura);break;
                    case "guerreroegipcio":  Glide.with(context).load(R.drawable.guerreroegipcio).into(holder.imgFigura);break;
                    case "hechizeromaligno":  Glide.with(context).load(R.drawable.hechizeromaligno).into(holder.imgFigura);break;
                    case "hotdog":  Glide.with(context).load(R.drawable.hotdog).into(holder.imgFigura);break;
                    case "paleontologa":  Glide.with(context).load(R.drawable.paleontologa).into(holder.imgFigura);break;
                    case "reyclasico":  Glide.with(context).load(R.drawable.reyclasico).into(holder.imgFigura);break;
                    case "samuraichica":  Glide.with(context).load(R.drawable.samuraichica).into(holder.imgFigura);break;
                    case "sheriff":  Glide.with(context).load(R.drawable.sheriff).into(holder.imgFigura);break;
                    case "tropaalienigena":  Glide.with(context).load(R.drawable.tropaalienigena).into(holder.imgFigura);break;
                    case "tropaespacial":  Glide.with(context).load(R.drawable.tropaespacial).into(holder.imgFigura);break;
                }
                break;
            case "Serie14":
                switch (imagen){
                    case "animadorazombie":  Glide.with(context).load(R.drawable.animadorazombie).into(holder.imgFigura);break;
                    case "banshee":  Glide.with(context).load(R.drawable.banshee).into(holder.imgFigura);break;
                    case "brujita":  Glide.with(context).load(R.drawable.brujita).into(holder.imgFigura);break;
                    case "chicatigre":  Glide.with(context).load(R.drawable.chicatigre).into(holder.imgFigura);break;
                    case "chicaesqueleto":  Glide.with(context).load(R.drawable.chicoesqueleto).into(holder.imgFigura);break;
                    case "cientificomonstruo":  Glide.with(context).load(R.drawable.cientificomonstruo).into(holder.imgFigura);break;
                    case "espectro":  Glide.with(context).load(R.drawable.espectro).into(holder.imgFigura);break;
                    case "gargola":  Glide.with(context).load(R.drawable.gargola).into(holder.imgFigura);break;
                    case "hombrelobito":  Glide.with(context).load(R.drawable.hombrelobito).into(holder.imgFigura);break;
                    case "ladyarana":  Glide.with(context).load(R.drawable.ladyarana).into(holder.imgFigura);break;
                    case "piesgrande":  Glide.with(context).load(R.drawable.piesgrande).into(holder.imgFigura);break;
                    case "piratazombie":  Glide.with(context).load(R.drawable.piratazombie).into(holder.imgFigura);break;
                    case "plantamonster":  Glide.with(context).load(R.drawable.plantamonster).into(holder.imgFigura);break;
                    case "rockeromonstruo":  Glide.with(context).load(R.drawable.rockeromonstruo).into(holder.imgFigura);break;
                    case "voladormonster":  Glide.with(context).load(R.drawable.voladormonster).into(holder.imgFigura);break;
                    case "zombienegocios":  Glide.with(context).load(R.drawable.zombienegocios).into(holder.imgFigura);break;
                }
                break;
            case "SerieMovie1":
                switch (imagen){
                    case "badcop":  Glide.with(context).load(R.drawable.badcop).into(holder.imgFigura);break;
                    case "calamidad":  Glide.with(context).load(R.drawable.calamidad).into(holder.imgFigura);break;
                    case "emet":  Glide.with(context).load(R.drawable.emet).into(holder.imgFigura);break;
                    case "gail":  Glide.with(context).load(R.drawable.gail).into(holder.imgFigura);break;
                    case "larry":  Glide.with(context).load(R.drawable.larry).into(holder.imgFigura);break;
                    case "lincin":  Glide.with(context).load(R.drawable.lincin).into(holder.imgFigura);break;
                    case "marsha":  Glide.with(context).load(R.drawable.marsha).into(holder.imgFigura);break;
                    case "oeste":  Glide.with(context).load(R.drawable.oeste).into(holder.imgFigura);break;
                    case "panda":  Glide.with(context).load(R.drawable.panda).into(holder.imgFigura);break;
                    case "pants":  Glide.with(context).load(R.drawable.pants).into(holder.imgFigura);break;
                    case "presidente":  Glide.with(context).load(R.drawable.presidente).into(holder.imgFigura);break;
                    case "scrachen":  Glide.with(context).load(R.drawable.scrachen).into(holder.imgFigura);break;
                    case "shakespire":  Glide.with(context).load(R.drawable.shakespire).into(holder.imgFigura);break;
                    case "taco":  Glide.with(context).load(R.drawable.taco).into(holder.imgFigura);break;
                    case "velma":  Glide.with(context).load(R.drawable.velma).into(holder.imgFigura);break;
                    case "wiley":  Glide.with(context).load(R.drawable.wiley).into(holder.imgFigura);break;
                }
                break;
            case "SerieEquipoOlimpico":
                switch (imagen){
                    case "arquero":  Glide.with(context).load(R.drawable.arquero).into(holder.imgFigura);break;
                    case "boxeador":  Glide.with(context).load(R.drawable.boxeador).into(holder.imgFigura);break;
                    case "corredor":  Glide.with(context).load(R.drawable.corredor).into(holder.imgFigura);break;
                    case "gimnasta":  Glide.with(context).load(R.drawable.gimnasta).into(holder.imgFigura);break;
                    case "jinete":  Glide.with(context).load(R.drawable.jinete).into(holder.imgFigura);break;
                    case "judo":  Glide.with(context).load(R.drawable.judo).into(holder.imgFigura);break;
                    case "levantar":  Glide.with(context).load(R.drawable.levantar).into(holder.imgFigura);break;
                    case "nadador":  Glide.with(context).load(R.drawable.nadador).into(holder.imgFigura);break;
                    case "tenista":  Glide.with(context).load(R.drawable.tenista).into(holder.imgFigura);break;

                }
                break;
            case "SerieSimpsons1":
                switch (imagen){
                    case "aby":  Glide.with(context).load(R.drawable.aby).into(holder.imgFigura);break;
                    case "apu":  Glide.with(context).load(R.drawable.apu).into(holder.imgFigura);break;
                    case "bart":  Glide.with(context).load(R.drawable.bart).into(holder.imgFigura);break;
                    case "burns":  Glide.with(context).load(R.drawable.burns).into(holder.imgFigura);break;
                    case "homer":  Glide.with(context).load(R.drawable.homer).into(holder.imgFigura);break;
                    case "krusty":  Glide.with(context).load(R.drawable.krusty).into(holder.imgFigura);break;
                    case "lisa":  Glide.with(context).load(R.drawable.lisa).into(holder.imgFigura);break;
                    case "maggie":  Glide.with(context).load(R.drawable.maggie).into(holder.imgFigura);break;
                    case "marge":  Glide.with(context).load(R.drawable.marge).into(holder.imgFigura);break;
                    case "milhouse":  Glide.with(context).load(R.drawable.milhouse).into(holder.imgFigura);break;
                    case "ned":  Glide.with(context).load(R.drawable.ned).into(holder.imgFigura);break;
                    case "nelson":  Glide.with(context).load(R.drawable.nelson).into(holder.imgFigura);break;
                    case "pica":  Glide.with(context).load(R.drawable.pica).into(holder.imgFigura);break;
                    case "ralph":  Glide.with(context).load(R.drawable.ralph).into(holder.imgFigura);break;
                    case "rasca":  Glide.with(context).load(R.drawable.rasca).into(holder.imgFigura);break;
                    case "wiggum":  Glide.with(context).load(R.drawable.wiggum).into(holder.imgFigura);break;
                }
                break;
            case "SerieSimpsons2":
                switch (imagen){
                    case "bartman":  Glide.with(context).load(R.drawable.bartman).into(holder.imgFigura);break;
                    case "comic":  Glide.with(context).load(R.drawable.comic).into(holder.imgFigura);break;
                    case "doctor":  Glide.with(context).load(R.drawable.doctor).into(holder.imgFigura);break;
                    case "edna":  Glide.with(context).load(R.drawable.edna).into(holder.imgFigura);break;
                    case "fallout":  Glide.with(context).load(R.drawable.fallout).into(holder.imgFigura);break;
                    case "frink":  Glide.with(context).load(R.drawable.frink).into(holder.imgFigura);break;
                    case "hans":  Glide.with(context).load(R.drawable.hans).into(holder.imgFigura);break;
                    case "homercita":  Glide.with(context).load(R.drawable.homercita).into(holder.imgFigura);break;
                    case "lisabola":  Glide.with(context).load(R.drawable.lisabola).into(holder.imgFigura);break;
                    case "maggieperro":  Glide.with(context).load(R.drawable.maggieperro).into(holder.imgFigura);break;
                    case "margecita":  Glide.with(context).load(R.drawable.margecita).into(holder.imgFigura);break;
                    case "martin":  Glide.with(context).load(R.drawable.martin).into(holder.imgFigura);break;
                    case "patty":  Glide.with(context).load(R.drawable.patty).into(holder.imgFigura);break;
                    case "selma":  Glide.with(context).load(R.drawable.selma).into(holder.imgFigura);break;
                    case "smith":  Glide.with(context).load(R.drawable.smith).into(holder.imgFigura);break;
                    case "will":  Glide.with(context).load(R.drawable.will).into(holder.imgFigura);break;
                }
                break;
            case "Serie15":
                switch (imagen){
                    case "animalcontrol":  Glide.with(context).load(R.drawable.animalcontrol).into(holder.imgFigura);break;
                    case "astronauta":  Glide.with(context).load(R.drawable.astronauta).into(holder.imgFigura);break;
                    case "bailarina":  Glide.with(context).load(R.drawable.bailarina).into(holder.imgFigura);break;
                    case "conserje":  Glide.with(context).load(R.drawable.conserje).into(holder.imgFigura);break;
                    case "fauno":  Glide.with(context).load(R.drawable.fauno).into(holder.imgFigura);break;
                    case "granjero":  Glide.with(context).load(R.drawable.granjero).into(holder.imgFigura);break;
                    case "guerrerooso":  Glide.with(context).load(R.drawable.guerrerooso).into(holder.imgFigura);break;
                    case "guerrerovolador":  Glide.with(context).load(R.drawable.guerrerovolador).into(holder.imgFigura);break;
                    case "herido":  Glide.with(context).load(R.drawable.herido).into(holder.imgFigura);break;
                    case "joyaladrona":  Glide.with(context).load(R.drawable.joyaladrona).into(holder.imgFigura);break;
                    case "kendo":  Glide.with(context).load(R.drawable.kendo).into(holder.imgFigura);break;
                    case "lasermech":  Glide.with(context).load(R.drawable.lasermech).into(holder.imgFigura);break;
                    case "luchalibre":  Glide.with(context).load(R.drawable.luchalibre).into(holder.imgFigura);break;
                    case "reina":  Glide.with(context).load(R.drawable.reina).into(holder.imgFigura);break;
                    case "tiburon":  Glide.with(context).load(R.drawable.tiburon).into(holder.imgFigura);break;
                    case "tribalgirl":  Glide.with(context).load(R.drawable.tribalgirl).into(holder.imgFigura);break;
                }
                break;
            case "Serie16":
                switch (imagen){
                    case "chicopinguino":  Glide.with(context).load(R.drawable.chicopinguino).into(holder.imgFigura);break;
                    case "cyborg":  Glide.with(context).load(R.drawable.cyborg).into(holder.imgFigura);break;
                    case "desiertoguerrero":  Glide.with(context).load(R.drawable.desiertoguerrero).into(holder.imgFigura);break;
                    case "fotosalvaje":  Glide.with(context).load(R.drawable.fotosalvaje).into(holder.imgFigura);break;
                    case "gotico":  Glide.with(context).load(R.drawable.gotico).into(holder.imgFigura);break;
                    case "kickboxer":  Glide.with(context).load(R.drawable.kickboxer).into(holder.imgFigura);break;
                    case "mariachi":  Glide.with(context).load(R.drawable.mariachi).into(holder.imgFigura);break;
                    case "minidemonio":  Glide.with(context).load(R.drawable.minidemonio).into(holder.imgFigura);break;
                    case "ninera":  Glide.with(context).load(R.drawable.ninera).into(holder.imgFigura);break;
                    case "perroganador":  Glide.with(context).load(R.drawable.perroganador).into(holder.imgFigura);break;
                    case "piratilla":  Glide.with(context).load(R.drawable.piratilla).into(holder.imgFigura);break;
                    case "platano":  Glide.with(context).load(R.drawable.platano).into(holder.imgFigura);break;
                    case "reinahielo":  Glide.with(context).load(R.drawable.reinahielo).into(holder.imgFigura);break;
                    case "rogue":  Glide.with(context).load(R.drawable.rogue).into(holder.imgFigura);break;
                    case "senderista":  Glide.with(context).load(R.drawable.senderista).into(holder.imgFigura);break;
                    case "spy":  Glide.with(context).load(R.drawable.spy).into(holder.imgFigura);break;
                }
                break;
            case "Serie17":
                switch (imagen){
                    case "asaltador":  Glide.with(context).load(R.drawable.asaltador).into(holder.imgFigura);break;
                    case "chef":  Glide.with(context).load(R.drawable.chef).into(holder.imgFigura);break;
                    case "chicomaiz":  Glide.with(context).load(R.drawable.chicomaiz).into(holder.imgFigura);break;
                    case "elfamaiden":  Glide.with(context).load(R.drawable.elfamaiden).into(holder.imgFigura);break;
                    case "enanocombate":  Glide.with(context).load(R.drawable.enanocombate).into(holder.imgFigura);break;
                    case "forzudo":  Glide.with(context).load(R.drawable.forzudo).into(holder.imgFigura);break;
                    case "frances":  Glide.with(context).load(R.drawable.frances).into(holder.imgFigura);break;
                    case "gladiadorromano":  Glide.with(context).load(R.drawable.galdiadorromano).into(holder.imgFigura);break;
                    case "heroeespacialretro":  Glide.with(context).load(R.drawable.heroeespacialretro).into(holder.imgFigura);break;
                    case "mariposita":  Glide.with(context).load(R.drawable.mariposita).into(holder.imgFigura);break;
                    case "ninorocket":  Glide.with(context).load(R.drawable.ninorocket).into(holder.imgFigura);break;
                    case "profebaile":  Glide.with(context).load(R.drawable.profebaile).into(holder.imgFigura);break;
                    case "surferpro":  Glide.with(context).load(R.drawable.surferpro).into(holder.imgFigura);break;
                    case "vendehotdog":  Glide.with(context).load(R.drawable.vendehotdog).into(holder.imgFigura);break;
                    case "vet":  Glide.with(context).load(R.drawable.vete).into(holder.imgFigura);break;
                    case "yuppie":  Glide.with(context).load(R.drawable.yuppie).into(holder.imgFigura);break;
                }
                break;
            case "Serie18":
                switch (imagen){
                    case "cactus":  Glide.with(context).load(R.drawable.cactus).into(holder.imgFigura);break;
                    case "chicacumple":  Glide.with(context).load(R.drawable.chicacumple).into(holder.imgFigura);break;
                    case "chicocumple":  Glide.with(context).load(R.drawable.chicocumple).into(holder.imgFigura);break;
                    case "chicagato":  Glide.with(context).load(R.drawable.chicagato).into(holder.imgFigura);break;
                    case "chicalego":  Glide.with(context).load(R.drawable.chicalego).into(holder.imgFigura);break;
                    case "chicolego":  Glide.with(context).load(R.drawable.chicolego).into(holder.imgFigura);break;
                    case "disfrazarana":  Glide.with(context).load(R.drawable.disfrazarana).into(holder.imgFigura);break;
                    case "disfrazcoche":  Glide.with(context).load(R.drawable.disfrazcoche).into(holder.imgFigura);break;
                    case "disfrazcowboy":  Glide.with(context).load(R.drawable.disfrazcowboy).into(holder.imgFigura);break;
                    case "disfrazunicornio":  Glide.with(context).load(R.drawable.disfrazunicornio).into(holder.imgFigura);break;
                    case "dragon":  Glide.with(context).load(R.drawable.dragon).into(holder.imgFigura);break;
                    case "elefante":  Glide.with(context).load(R.drawable.elefante).into(holder.imgFigura);break;
                    case "flordisfraz":  Glide.with(context).load(R.drawable.flordisfraz).into(holder.imgFigura);break;
                    case "payasofiesto":  Glide.with(context).load(R.drawable.payasofiesto).into(holder.imgFigura);break;
                    case "policlasico":  Glide.with(context).load(R.drawable.policlasico).into(holder.imgFigura);break;
                    case "pritecnia":  Glide.with(context).load(R.drawable.pritecnia).into(holder.imgFigura);break;
                    case "tartatio":  Glide.with(context).load(R.drawable.tartatio).into(holder.imgFigura);break;
                }
                break;
            case "Serie19":
                switch (imagen){
                    case "bicimontana":  Glide.with(context).load(R.drawable.bicimontana).into(holder.imgFigura);break;
                    case "bombera":  Glide.with(context).load(R.drawable.bombera).into(holder.imgFigura);break;
                    case "chicazorro":  Glide.with(context).load(R.drawable.chicazorro).into(holder.imgFigura);break;
                    case "chicoducha":  Glide.with(context).load(R.drawable.chicoducha).into(holder.imgFigura);break;
                    case "cuidadoraperros":  Glide.with(context).load(R.drawable.cuidadoraperros).into(holder.imgFigura);break;
                    case "disfrazpizza":  Glide.with(context).load(R.drawable.disfrazpizza).into(holder.imgFigura);break;
                    case "guerrerosusto":  Glide.with(context).load(R.drawable.guerrerosusto).into(holder.imgFigura);break;
                    case "jardinera":  Glide.with(context).load(R.drawable.jardinera).into(holder.imgFigura);break;
                    case "junglaexplorador":  Glide.with(context).load(R.drawable.junglaexplorador).into(holder.imgFigura);break;
                    case "momiareina":  Glide.with(context).load(R.drawable.momiareina).into(holder.imgFigura);break;
                    case "osoarcoiris":  Glide.with(context).load(R.drawable.osoarcoiris).into(holder.imgFigura);break;
                    case "programadora":  Glide.with(context).load(R.drawable.programadora).into(holder.imgFigura);break;
                    case "reymono":  Glide.with(context).load(R.drawable.reymono).into(holder.imgFigura);break;
                    case "rugbyplayer":  Glide.with(context).load(R.drawable.rugbyplayer).into(holder.imgFigura);break;
                    case "soldadogalactico":  Glide.with(context).load(R.drawable.soldadogalactico).into(holder.imgFigura);break;
                    case "videojugador":  Glide.with(context).load(R.drawable.videojugador).into(holder.imgFigura);break;
                }
                break;






        }
    }


}
