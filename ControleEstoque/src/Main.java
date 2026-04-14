import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Estoque estoque = new Estoque();


        while(true){
            System.out.println("\n1 - Cadastrar Produto");
            System.out.println("2 - Listar produto");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Adicionar produto");
            System.out.println("5 - Diminuir produto ");
            System.out.println("6 - Alterar preco");
            System.out.println("7 - Sair");

            int opcao = s.nextInt();
            s.nextLine();

            switch (opcao){
                case 1:
                System.out.println("Nome: ");
                String nome = s.nextLine() ;

                System.out.println("Quantidade: ");
                int quantidade = s.nextInt();

                System.out.println("Preco: ");
                float preco = s.nextFloat();

                estoque.adicionarProduto(new Produto(nome,quantidade,preco));

                break;

                case 2:
                    System.out.println("----- Produtos: ------ \n");
                estoque.listarProdutos();
                break;

                case 3:
                    System.out.println("----- Digite o nome do produto para remover: ------ \n");
                String nomeRemover = s.nextLine();
                estoque.removerProduto(nomeRemover);
                break;


                case 4:
                    System.out.println(" Digite o produto para alterar quantidade: ");
                    String nomeAlterar = s.nextLine();
                    Produto produtoEncontrado = estoque.listarProdutos(nomeAlterar);

                    if (produtoEncontrado != null) {
                        System.out.println("Digite a quantidade que deseja alterar: ");
                        int qtd = s.nextInt();
                        s.nextLine();

                        produtoEncontrado.adicionarEstoque(qtd);

                    } else {
                        System.out.println("Sem produto no estoque. ");
                    }
                    break;

                case 5:
                    System.out.println(" Digite o produto para diminuir quantidade: ");
                    String nomeDiminuir = s.nextLine();
                    Produto produtoParaDiminuir= estoque.listarProdutos(nomeDiminuir);

                    if (produtoParaDiminuir != null) {
                        System.out.println("Digite a quantidade que deseja alterar: ");
                        int qtd = s.nextInt();
                        s.nextLine();

                        produtoParaDiminuir.removerEstoque(qtd);

                    } else {
                        System.out.println("Sem produto no estoque. ");
                    }
                    break;

                case 6:
                    System.out.println("------- Digite o produto a ser alterado o preco ------");
                    String precoAlterar = s.nextLine();
                    Produto produtoPreco = estoque.listarProdutos(precoAlterar);

                    if (produtoPreco != null) {
                        System.out.println("Digite o novo valor: ");
                        float precoNovo = s.nextFloat();
                        s.nextLine();

                        produtoPreco.alterarPreco(precoNovo);

                    } else {
                        System.out.println("Sem produto! ");
                    }
                case 7:
                    System.out.println("-- Saindo --");
                    System.exit(0);
                default:
                    System.out.println("Comando invalido!");
                    break;
            }
            }
        }
}