package pt.ipbeja.PAC_Project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import pt.ipbeja.PAC_Project.R;
import pt.ipbeja.PAC_Project.database.AppDataBase;
import pt.ipbeja.PAC_Project.models.Cart;
import pt.ipbeja.PAC_Project.models.Component;
import pt.ipbeja.PAC_Project.models.Favourite;
import pt.ipbeja.PAC_Project.models.ReserveComponent;
import pt.ipbeja.PAC_Project.models.UserLogin;


public class ComponentsOnCartListAdapter extends RecyclerView.Adapter<ComponentsOnCartListAdapter.ComponentsOnCartListViewHolder> {

    private final Context context;

    private List<Cart> cartList;

    private UserLogin userLogin;


    public ComponentsOnCartListAdapter(Context context){

        this.context  = context;
        this.cartList = new ArrayList<>();
        this.userLogin = AppDataBase.getInstance(context).databaseDAO().lastLogin();

    }

    @NonNull
    @Override
    public ComponentsOnCartListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_components_on_cart,parent,false);

        return new ComponentsOnCartListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ComponentsOnCartListViewHolder holder, int position) {

        Cart cart = this.cartList.get(position);

        holder.componentOnCart.setText(String.valueOf(cart.getIdComp()));

        holder.buttonAddToFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                Favourite newComponentAddToFavourite = new Favourite(userLogin.getIdUser(), cart.getIdComp(), 1);

                AppDataBase.getInstance(context).databaseDAO().addComponentFavourite(newComponentAddToFavourite);
            }
        });

        holder.buttonReserveComponent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                ReserveComponent newReservedComponent = new ReserveComponent(userLogin.getIdUser(), cart.getIdComp(), 1);
                AppDataBase.getInstance(context).databaseDAO().addReserveComponent(newReservedComponent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.cartList.size();
    }

    public void refreshList(List<Cart> cartList)
    {
        this.cartList = cartList;
        notifyDataSetChanged();
    }

    class ComponentsOnCartListViewHolder extends RecyclerView.ViewHolder {

        View parentView;
        TextView componentOnCart;
        Button buttonAddToFavourite;
        Button buttonReserveComponent;


        public ComponentsOnCartListViewHolder(@NonNull View itemView) {

            super(itemView);
            this.parentView = itemView;
            this.componentOnCart = itemView.findViewById(R.id.textViewComponentCart);
            this.buttonAddToFavourite = itemView.findViewById(R.id.buttonAddComponentFavourite);
            this.buttonReserveComponent = itemView.findViewById(R.id.buttonReservComponent);


        }
    }





}
