package com.emdev.recyclerviewexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.emdev.recyclerviewexample.R;
import com.emdev.recyclerviewexample.model.Persona;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaVH> {

    List<Persona> personasList;

    public PersonaAdapter(List<Persona> personasList) {
        this.personasList = personasList;
    }

    @NonNull
    @Override
    public PersonaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_persona, parent, false);

        return new PersonaVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaVH holder, int position) {
        holder.nombre.setText(personasList.get(position).getNombre());
        holder.edad.setText(personasList.get(position).getEdad());
        holder.direccion.setText(personasList.get(position).getDireccion());

    }

    @Override
    public int getItemCount() {
        return personasList.size();
    }
}

class PersonaVH extends RecyclerView.ViewHolder {

    TextView nombre;
    TextView edad;
    TextView direccion;
    ImageButton btnEliminar;

    private PersonaAdapter adapter;

    public PersonaVH(@NonNull View itemView) {
        super(itemView);

        nombre = itemView.findViewById(R.id.nombre);
        edad = itemView.findViewById(R.id.edad);
        direccion = itemView.findViewById(R.id.direccion);

        btnEliminar = itemView.findViewById(R.id.btn_eliminar_persona);
        btnEliminar.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext(), R.style.CustomDialogThemeEliminar);
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


        });

    }

    public PersonaVH linkAdapter (PersonaAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
