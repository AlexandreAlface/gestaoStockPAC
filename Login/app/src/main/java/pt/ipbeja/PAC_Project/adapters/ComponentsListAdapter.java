package pt.ipbeja.PAC_Project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.PAC_Project.R;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Cart;
import pt.ipbeja.PAC_Project.models.Category;
import pt.ipbeja.PAC_Project.models.Component;
import pt.ipbeja.PAC_Project.models.Favourite;
import pt.ipbeja.PAC_Project.models.UserLogin;

public class ComponentsListAdapter extends RecyclerView.Adapter<ComponentsListAdapter.ComponentsListViewHolder> {

    private final Context context;

    private List<Component> componentList;

    private UserLogin userLogin;

    private Cart lastIdCart;

    private Favourite lastIdFavourite;



    public ComponentsListAdapter(Context context){

        this.context  = context;
        this.componentList = new ArrayList<>();
        this.userLogin = AppDataBase.getInstance(context).databaseDAO().lastLogin();
        this.lastIdCart = AppDataBase.getInstance(context).databaseDAO().lastIdCart();
        this.lastIdFavourite = AppDataBase.getInstance(context).databaseDAO().getLastidFavourite();
    }

    @NonNull
    @Override
    public ComponentsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_component_buy_fav,parent,false);

        return new ComponentsListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ComponentsListViewHolder holder, int position) {

        Component component = this.componentList.get(position);
        holder.textViewComponentDesignation.setText(component.getDesignation());

        holder.buttonAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                    Cart newComponentAddToCart = new Cart(userLogin.getIdUser(), component.getIdCategory(), 1);
                    AppDataBase.getInstance(context).databaseDAO().addComponentCart(newComponentAddToCart);

            }
        });

        holder.buttonAddFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                Favourite newComponentAddToFavourite = new Favourite(userLogin.getIdUser(), component.getIdCategory(), 1);

                AppDataBase.getInstance(context).databaseDAO().addComponentFavourite(newComponentAddToFavourite);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.componentList.size();
    }

    public void refreshList(List<Component> componentList)
    {
        this.componentList = componentList;
        notifyDataSetChanged();
    }

    class ComponentsListViewHolder extends RecyclerView.ViewHolder {

        View parentView;
        TextView textViewComponentDesignation;
        Button buttonAddCart;
        Button buttonAddFavourite;

        public ComponentsListViewHolder(@NonNull View itemView) {
            super(itemView);

            this.parentView = itemView;
            this.textViewComponentDesignation = itemView.findViewById(R.id.textViewComponent);
            this.buttonAddCart = itemView.findViewById(R.id.buttonAddToCart);
            this.buttonAddFavourite = itemView.findViewById(R.id.buttonAddToFav);

        }
    }





}
