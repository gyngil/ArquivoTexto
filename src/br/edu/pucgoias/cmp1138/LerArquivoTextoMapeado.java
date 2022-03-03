package br.edu.pucgoias.cmp1138;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoTextoMapeado {

    public static final String NOME_ARQUIVO = "/Users/gilcimar/IdeaProjects/ArquivoTexto/PessoaJuridica.csv";

     public static void main(String[] args) {
        List<PessoaJuridica> listaPessoaJuridica = new LerArquivoTextoMapeado().obterPessoaJuridica(NOME_ARQUIVO);

        for (PessoaJuridica pessoaJuridica:listaPessoaJuridica) {
            System.out.println(pessoaJuridica.getId() + " " + pessoaJuridica.getRazaoSocial());
        }

      }

    /**
     * metodo que obtem a lista de pessoas juridicas do arquivo texto
     * @param arquivo
     * @return
     */
    private List<PessoaJuridica> obterPessoaJuridica(String arquivo){

        List<PessoaJuridica> listaPessoaJuridica = new ArrayList<PessoaJuridica>();

        try {

            PessoaJuridica pessoaJuridica;

            //leitor do arquivo texto
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            //Le a primeira linha do arquivo (cabeçalho do arquivo)
            String linha = lerArq.readLine();
            // de repetição atingir o final do arquivo texto

            while (linha != null) {

                //mapeia a linha na pessoa juridica
                pessoaJuridica = mapearPessoaJuridica(linha);
                //adiciona a pessoa juridica mapeada na lista de pessoas juridicas
                listaPessoaJuridica.add(pessoaJuridica);


                //le da segunda linha em diante
                linha = lerArq.readLine();
            }

            //fecha o arquivo texto
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura/fedhamento do arquivo: %s.\n", e.getMessage());
        }

        return listaPessoaJuridica;

    }

    /**
     * metodo que mapeia uma linha do arquivo no objeto PessoaJuridica
     * @param linha
     * @return
     */
    private PessoaJuridica mapearPessoaJuridica(String linha){
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        try {
            String[] campos;
            if (linha != null) {
                //divide os campos separados por ";"
                campos = linha.split(";");
                if (campos != null && campos.length > 0) {
                    //preenche os campos da linha na pessoa juridica
                    pessoaJuridica.setId(Integer.parseInt(campos[0]));
                    pessoaJuridica.setCnpj(campos[1]);
                    pessoaJuridica.setRazaoSocial(campos[2]);
                    pessoaJuridica.setCidade(campos[3]);
                    pessoaJuridica.setEstado(campos[4]);
                    pessoaJuridica.setTipoPagamento(campos[5]);
                    pessoaJuridica.setStatus(campos[6]);
                }
            }
        }
        catch(Exception e){
            System.err.printf("Erro no mapeamento dos campos de Pessoa Juridica: %s.\n", e.getMessage());
        }

        return pessoaJuridica;

    }

}
