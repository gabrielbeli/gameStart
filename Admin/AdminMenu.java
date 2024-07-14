package Admin;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static Admin.JogoMaisCaro.jogoMaisCaro;
import static Admin.MelhorCategoria.categoriaMaisLucrativa;
import static Admin.MelhoresClientes.melhorCliente;
import static Admin.PesquisaCliente.obterIdCliente;
import static Admin.PesquisaCliente.pesquisaCliente;
import static Admin.Relatorio.relatorio;
import static Admin.Vendas.MenuVendas.vendasMenu;

public class AdminMenu {

    /**
     * Método: Gera o menu principal do user admin, onde tem acesso a ações
     * @return 1-menu vendas, 2-menu relatorios...
     * @throws FileNotFoundException Excessão quando não se encontra o caminho especificado
     */
    public static void adminMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu Admin:");
            System.out.println("1.Menu Vendas");
            System.out.println("2.Menu Relatorios");
            System.out.println("3.Pesquisa Cliente");
            System.out.println("4.Melhor Cliente");
            System.out.println("5.Melhor Categoria");
            System.out.println("6.Jogo Mais Caro");
            System.out.println("7.Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // função para acessar relatorios
                    vendasMenu();
                    break;
                case 2:
                    // função para acessar relatorios
                    relatorio();
                    break;
                case 3:
                    // função para encontrar cliente
                    pesquisaCliente("Ficheiros/GameStart_Clientes.csv",obterIdCliente());
                    break;
                case 4:
                    // função para melhor(es) cliente(s)
                    melhorCliente("Ficheiros/GameStart_Clientes.csv", "Ficheiros/GameStart_Vendas.csv");
                    break;
                case 5:
                    // função para melhor categoria
                    categoriaMaisLucrativa("Ficheiros/GameStart_Vendas.csv", "Ficheiros/GameStart_Categorias.csv");
                    break;
                case 6:
                    // função para consultar jogo mais caro
                    jogoMaisCaro("Ficheiros/GameStart_Vendas.csv","Ficheiros/GameStart_Clientes.csv");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }
}


