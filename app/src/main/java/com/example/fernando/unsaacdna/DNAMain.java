package com.example.fernando.unsaacdna;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

public class DNAMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //------Instancias------//
    List<String> cadena;
    List<String> cadenatemporal;
    List<String> cadenaaminos;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdaptertemp;
    ArrayAdapter<String> arrayAdapterAmino;
    ArrayAdapter<String> arrayAmino;
    MaterialSpinner cmbOpciones;
    Button butA;
    Button butT;
    Button butG;
    Button butC;
    Button butDel;
    ListView list;
    ListView listtemp;
    ListView listAmino;
    int idspinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dnamain);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //-----------------Codigo DNA ----------------------------------------/
        butA=(Button) findViewById(R.id.butA);
        butA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("A");
                adapter(idspinner);
            }
        });
        butT=(Button) findViewById(R.id.butT);
        butT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("T");
                adapter(idspinner);
            }
        });
        butG=(Button) findViewById(R.id.butG);
        butG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("G");
                adapter(idspinner);
            }
        });
        butC=(Button) findViewById(R.id.butC);
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadena.add("C");
                adapter(idspinner);
            }
        });
        butDel=(Button) findViewById(R.id.butDel);
        butDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cadena.size()>0) {
                    cadena.remove(cadena.size() - 1);
                    adapter(idspinner);
                }
            }
        });
        list = (ListView) findViewById(R.id.lista1);
        listtemp = (ListView) findViewById(R.id.lista2);
        listAmino = (ListView) findViewById(R.id.lista3);
        cadena = new ArrayList<String>();
        cadenaaminos = new ArrayList<String>();
        cadenatemporal=new ArrayList<String>();
        //cadenatemporal=new ArrayList<String>();
        idspinner=0;
        cmbOpciones = (MaterialSpinner) findViewById(R.id.spinenr);
        cmbOpciones.setItems(getString(R.string.opcion1),getString(R.string.opcion2));
        cmbOpciones.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                idspinner=position;
                Snackbar.make(view, "Eligio :  " + cadena.get(2) + item, Snackbar.LENGTH_LONG).show();
            }
        });
        String b="prueba";

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dnamain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public  void adapter(int id)
    {
        arrayAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadena);
        list.setAdapter(arrayAdapter);
        switch (id){
            case 0:
                getComplementary();
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

        arrayAdaptertemp= new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadenatemporal );
        listtemp.setAdapter(arrayAdaptertemp);

        getAminos();
    }
    public void getReverse()
    {

    }
    public void getAminos()
    {
        cadenaaminos.clear();
        String joined = TextUtils.join("", cadenatemporal);
        String t;

         for (int i=0;i<joined.length();i++){
             if ((i+1)%3==0){
                t=joined.substring(i-2,i+1);

                 cadenaaminos.add(getBaseamino(t));
                 //Snackbar.make(this.getWindow().getDecorView().findViewById(android.R.id.content), t, Snackbar.LENGTH_LONG).setActionTextColor(Color.RED)
                 //        .setAction("Action", null).show();
             }
         }
        arrayAdapterAmino= new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, cadenaaminos );
        listAmino.setAdapter(arrayAdapterAmino);
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
            default:
                b="No identificado";
                break;
        }
        return b;
    }
}
