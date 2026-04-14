import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();
    private EstoqueRepository repository = new EstoqueRepository();

    public void adicionarProduto(Produto novo){
        for (Produto p : produtos){
            if (p.getNome().equalsIgnoreCase(novo.getNome())){
                return;
            }
        }
        produtos.add(novo);
    }

    public void listarProdutos(){
        for(Produto p : produtos){
            System.out.println(p);
        }
    }

    public Produto listarProdutos(String nome){
        for(Produto p : produtos){
            if (p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }

    public void removerProduto(String nome) {
        Produto produtoEncontrado = listarProdutos(nome);

        if (produtoEncontrado != null) {
            produtos.remove(produtoEncontrado);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Erro: Produto não encontrado no estoque.");
        }
    }

}



