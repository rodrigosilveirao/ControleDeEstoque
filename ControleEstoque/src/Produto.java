public class Produto {
    private String nome;
    private int quantidade;
    private float preco;

    public void adicionarEstoque(int qtd){
        this.quantidade += qtd;
    }

    public void removerEstoque(int qtd){
        if (quantidade <= 0){
            System.out.println("Sem produto no momento");
        } else {
            this.quantidade -= qtd;
        }
    }

    public String toString(){
        return "Produto: " + nome +  " | Quantidade:" + quantidade + " | Preco: R$" + preco;
    }

    public void alterarPreco(float novoPreco){
        if (novoPreco > 0){
            this.preco = novoPreco;
        } else {
            System.out.println(" Preco invalido! ");
        }
    }




    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public Produto(String nome, int quantidade, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
