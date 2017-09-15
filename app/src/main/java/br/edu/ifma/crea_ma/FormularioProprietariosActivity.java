package br.edu.ifma.crea_ma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.edu.ifma.crea_ma.dao.ProprietarioDAO;
import br.edu.ifma.crea_ma.modelo.Proprietario;

public class FormularioProprietariosActivity extends AppCompatActivity {

    private FormularioHelperProprietario helperProprietario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_proprietarios);

        helperProprietario = new FormularioHelperProprietario(this);

        Intent intent = getIntent();
        Proprietario proprietario = (Proprietario) intent.getSerializableExtra("proprietario");
        if(proprietario != null){
            helperProprietario.preencheFormularioProprietario(proprietario);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario_proprietario, menu);

        //findViewById(R.id.menu_formulario_ok);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_proprietario_ok:
                Proprietario proprietario = helperProprietario.pegaProprietario();
                ProprietarioDAO dao = new ProprietarioDAO(this);

                if(proprietario.getIdProprietario() != null){
                    dao.altera(proprietario);
                } else {
                    dao.insere(proprietario);
                }
                dao.close();

                Toast.makeText(FormularioProprietariosActivity.this, "Proprietário " + proprietario.getNome() + " salvo com sucesso", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
