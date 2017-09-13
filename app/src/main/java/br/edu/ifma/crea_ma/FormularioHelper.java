package br.edu.ifma.crea_ma;

import android.app.Activity;
import android.widget.EditText;
import android.widget.RatingBar;

import br.edu.ifma.crea_ma.modelo.Infracao;

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

    public FormularioHelper(FormularioInfracoesActivity activity){

        campoNome = (EditText) activity.findViewById(R.id.edtNomeNotificado);
        campoDadosObra = (EditText) activity.findViewById(R.id.edtDadosObra);
        campoEtapasConcluidas = (EditText) activity.findViewById(R.id.edtEtapasConcluidas);
        campoInfracoesCometidas = (EditText) activity.findViewById(R.id.edtInfracoesCometidas);
        campoValorMulta = (EditText) activity.findViewById(R.id.edtValorMulta);
        campoNotaInfracao = (RatingBar) activity.findViewById(R.id.rtbFormularioInfracao);
    }

    public Infracao pegaInfracao() {
        Infracao infracao = new Infracao();
        infracao.setNomeNotificado(campoNome.getText().toString());
        infracao.setDadosObra(campoDadosObra.getText().toString());
        infracao.setEtapasConcluidas(campoEtapasConcluidas.getText().toString());
        infracao.setInfracoesCometidas(campoInfracoesCometidas.getText().toString());
        infracao.setValorMulta(Double.parseDouble(campoValorMulta.getText().toString()));
        infracao.setNotaInfracao(Double.valueOf(campoNotaInfracao.getProgress()));

        return infracao;
    }
}
