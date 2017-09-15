package br.edu.ifma.crea_ma.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.edu.ifma.crea_ma.R;
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
        Infracao infracao = infracoes.get(posicao);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item_infracao, parent, false);
        }

        TextView campoNome = (TextView) view.findViewById(R.id.item_nome_infracao);
        campoNome.setText(infracao.getNomeNotificado());

        TextView campoTipoInfracao = (TextView) view.findViewById(R.id.item_nome_tipoinfracao);
        campoTipoInfracao.setText(infracao.getInfracoesCometidas());

        ImageView campoFotoInfracao = (ImageView) view.findViewById(R.id.item_foto_list_infracao);
        String caminhoFoto = infracao.getCaminhoFoto();

        if(caminhoFoto != null){
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            campoFotoInfracao.setImageBitmap(bitmapReduzido);
            campoFotoInfracao.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFotoInfracao.setTag(caminhoFoto);
        }

        return view;
    }
}
