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
import pt.ipbeja.PAC_Project.models.Favourite;
import pt.ipbeja.PAC_Project.models.UserLogin;


public class ComponentsOnFavouriteListAdapter extends RecyclerView.Adapter<ComponentsOnFavouriteListAdapter.ComponentsOnCartFavouriteViewHolder> {

    private final Context context;
    private List<Favourite> FavouriteList;
    private UserLogin userLogin;

    public ComponentsOnFavouriteListAdapter(Context context){

        this.context  = context;
        this.FavouriteList = new ArrayList<>();
        this.userLogin = AppDataBase.getInstance(context).databaseDAO().lastLogin();

    }

    @NonNull
    @Override
    public ComponentsOnCartFavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_components_favourite,parent,false);

        return new ComponentsOnCartFavouriteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ComponentsOnCartFavouriteViewHolder holder, int position) {

        Favourite favourite = this.FavouriteList.get(position);

        holder.TextViewComponentFavourite.setText(String.valueOf(favourite.getIdComp()));

        holder.buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


                Favourite newComponentAddToFavourite = new Favourite(userLogin.getIdUser(), favourite.getIdComp(), 1);

                AppDataBase.getInstance(context).databaseDAO().addComponentFavourite(newComponentAddToFavourite);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.FavouriteList.size();
    }

    public void refreshList(List<Favourite> FavouriteList)
    {
        this.FavouriteList = FavouriteList;
        notifyDataSetChanged();
    }

    class ComponentsOnCartFavouriteViewHolder extends RecyclerView.ViewHolder {

        View parentView;
        TextView TextViewComponentFavourite;
        Button buttonAddToCart;


        public ComponentsOnCartFavouriteViewHolder(@NonNull View itemView) {

            super(itemView);
            this.parentView = itemView;
            this.TextViewComponentFavourite = itemView.findViewById(R.id.TextViewComponentFavourite);
            this.buttonAddToCart = itemView.findViewById(R.id.buttonAddCart);


        }
    }





}
