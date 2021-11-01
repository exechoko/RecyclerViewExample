package com.emdev.recyclerviewexample.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emdev.recyclerviewexample.AdapterCallback;
import com.emdev.recyclerviewexample.R;
import com.emdev.recyclerviewexample.model.Persona;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaVH> {

    List<Persona> personasList;
    private final AdapterCallback callback;

    public PersonaAdapter(List<Persona> personasList, AdapterCallback adapterCallback) {
        this.personasList = personasList;
        callback = adapterCallback;
    }

    @NonNull
    @Override
    public PersonaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_persona, parent, false);

        return new PersonaVH(view, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaVH holder, int position) {
        holder.bind(personasList.get(position));
        //remove this
        /*holder.nombre.setText(personasList.get(position).getNombre());
        holder.edad.setText(personasList.get(position).getEdad());
        holder.direccion.setText(personasList.get(position).getDireccion());
        */
    }

    @Override
    public int getItemCount() {
        return personasList.size();
    }

    public void removeAndUpdate(Persona person) {
        if (personasList.contains(person)) {
            int itemPosition = personasList.indexOf(person);
            personasList.remove(itemPosition);
            notifyItemRemoved(itemPosition);
        }
    }
}

class PersonaVH extends RecyclerView.ViewHolder {

    TextView nombre;
    TextView edad;
    TextView direccion;
    ImageButton btnEliminar;

    private PersonaAdapter adapter;
    private final AdapterCallback callback;

    public PersonaVH(@NonNull View itemView, AdapterCallback adapterCallback) {
        super(itemView);
        callback = adapterCallback;
        nombre = itemView.findViewById(R.id.nombre);
        edad = itemView.findViewById(R.id.edad);
        direccion = itemView.findViewById(R.id.direccion);
        btnEliminar = itemView.findViewById(R.id.btn_eliminar_persona);
    }

    void bind(Persona item) {

        nombre.setText(item.getNombre());
        edad.setText(item.getEdad());
        direccion.setText(item.getDireccion());

        btnEliminar.setOnClickListener(v -> {
            callback.showDialog(item);
            //move this to view
            /*AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext(), R.style.CustomDialogThemeEliminar);
            builder.setTitle("Eliminar")
                    .setMessage("Está seguro que desea eliminar")
                    .setCancelable(false)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("Eliminar", (dialog, which) -> {
                        adapter.personasList.remove(getAdapterPosition());
                        adapter.notifyItemRemoved(getAdapterPosition());
                    })
                    .setNegativeButton("Cancelar", null);

            builder.show();
           */

        });
    }

    //remove this
    public PersonaVH linkAdapter(PersonaAdapter adapter) {
        this.adapter = adapter;
        return this;
    }
}
