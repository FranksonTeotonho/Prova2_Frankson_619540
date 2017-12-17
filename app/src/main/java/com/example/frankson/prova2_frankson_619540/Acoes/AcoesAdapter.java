package com.example.frankson.prova2_frankson_619540.Acoes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.frankson.prova2_frankson_619540.R;
import com.example.frankson.prova2_frankson_619540.entity.AcaoEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by frankson on 16/12/17.
 */

public class AcoesAdapter extends RecyclerView.Adapter<AcoesAdapter.ViewHolder>{

    private Context context;
    private List<AcaoEntity> acoesList;
    OnRecyclerViewSelected mOnRecyclerViewSelected;

    //Construtor que recebe a lista
    AcoesAdapter(List<AcaoEntity> acoesList, Context context) {
        this.acoesList = acoesList;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.acao_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AcaoEntity acaoEntity = acoesList.get(position);

        holder.txAcaoName.setText(acaoEntity.getName());

        Picasso.with(context)
                .load(acaoEntity.getImage())
                .centerCrop()
                .fit()
                .into(holder.imgBackgroud);
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return acoesList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tx_acao_name)
        TextView txAcaoName;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(mOnRecyclerViewSelected != null)
                mOnRecyclerViewSelected.onClick(view, getAdapterPosition());
        }


    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.mOnRecyclerViewSelected = onRecyclerViewSelected;
    }
}
