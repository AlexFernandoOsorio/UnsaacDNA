package com.example.fernando.unsaacdna;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by osequeiros on 7/08/17.
 * Activity DNA 2
 */

public class DNAMain2 extends AppCompatActivity {

    private ListView lista1;
    private ListView lista2;
    private ListView lista3;
    private MaterialSpinner spinner;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> arrayAdaptertemp;
    private ArrayAdapter<String> adapteramino;

    private List<String> cadena;
    private List<String> cadenatemporal;
    private List<String> cadenaamino;

    private TextView texto;
    int idSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dnamain);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        setUpViews();
        initVars();

        Button butA = (Button) findViewById(R.id.butA);
        butA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("A");
                adapter.notifyDataSetChanged();
                opcionspinner(idSpinner);
                arrayAdaptertemp.notifyDataSetChanged();
                adapteramino.notifyDataSetChanged();
            }
        });

        Button butT=(Button) findViewById(R.id.butT);
        butT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("T");
                adapter.notifyDataSetChanged();
                opcionspinner(idSpinner);
                arrayAdaptertemp.notifyDataSetChanged();
                adapteramino.notifyDataSetChanged();
            }
        });

        Button butG = (Button) findViewById(R.id.butG);
        butG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("G");
                adapter.notifyDataSetChanged();
                opcionspinner(idSpinner);
                arrayAdaptertemp.notifyDataSetChanged();
                adapteramino.notifyDataSetChanged();
            }
        });

        Button butC = (Button) findViewById(R.id.butC);
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("C");
                adapter.notifyDataSetChanged();
                opcionspinner(idSpinner);
                arrayAdaptertemp.notifyDataSetChanged();
                adapteramino.notifyDataSetChanged();
            }
        });

        Button butDel = (Button) findViewById(R.id.butDel);
        butDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cadena.size() > 0 && cadenatemporal.size()>0) {
                    cadena.remove(cadena.size() - 1);
                    cadenatemporal.remove(cadenatemporal.size() - 1);
                    adapter.notifyDataSetChanged();
                    arrayAdaptertemp.notifyDataSetChanged();
                    adapteramino.notifyDataSetChanged();

                }

            }
        });


        spinner.setItems(getString(R.string.opcion1), getString(R.string.opcion2),getString(R.string.opcion3),getString(R.string.opcion4));
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                idSpinner = position;
                Snackbar.make(view, "Seleccionó: " + item,
                        Snackbar.LENGTH_LONG).show();
                opcionspinner(idSpinner);
                if (idSpinner!=3)
                {
                    cadenaamino.clear();
                }
                if (idSpinner==1||idSpinner==2)
                {
                    texto.setText("");
                }
                adapter.notifyDataSetChanged();
                arrayAdaptertemp.notifyDataSetChanged();
                adapteramino.notifyDataSetChanged();
            }
        });

    }

    private void setUpViews() {
        lista1 = (ListView) findViewById(R.id.lista1);
        lista2 = (ListView) findViewById(R.id.lista2);
        lista3 = (ListView) findViewById(R.id.lista3);
        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        texto=(TextView) findViewById(R.id.texto2);
    }

    private void initVars() {
        cadena = new ArrayList<>();
        adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
        lista1.setAdapter(adapter);
        cadenatemporal=new ArrayList<>();
        arrayAdaptertemp = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, cadenatemporal);
        lista2.setAdapter(arrayAdaptertemp);
        cadenaamino=new ArrayList<>();
        adapteramino = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, cadenaamino);
        lista3.setAdapter(adapteramino);
    }
    public void opcionspinner(int spin)
    {
        switch (spin){
            case 0:
                getComplementary();
                break;
            case 1:
                getReverse();
                break;
            case 2:
                getReverseComplementary();
                break;
            case 3:
                getComplementary();
                getARNtrans();
                break;
        }
    }
    public void getComplementary()
    {
        cadenatemporal.clear();
        for (int i=0;i<cadena.size();i++)
        {
            switch (cadena.get(i)){
                case "A":
                    cadenatemporal.add("T");
                    break;
                case "C":
                    cadenatemporal.add("G");
                    break;
                case "G":
                    cadenatemporal.add("C");
                    break;
                case "T":
                    cadenatemporal.add("A");
                    break;
            }
        }
    }
    public  void getReverse()
    {
        cadenatemporal.clear();
        for (int i=0;i<cadena.size();i++)
        {
            switch (cadena.get(i)){
                case "A":
                    cadenatemporal.add("T");
                    break;
                case "C":
                    cadenatemporal.add("G");
                    break;
                case "G":
                    cadenatemporal.add("C");
                    break;
                case "T":
                    cadenatemporal.add("A");
                    break;
            }
        }
        Collections.reverse(cadenatemporal);
    }
    public  void getReverseComplementary()
    {
        getReverse();
        for (int i=0;i<cadenatemporal.size();i++)
        {
            switch (cadenatemporal.get(i)){
                case "A":
                    cadenatemporal.set(i,"T");
                    break;
                case "C":
                    cadenatemporal.set(i,"G");
                    break;
                case "G":
                    cadenatemporal.set(i,"C");
                    break;
                case "T":
                    cadenatemporal.set(i,"A");
                    break;
            }
        }
    }
    public void getARNtrans()
    {
        cadenaamino.clear();
        for (int i=0;i<cadenatemporal.size();i++)
        {
            switch (cadenatemporal.get(i)){
                case "T":
                    cadenatemporal.set(i,"U");
                    break;
            }
        }
        String joined = TextUtils.join("", cadenatemporal);
        String t;

        for (int i=0;i<joined.length();i++){
            if ((i+1)%3==0){
                t=joined.substring(i-2,i+1);
                cadenaamino.add(getBaseamino(t));
            }
        }
    }

    public String getBaseamino(String a)
    {
        String b="";
        switch (a){
            case "GCU":
                b=AminoBase.aminoList[0];
                break;
            case "GCC":
                b=AminoBase.aminoList[0];
                break;
            case "GCA":
                b=AminoBase.aminoList[0];
                break;
            case "GCG":
                b=AminoBase.aminoList[0];
                break;
            ///----------------------//////
            case "CGU":
                b=AminoBase.aminoList[1];
                break;
            case "CGC":
                b=AminoBase.aminoList[1];
                break;
            case "CGA":
                b=AminoBase.aminoList[1];
                break;
            case "CGG":
                b=AminoBase.aminoList[1];
                break;
            case "AGA":
                b=AminoBase.aminoList[1];
                break;
            case "AGG":
                b=AminoBase.aminoList[1];
                break;
            //-///////////////////////
            case "AAU":
                b=AminoBase.aminoList[2];
                break;
            case "AAC":
                b=AminoBase.aminoList[2];
                break;
            //-///////////////////////
            case "GAU":
                b=AminoBase.aminoList[3];
                break;
            case "GAC":
                b=AminoBase.aminoList[3];
                break;
            //-///////////////////////
            case "UGU":
                b=AminoBase.aminoList[4];
                break;
            case "UGC":
                b=AminoBase.aminoList[4];
                break;
            //-///////////////////////
            case "CAA":
                b=AminoBase.aminoList[5];
                break;
            case "CAG":
                b=AminoBase.aminoList[5];
                break;
            //-///////////////////////
            case "GAA":
                b=AminoBase.aminoList[6];
                break;
            case "GAG":
                b=AminoBase.aminoList[6];
                break;
            //-///////////////////////
            case "GGU":
                b=AminoBase.aminoList[7];
                break;
            case "GGC":
                b=AminoBase.aminoList[7];
                break;
            case "GGA":
                b=AminoBase.aminoList[7];
                break;
            case "GGG":
                b=AminoBase.aminoList[7];
                break;
            //-///////////////////////
            case "CAU":
                b=AminoBase.aminoList[8];
                break;
            case "CAC":
                b=AminoBase.aminoList[8];
                break;
            //-///////////////////////
            case "AUU":
                b=AminoBase.aminoList[9];
                break;
            case "AUC":
                b=AminoBase.aminoList[9];
                break;
            case "AUA":
                b=AminoBase.aminoList[9];
                break;
            ///----------------------//////
            case "UUA":
                b=AminoBase.aminoList[10];
                break;
            case "UUG":
                b=AminoBase.aminoList[10];
                break;
            case "CUU":
                b=AminoBase.aminoList[10];
                break;
            case "CUC":
                b=AminoBase.aminoList[10];
                break;
            case "CUA":
                b=AminoBase.aminoList[10];
                break;
            case "CUG":
                b=AminoBase.aminoList[10];
                break;
            ///----------------------//////
            case "AAA":
                b=AminoBase.aminoList[11];
                break;
            case "AAG":
                b=AminoBase.aminoList[11];
                break;
            ///----------------------//////
            case "AUG":
                b=AminoBase.aminoList[12];
                break;
            ///----------------------//////
            case "UUU":
                b=AminoBase.aminoList[13];
                break;
            case "UUC":
                b=AminoBase.aminoList[13];
                break;
            ///----------------------//////
            case "CCU":
                b=AminoBase.aminoList[14];
                break;
            case "CCC":
                b=AminoBase.aminoList[14];
                break;
            case "CCA":
                b=AminoBase.aminoList[14];
                break;
            case "CCG":
                b=AminoBase.aminoList[13];
                break;
            ///----------------------//////
            case "UGA":
                b=AminoBase.aminoList[15];
                break;
            ///----------------------//////
            case "UCU":
                b=AminoBase.aminoList[16];
                break;
            case "UCC":
                b=AminoBase.aminoList[16];
                break;
            case "UCA":
                b=AminoBase.aminoList[16];
                break;
            case "UCG":
                b=AminoBase.aminoList[16];
                break;
            case "AGU":
                b=AminoBase.aminoList[16];
                break;
            case "AGC":
                b=AminoBase.aminoList[16];
                break;
            ///----------------------//////
            case "ACU":
                b=AminoBase.aminoList[17];
                break;
            case "ACC":
                b=AminoBase.aminoList[17];
                break;
            case "ACA":
                b=AminoBase.aminoList[17];
                break;
            case "ACG":
                b=AminoBase.aminoList[17];
                break;
            ///----------------------//////
            case "UGG":
                b=AminoBase.aminoList[18];
                break;
            ///----------------------//////
            case "UAU":
                b=AminoBase.aminoList[19];
                break;
            case "UAC":
                b=AminoBase.aminoList[19];
                break;
            ///----------------------//////
            case "GUU":
                b=AminoBase.aminoList[20];
                break;
            case "GUC":
                b=AminoBase.aminoList[20];
                break;
            case "GUA":
                b=AminoBase.aminoList[20];
                break;
            case "GUG":
                b=AminoBase.aminoList[20];
                break;
            case "UAG":
                b="Codon Inicial";
                break;
            default:
                b="No identificado";
                break;
        }
        return b;
    }
}
