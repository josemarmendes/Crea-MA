package br.edu.ifma.crea_ma.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifma.crea_ma.modelo.Infracao;

/**
 * Created by josemar on 15/09/17.
 */

public class InfracoesAdapter extends BaseAdapter{


    private final List<Infracao> infracoes;
    private final Context context;

    public InfracoesAdapter(Context context, List<Infracao> infracoes) {
        this.context = context;
        this.infracoes = infracoes;
    }

    @Override
    public int getCount() {
        return infracoes.size();
    }

    @Override
    public Object getItem(int posicao) {
        return infracoes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {
        return infracoes.get(posicao).getId();
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        TextView view = new TextView(context);
        Infracao infracao = infracoes.get(posicao);
        view.setText(infracao.toString());
        return view;
    }
}
