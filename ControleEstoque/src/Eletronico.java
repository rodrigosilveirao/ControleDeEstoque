public class Eletronico extends Produto{
    private int garantia;

    public Eletronico(String nome, int quantidade, float preco, int garantia) {
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
