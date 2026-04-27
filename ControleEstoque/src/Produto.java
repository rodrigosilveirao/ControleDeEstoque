public class Produto implements Persistivel {
    private String nome;
    private int quantidade;
    private double preco;


    @Override
    public String formatarParaLinha() {
        return "COMUM|" + nome + "|" + quantidade + "|" + preco;
    }

    public void adicionarEstoque(int qtd){
        this.quantidade += qtd;
    }







    public boolean removerEstoque(int qtd){
        if (this.quantidade >= qtd){
            this.quantidade -= qtd;
            return true;
        } else {
            return false;
        }
    }







    public String toString(){
        return "Produto: " + nome +  " | Quantidade:" + quantidade +  " | Preco: " + String.format("R$%.2f", preco);
    }

    public void alterarPreco(double novoPreco){
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

    public double getPreco() {
        return preco;
    }

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome.trim();
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
