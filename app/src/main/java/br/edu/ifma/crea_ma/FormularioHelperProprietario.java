package br.edu.ifma.crea_ma;

import android.widget.EditText;
import android.widget.RatingBar;

import br.edu.ifma.crea_ma.FormularioInfracoesActivity;
import br.edu.ifma.crea_ma.FormularioProprietariosActivity;
import br.edu.ifma.crea_ma.R;
import br.edu.ifma.crea_ma.modelo.Infracao;
import br.edu.ifma.crea_ma.modelo.Proprietario;

/**
 * Created by josemar on 13/09/17.
 */

public class FormularioHelperProprietario {

    private final EditText campoNomeProprietario;
    private final EditText campoCpf;
    private final EditText campoEmail;
    private final EditText campoTelefone;
    private final EditText campoEndereco;

    private Proprietario proprietario;

    public FormularioHelperProprietario(FormularioProprietariosActivity activity){

        campoNomeProprietario = (EditText) activity.findViewById(R.id.edtNomeProprietario);
        campoCpf = (EditText) activity.findViewById(R.id.edtCpf);
        campoEmail = (EditText) activity.findViewById(R.id.edtEmail);
        campoTelefone = (EditText) activity.findViewById(R.id.edtTelefone);
        campoEndereco = (EditText) activity.findViewById(R.id.edtEndereco);
        proprietario = new Proprietario();
    }


    public Proprietario pegaProprietario() {
        proprietario.setNome(campoNomeProprietario.getText().toString());
        proprietario.setCpf(campoCpf.getText().toString());
        proprietario.setEmail(campoEmail.getText().toString());
        proprietario.setTelefone(campoTelefone.getText().toString());
        proprietario.setEndereco(campoEndereco.getText().toString());
        return proprietario;
    }

    public void preencheFormularioProprietario(Proprietario proprietario) {
        campoNomeProprietario.setText(proprietario.getNome());
        campoCpf.setText(proprietario.getCpf());
        campoEmail.setText(proprietario.getEmail());
        campoTelefone.setText(proprietario.getTelefone());
        campoEndereco.setText(proprietario.getEndereco());
        this.proprietario = proprietario;

    }
}
