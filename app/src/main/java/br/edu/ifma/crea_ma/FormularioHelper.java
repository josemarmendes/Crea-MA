package br.edu.ifma.crea_ma;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import br.edu.ifma.crea_ma.modelo.Infracao;
import br.edu.ifma.crea_ma.modelo.Proprietario;

/**
 * Created by josemar on 13/09/17.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoDadosObra;
    private final EditText campoEtapasConcluidas;
    private final EditText campoInfracoesCometidas;
    private final EditText campoValorMulta;
    private final RatingBar campoNotaInfracao;
    private final ImageView campoFoto;

    private Infracao infracao;

    public FormularioHelper(FormularioInfracoesActivity activity){

        campoNome = (EditText) activity.findViewById(R.id.edtNomeNotificado);
        campoDadosObra = (EditText) activity.findViewById(R.id.edtDadosObra);
        campoEtapasConcluidas = (EditText) activity.findViewById(R.id.edtEtapasConcluidas);
        campoInfracoesCometidas = (EditText) activity.findViewById(R.id.edtInfracoesCometidas);
        campoValorMulta = (EditText) activity.findViewById(R.id.edtValorMulta);
        campoNotaInfracao = (RatingBar) activity.findViewById(R.id.rtbFormularioInfracao);
        campoFoto = (ImageView) activity.findViewById(R.id.formulario_foto_infracao);;
        infracao = new Infracao();

    }


    public Infracao pegaInfracao() {
        infracao.setNomeNotificado(campoNome.getText().toString());
        infracao.setDadosObra(campoDadosObra.getText().toString());
        infracao.setEtapasConcluidas(campoEtapasConcluidas.getText().toString());
        infracao.setInfracoesCometidas(campoInfracoesCometidas.getText().toString());
        infracao.setValorMulta(Double.parseDouble(campoValorMulta.getText().toString()));
        infracao.setNotaInfracao(Double.valueOf(campoNotaInfracao.getProgress()));
        infracao.setCaminhoFoto((String) campoFoto.getTag());
        return infracao;
    }


    public void preencheFormularioInfracao(Infracao infracao) {
        campoNome.setText(infracao.getNomeNotificado());
        campoDadosObra.setText(infracao.getDadosObra());
        campoEtapasConcluidas.setText(infracao.getEtapasConcluidas());
        campoInfracoesCometidas.setText(infracao.getInfracoesCometidas());
        campoValorMulta.setText(infracao.getValorMulta().toString());
        campoNotaInfracao.setProgress(infracao.getNotaInfracao().intValue());
        carregaImagem(infracao.getCaminhoFoto());
        this.infracao = infracao;
    }

    public void carregaImagem(String caminhoFoto) {
        if(caminhoFoto != null){
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 300, 300, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);
            campoFoto.setTag(caminhoFoto);
        }

    }
}
