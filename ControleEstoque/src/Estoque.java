import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();
    private EstoqueRepository repository = new EstoqueRepository();

    public void relatorioEstoqueBaixo(){
        System.out.println("---- Relatorio de estoque baixo: ---- Menores que 2 no estoque");
        boolean temProdutoAcabando = false;

        for (Produto p : produtos){
            if (p.getQuantidade() <= 2){
                System.out.println(p.getNome() + " esta acabando com : " + p.getQuantidade() + " produtos.");
                temProdutoAcabando = true;
            }
        }
        if (temProdutoAcabando == false) {
            System.out.println("✅ Tudo tranquilo! Nenhum produto acabando.");
        }
    }

    public void buscarProdutoPorNome(String palavraChave){
        boolean encontrouAlgum = false;
        System.out.println("------ Resultado da busca por: " + palavraChave + " ------");
        for (Produto p : produtos){
            if (p.getNome().toLowerCase().contains(palavraChave.toLowerCase())){
                System.out.println(p.toString());
                encontrouAlgum = true;
            }
        }
        if (encontrouAlgum == false){
            System.out.println("Nenhum produto encontrado!");
        }
    }


    public void salvarAlteracoes (){
        repository.salvar(produtos);
    }


    public Estoque() {
        this.produtos = repository.carregar();
    }

    public boolean adicionarProduto(Produto novo){
        for (Produto p : produtos){
            if (p.getNome().equalsIgnoreCase(novo.getNome())){
                return false;
            }
        }

        produtos.add(novo);
        repository.salvar(produtos);
        return true;
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



