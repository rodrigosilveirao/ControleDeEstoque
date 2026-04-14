import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EstoqueRepository {
    private final String NOME_ARQUIVO = "estoque_propickup.txt";

    public boolean salvar (ArrayList<Produto> listaDeProdutos){

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(NOME_ARQUIVO))){
            for (Produto p : listaDeProdutos){
                String linha = p.getNome() + "|" + p.getQuantidade() + "|" + p.getPreco();
                escritor.write(linha);
                escritor.newLine();
            }
            return true;
        }catch (IOException erro) {
            System.out.println("❌ Erro técnico ao acessar o disco: " + erro.getMessage());
            return false;
        }
    }







}
