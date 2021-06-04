package sg.edu.np.mad.madapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BrandsAdaptor extends RecyclerView.Adapter<BrandViewholder> {
    private final Context context;
    ArrayList<user> data;

    public BrandsAdaptor(ArrayList<user> input, Context context) {
        this.data = input;
        this.context = context;
    }

    public BrandViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if (viewType == 1){
            item= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_7th_layout, parent, false);
        }
        else{
            item= LayoutInflater.from(parent.getContext()).inflate(R.layout.listlayout, parent, false);
        }
        return new BrandViewholder(item);
    }




    public void onBindViewHolder(BrandViewholder holder, int position){
        user list_items = data.get(position);
        holder.name.setText(list_items.getName());
        holder.id.setText(String.valueOf(list_items.getId()));
        holder.Description.setText(list_items.getDescription());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("Profile");
                builder.setMessage(list_items.getName()+ list_items.getId());
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("User position", position);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });

    }

    public ArrayList<user> getData() {
        return data;
    }

    public int getItemCount() {
        return data.size();
    }


    @Override
    public int getItemViewType(int position) {
        user list_items = data.get(position);
        String idstring = String.valueOf(list_items.getId());
        char id_last = idstring.charAt(idstring.length()-1);
        if (id_last == '7'){
            return 1;
        }
        else{
            return 0;
        }
    }


}

