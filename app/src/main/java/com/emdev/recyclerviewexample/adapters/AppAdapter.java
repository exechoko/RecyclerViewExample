package com.emdev.recyclerviewexample.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emdev.recyclerviewexample.R;

import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppVH> {

    //Esta lista puede ser de un modelo
    List<String> itemsList;

    public AppAdapter(List<String> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public AppVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_para_recycler, parent, false);

        return new AppVH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull AppVH holder, int position) {
        holder.texto.setText(itemsList.get(position));

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}

class AppVH extends RecyclerView.ViewHolder {

    TextView texto;
    ImageButton btnEliminar;

    private AppAdapter adapter;

    public AppVH(@NonNull View itemView) {
        super(itemView);

        texto = itemView.findViewById(R.id.textDelItem);
        btnEliminar = itemView.findViewById(R.id.btn_eliminar);

        btnEliminar.setOnClickListener(view -> {
            adapter.itemsList.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());

        });
    }

    public AppVH linkAdapter(AppAdapter adapter){
        this.adapter = adapter;
        return this;
    }
}
