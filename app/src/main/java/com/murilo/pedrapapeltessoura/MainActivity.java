package com.murilo.pedrapapeltessoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("papel");
    }

    public void selecionarTessoura(View view) {
        verificarGanhador("tessoura");
    }

    private String gerarEscolha() {

        String[] opcoes = {"pedra", "papel", "tessoura"};
        int numeroAleatorio = new Random().nextInt(3); // 0 1 2

        ImageView imageEscolhaApp = findViewById(R.id.layout_main_img_padrao);

        switch (opcoes[numeroAleatorio]) {
            case "pedra":
                imageEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "tessoura":
                imageEscolhaApp.setImageResource(R.drawable.tessoura);
                break;
        }
        return opcoes[numeroAleatorio];
    }

    private void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolha();

        TextView textResultado = findViewById(R.id.layout_main_resultado);

        if (escolhaUsuario.equals("pedra") && escolhaApp.equals("tessoura") ||
                escolhaUsuario.equals("papel") && escolhaApp.equals("pedra") ||
                escolhaUsuario.equals("tessoura") && escolhaApp.equals("papel")) {
            textResultado.setText("Você ganhou!");
        } else if (escolhaUsuario.equals("tessoura") && escolhaApp.equals("pedra") ||
                escolhaUsuario.equals("pedra") && escolhaApp.equals("papel") ||
                escolhaUsuario.equals("papel") && escolhaApp.equals("tessoura")) {
            textResultado.setText("Você perdeu!");
        } else {
            textResultado.setText("Empate!");
        }
    }

}