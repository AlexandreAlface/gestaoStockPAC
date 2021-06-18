package pt.ipbeja.PAC_Project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.ipbeja.PAC_Project.ComponentActivity;
import pt.ipbeja.PAC_Project.R;
import pt.ipbeja.PAC_Project.models.Category;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder> {

    private final Context context;

    private List<Category> categoryList;

    public CategoryListAdapter(Context context){

        this.context  = context;
        this.categoryList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoryListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_category_list_adapter,parent,false);

        return new CategoryListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListViewHolder holder, int position) {

        Category category = this.categoryList.get(position);
        holder.textViewCategoryDesignation.setText(category.getdesignation());

        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ComponentActivity.startActivity(CategoryListAdapter.this.context, category.getIdCategory());

            }
        });

    }

    @Override
    public int getItemCount() {
        return this.categoryList.size();
    }

    public void refreshList(List<Category> categoryList)
    {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    class CategoryListViewHolder extends RecyclerView.ViewHolder {

        View parentView;
        TextView textViewCategoryDesignation;

        public CategoryListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.parentView = itemView;
            this.textViewCategoryDesignation = itemView.findViewById(R.id.textViewCategory);

        }
    }





}
