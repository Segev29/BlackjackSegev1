package com.example.blackjacksegev;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class MoneyAdapter extends RecyclerView.Adapter<MoneyAdapter.UserViewHolder> {

    //this context we will use to inflate the layout
    private Context context;

    //storing all the records in a list
    private List<MyMoney> recordsList;

    public MoneyAdapter(Context context, List<MyMoney> recordsList) {
        this.context = context;
        this.recordsList = recordsList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_layout, null);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // read eachtime from arraylist object and write to listview Item
        //getting the record of the specified position
        MyMoney money = recordsList.get(position);

        // TODO: update according to your Class
        holder.tvName.setText(money.getName());

        // convert int to String by:  ""+int
        holder.tvRecord.setText(""+money.getScore());

    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvRecord;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            // TODO:
            tvName = itemView.findViewById(R.id.tvName);
            tvRecord = itemView.findViewById(R.id.tvScore);
        }
    }

}
