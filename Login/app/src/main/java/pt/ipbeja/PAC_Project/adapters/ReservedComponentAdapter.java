package pt.ipbeja.PAC_Project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.PAC_Project.R;
import pt.ipbeja.PAC_Project.models.ReserveComponent;

public class ReservedComponentAdapter extends RecyclerView.Adapter<ReservedComponentAdapter.ReservedComponentViewHolder> {

    private final Context context;

    private List<ReserveComponent> reserveComponent;

    public ReservedComponentAdapter(Context context){

        this.context  = context;
        this.reserveComponent = new ArrayList<>();

    }

    @NonNull
    @Override
    public ReservedComponentAdapter.ReservedComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_reserved_component,parent,false);

        return new ReservedComponentViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ReservedComponentViewHolder holder, int position) {

        ReserveComponent reserveComponent = this.reserveComponent.get(position);

        holder.reservedComponent.setText(String.valueOf(reserveComponent.getIdComp()));

    }

    @Override
    public int getItemCount() {
        return this.reserveComponent.size();
    }

    public void refreshList(List<ReserveComponent> reserveComponent)
    {
        this.reserveComponent = reserveComponent;
        notifyDataSetChanged();
    }

    class ReservedComponentViewHolder extends RecyclerView.ViewHolder {

        View parentView;
        TextView reservedComponent;


        public ReservedComponentViewHolder(@NonNull View itemView) {
            super(itemView);

            this.parentView = itemView;
            this.reservedComponent = itemView.findViewById(R.id.textViewReservedComponent);

        }
    }


}
