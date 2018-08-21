package com.aulamobile.aulamobile;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RecycleViewHolder> {

    private List<Tarefa> mList;
    private Context mContext;
    private  MainActivity activity;
    private AppCompatImageView fabRemove;

    public ListAdapter(Context context, List<Tarefa> list) {
        this.mContext = context;
        this.activity = (MainActivity) context;
        this.mList = list;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.row, parent, false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        Tarefa tarefa = mList.get(position);
        holder.tvTarefa.setText(tarefa.getTarefa());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class RecycleViewHolder
            extends RecyclerView.ViewHolder {

        protected TextView tvTarefa;
        protected AppCompatImageView llRow;

        public RecycleViewHolder(View itemView) {
            super(itemView);
            tvTarefa = itemView.findViewById(R.id.tv_tarefa);
            llRow = itemView.findViewById(R.id.fabRemove);
            llRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tarefa tarefa = mList.get(getAdapterPosition());
                    activity.onClickList(tarefa);
                }
            });
        }
    }
}
