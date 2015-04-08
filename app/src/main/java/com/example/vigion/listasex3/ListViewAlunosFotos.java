package com.example.vigion.listasex3;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewAlunosFotos extends ActionBarActivity {

    private List<Aluno> alunos2GI = new ArrayList<Aluno>();

    public void loadList(){
        alunos2GI.add(new Aluno(0, "Prof. Ferraz", R.drawable.setor));
        alunos2GI.add(new Aluno(1, "Bruno Coimbra", R.drawable.setor));
        alunos2GI.add(new Aluno(2, "Catalin Criste", R.drawable.setor));
        alunos2GI.add(new Aluno(3, "David Sousa", R.drawable.setor));
        alunos2GI.add(new Aluno(6, "Joao Ventura", R.drawable.setor));
        alunos2GI.add(new Aluno(7, "Jorge Silva", R.drawable.setor));
        alunos2GI.add(new Aluno(8, "Marcelo Rachado", R.drawable.setor));
        alunos2GI.add(new Aluno(9, "Mariana Costa", R.drawable.setor));
        alunos2GI.add(new Aluno(10, "Patricia Carmo", R.drawable.setor));
        alunos2GI.add(new Aluno(11, "Ricardo Gomes", R.drawable.setor));
        alunos2GI.add(new Aluno(12, "Ruben Severino", R.drawable.setor));
        alunos2GI.add(new Aluno(14, "Rui Ricardo", R.drawable.setor));
        alunos2GI.add(new Aluno(15, "Samuel Santos", R.drawable.setor));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        loadList(); //Executa o metodo para preencher a lista com alunos

        //obter o controlo da ListView Grafica
        ListView listViewTurmas = (ListView) findViewById(R.id.listViewTurma);

        //Criação de um ArrayAdapter para transformar a nossa lista de Alunos para a ListView
        ListViewAlunosAdapter adapter = new ListViewAlunosAdapter(this, alunos2GI);
        //Envia esta activity e a Collection listAlunos

        //Associação da listView ao adapter. Passa os dados preparados para ListView
        listViewTurmas.setAdapter(adapter);
            //este metodo vai usar a getView que redefinimos no nosso adapter
            //para construir cada um dos itens da listView

        //Criar um listener para cada item da ListView
        listViewTurmas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Compor uma string com a posição no array para
                //Escrever um Toast com o id do item clicado

                Aluno aluno = alunos2GI.get(position);
                String str = "Clicou na posição" + position + ", " + aluno.getNome();
                Toast.makeText(ListViewAlunosFotos.this, str, Toast.LENGTH_SHORT).show();
            }
        });

    }

}

class ListViewAlunosAdapter extends ArrayAdapter<Aluno>{

    //Construtor, recebe a activity e a lista de dados
    public ListViewAlunosAdapter(Context context, List<Aluno> listaAlunos){

        super(context, R.layout.item_view, listaAlunos);

        //A classe ArrayAdapter, super, recebe:
        //1º: a propria activity
        //2º: o layout para os itensda listView
        //3º: a lista de dados (collection com objetos Aluno)
    }

    //getView é executado na superclasse, em ciclo, para processar cada um dositens da
    //ListView, tantas vezes como o numero de elementos da Lista de Alunos


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //recebe 3 elementos:
        //position- da lista de dados a ser processada : 0 será o primeiro aluno na lista
        //convertView será a view itemLayout a ser devolvida já preenchida
        //parent é a tootLayout, onde cada itemLayout vai ser desenhada, ou seja, a ListView Grafica


        //Preparação do itemLayout na ListView Grafica
        if (convertView == null){

            //Se já existir um itemLayout usa-o, caso contrario cria um novo
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);

            //LayoutInflater é metodo da superclasse que constroi Layouts
            //Passamos-lhe o itemLayout e a rootLayout (ListView Grafica) onde desenha
        }

        //Ligação dos dados de um aluno na posicao "position" da Collection ás Views do itemLayout
        Aluno aluno = getItem(position);

        //Imagem - obtem acesso á imageView do itemLayout e passo-lhe o id da imagem do aluno
        ImageView itemImage = (ImageView) convertView.findViewById(R.id.imageViewAluno);
        itemImage.setImageResource(aluno.getId());

        //numero de aluno - obtem acesso á textView do itemLayout e passa-lhe o º do aluno
        TextView itemNturma = (TextView) convertView.findViewById(R.id.textViewNumero);
        itemNturma.setText(String.valueOf(aluno.getNumero()));
        //Atenção aos erros de tipo só sao detetaveis no logCat

        //Nome - obtem acesso á textView do itemLayout e passa-lhe o nome do aluno
        TextView itemNomeAluno = (TextView) convertView.findViewById(R.id.textViewNome);
        itemNomeAluno.setText(aluno.getNome());

        return convertView; //devolve o itemLayout preenchido, pronto a ser adicionado á listView
    }
}