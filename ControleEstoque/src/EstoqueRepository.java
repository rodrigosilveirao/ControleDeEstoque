import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository {
    private final String NOME_ARQUIVO = "estoque_propickup.txt";

    public boolean salvar (List<Produto> listaDeProdutos){

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(NOME_ARQUIVO))){

            System.out.println("📁 Arquivo salvo no Mac em: " + new java.io.File(NOME_ARQUIVO).getAbsolutePath());


            for (Produto p : listaDeProdutos){
                String linha;
                if (p instanceof Eletronico){
                    Eletronico e = (Eletronico) p;
                     linha = "ELETRONICO|" + p.getNome() + "|" + p.getQuantidade() + "|" + p.getPreco() + "|" + e.getGarantia();
                } else {
                     linha = "COMUM|" + p.getNome() + "|" + p.getQuantidade() + "|" + p.getPreco();

                }
                escritor.write(linha);
                escritor.newLine();
            }
            return true;
        }catch (IOException erro) {
            System.out.println("❌ Erro técnico ao acessar o disco: " + erro.getMessage());
            return false;
        }
    }


    public List<Produto> carregar() {
        List<Produto> produtosCarregados = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split("\\|");


                String tipo = partes[0];
                String nome = partes[1];
                int qtd = Integer.parseInt(partes[2]);
                float preco = Float.parseFloat(partes[3]);
                if (tipo.equals("ELETRONICO")) {
                    int garantia = Integer.parseInt(partes[4]);
                    produtosCarregados.add(new Eletronico(nome, qtd, preco, garantia));
                }else {
                    produtosCarregados.add(new Produto(nome, qtd, preco));
                }
            }
        } catch (IOException erro) {
            System.out.println("⚠️ Nenhum arquivo de estoque anterior encontrado. Iniciando um novo...");
        }
        return produtosCarregados;
    }
}
