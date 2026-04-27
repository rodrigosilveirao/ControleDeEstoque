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
            System.out.println("7 - Buscar produto por nome");
            System.out.println("8 - Relatorio de estoque baixo");
            System.out.println("9 - Sair");

            int opcao = 0;
            try {
                opcao = s.nextInt();
                s.nextLine();

            } catch (Exception e) {
                System.out.println("❌ Erro: Por favor, digite apenas números!");
                s.nextLine();
                continue;
            }


            switch (opcao){
                case 1:
                    System.out.println(" Produto comum [1] ou Produto eletronico [2]");
                try {
                    int escolha = s.nextInt();
                    s.nextLine();
                    if (escolha == 1 ){
                        System.out.println("Nome: ");
                        String nome = s.nextLine() ;

                        System.out.println("Quantidade: ");
                        int quantidade = s.nextInt();

                        System.out.println("Preco: ");
                        double preco = s.nextDouble();

                        boolean deuCerto = estoque.adicionarProduto(new Produto(nome,quantidade,preco));
                        if (deuCerto) {
                            System.out.println("✅ Produto cadastrado com sucesso!");
                        } else {
                            System.out.println("❌ Erro: O produto já existe no estoque.");
                        }
                    } else {
                        System.out.println("Nome: ");
                        String nome = s.nextLine() ;

                        System.out.println("Quantidade: ");
                        int quantidade = s.nextInt();

                        System.out.println("Preco: ");
                        double preco = s.nextDouble();

                        System.out.println("Meses de garantia");
                        int garantia = s.nextInt();

                        boolean deuCerto = estoque.adicionarProduto(new Eletronico(nome,quantidade,preco,garantia));
                        if (deuCerto) {
                            System.out.println("✅ Produto cadastrado com sucesso!");
                        } else {
                            System.out.println("❌ Erro: O produto já existe no estoque.");
                        }
                    }

                } catch (Exception e){
                    System.out.println("❌ Erro: Quantidade e preço precisam ser números!");
                    s.nextLine();
                }
                    estoque.salvarAlteracoes();

                    break;



                case 2:
                    System.out.println("----- Produtos: ------ \n");
                estoque.listarProdutos();
                break;

                case 3:
                    System.out.println("----- Digite o nome do produto para remover: ------ \n");
                String nomeRemover = s.nextLine();
                estoque.removerProduto(nomeRemover);
                    estoque.salvarAlteracoes();
                break;


                case 4:
                    System.out.println(" Digite o produto para alterar quantidade: ");
                    String nomeAlterar = s.nextLine();
                    try {
                        Produto produtoEncontrado = estoque.listarProdutos(nomeAlterar);

                        if (produtoEncontrado != null) {
                            System.out.println("Digite a quantidade que deseja alterar: ");
                            int qtd = s.nextInt();
                            s.nextLine();

                            produtoEncontrado.adicionarEstoque(qtd);
                            estoque.salvarAlteracoes();

                        } else {
                            System.out.println("Sem produto no estoque. ");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Erro grave");
                        s.nextLine();
                    }
                    break;

                case 5:
                    System.out.println(" Digite o produto para diminuir quantidade: ");
                    String nomeDiminuir = s.nextLine();
                    Produto produtoParaDiminuir= estoque.listarProdutos(nomeDiminuir);

                    if (produtoParaDiminuir != null) {
                      try {
                          System.out.println("Digite a quantidade que deseja alterar: ");
                          int qtd = s.nextInt();
                          s.nextLine();

                          boolean conseguiu = produtoParaDiminuir.removerEstoque(qtd);
                          if (conseguiu) {
                              estoque.salvarAlteracoes();
                              System.out.println("✅ Atualizado com sucesso.");
                          } else {
                              System.out.println("❌ Erro: Sem produtos suficientes para diminuir. Voce só tem " + produtoParaDiminuir.getQuantidade() + " unidades.");
                          }
                      } catch (Exception e) {
                          System.out.println("❌ Erro: Digite apenas números válidos!");
                          s.nextLine();
                      }

                    } else {
                        System.out.println("Sem produto no estoque. ");
                    }
                    break;

                case 6:
                    System.out.println("------- Digite o produto a ser alterado o preco ------");
                    String precoAlterar = s.nextLine();
                    try {
                        Produto produtoPreco = estoque.listarProdutos(precoAlterar);

                        if (produtoPreco != null) {
                            System.out.println("Digite o novo valor: ");
                            double precoNovo = s.nextDouble();
                            s.nextLine();

                            produtoPreco.alterarPreco(precoNovo);
                            estoque.salvarAlteracoes();
                        } else {
                            System.out.println("Sem produto! ");
                        }
                    } catch (Exception e) {
                        System.out.println("❌ Erro");
                        s.nextLine();
                    }
                    break;

                case 7:
                    System.out.println(" --- Digite o produto desejado ou a palavra que contem nele: ---");
                    String palavra = s.nextLine();
                    estoque.buscarProdutoPorNome(palavra);

                    break;

                case 8:
                    estoque.relatorioEstoqueBaixo();
                    break;

                case 9:
                    System.out.println("-- Saindo --");
                    System.exit(0);

                default:
                    System.out.println("Comando invalido!");
                    break;
            }
            }
        }
}