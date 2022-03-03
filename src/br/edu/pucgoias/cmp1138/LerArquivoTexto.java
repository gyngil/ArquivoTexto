package br.edu.pucgoias.cmp1138;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoTexto {

    public static void main(String[] args) {
        String nome = "/Users/gilcimar/IdeaProjects/ArquivoTexto/PessoaJuridica.csv";

        try {
            //leitor do arquivo texto
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            //Le a primeira linha do arquivo (cabeçalho do arquivo)
            String linha = lerArq.readLine();
            // de repetição atingir o final do arquivo texto

            while (linha != null) {
                //imprime a linha lida
                System.out.printf("%s\n", linha);

                //le da segunda linha em diante
                linha = lerArq.readLine();
            }

            //fecha o arquivo texto
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura/fedhamento do arquivo: %s.\n", e.getMessage());
        }

    }
}
