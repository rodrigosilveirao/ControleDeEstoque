public class Eletronico extends Produto{
    private int garantia;

    @Override
    public String formatarParaLinha() {
        return "ELETRONICO|" + getNome() + "|" + getQuantidade() + "|" + getPreco() + "|" + getGarantia();
    }

    public Eletronico(String nome, int quantidade, double preco, int garantia) {
        super(nome, quantidade, preco);
        this.garantia = garantia;

    }

    @Override
    public String toString() {
        return super.toString() +
                " {Garantia de " + garantia +
                " meses}";
    }

    public int getGarantia() {
        return garantia;
    }
}
