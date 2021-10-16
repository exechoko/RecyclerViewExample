package com.emdev.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.emdev.recyclerviewexample.adapters.AppAdapter;
import com.emdev.recyclerviewexample.adapters.PersonaAdapter;
import com.emdev.recyclerviewexample.model.Persona;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Lista de string
    String []datos = {"Hola", "Hello", "Welcome"};
    int contador = 0;

    //Lista de personas
    List<Persona> personas;

    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregar = findViewById(R.id.btn_agregar);

        //Esta lista puede ser de un modelo
        List<String> items = new LinkedList<>();

        //Genero el listado de personas
        personas = new ArrayList<>();
        personas.add(new Persona("Exequiel","33 años","Paraná - Entre Ríos"));
        personas.add(new Persona("Ernesto","23 años","Oro Verde - Entre Ríos"));
        personas.add(new Persona("Nicolas","20 años","Flores - Buenos Aires"));
        personas.add(new Persona("Lucía","33 años","Rosario - Santa Fe"));
        personas.add(new Persona("Matías","15 años","Madrid - España"));
        //--------


        RecyclerView recyclerView = findViewById(R.id.recycler);
        //AppAdapter adapter = new AppAdapter(items);
        PersonaAdapter adapterPerson = new PersonaAdapter(personas);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(adapterPerson);

        btnAgregar.setOnClickListener(v -> {
//            Agrega datos String
//            items.add(datos[contador%3]);
//            /*
//            * contador%3 para agregar entre 0, 1 y 2 porque es la cant de elementos
//            * que hay en el arreglo inicial
//            *  */
//            contador++;
//            adapter.notifyItemInserted(items.size()-1);

//            Agrega personas
            personas.add(new Persona("Pablo", "50 años", "El Cairo - Egipto"));
            adapterPerson.notifyItemInserted(personas.size()-1);

        });
    }
}