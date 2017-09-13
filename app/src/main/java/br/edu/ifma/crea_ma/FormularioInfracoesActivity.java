package br.edu.ifma.crea_ma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifma.crea_ma.dao.InfracaoDAO;
import br.edu.ifma.crea_ma.modelo.Infracao;

public class FormularioInfracoesActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_infracoes);

        helper = new FormularioHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        //findViewById(R.id.menu_formulario_ok);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:

                Infracao infracao = helper.pegaInfracao();
                InfracaoDAO dao = new InfracaoDAO(this);
                dao.insere(infracao);
                dao.close();

                Toast.makeText(FormularioInfracoesActivity.this, "Infração " + infracao.getNomeNotificado() + " salva com sucesso", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
