package com.ashwin_sudhakar.myretrofitapplication.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ashwin_sudhakar.myretrofitapplication.Model.DataModel;
import com.ashwin_sudhakar.myretrofitapplication.R;

import java.util.List;

public class DataAdaptor extends RecyclerView.Adapter<DataAdaptor.ViewHolder> {

    List<DataModel> dataModelList;

    public DataAdaptor(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mId.setText(dataModelList.get(position).getmId());
        holder.mTitle.setText(dataModelList.get(position).getmTitle());
        holder.mBody.setText(dataModelList.get(position).getmBody());
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mId;
        private TextView mTitle;
        private TextView mBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mId = itemView.findViewById(R.id.txt_id);
            mTitle = itemView.findViewById(R.id.txt_title);
            mBody = itemView.findViewById(R.id.txt_body);
        }
    }
}
