package Admin;

import java.io.FileNotFoundException;

import static Admin.PesquisaCliente.pesquisaCliente;
import static BaseFuncoes.GerarMatriz.gerarMatriz;

public class MelhoresClientes {

    public static void melhorCliente(String caminhoClientes, String caminhoVendas) throws FileNotFoundException {

        String[][] matrizClientes = gerarMatriz(caminhoClientes);
        String[][] matrizVendas = gerarMatriz(caminhoVendas);

        int idClienteComMaisGastos = -1;
        double maiorValorCompras = 0.0;


        for (int X = 1; X < matrizClientes.length; X++) {

            int idCliente = Integer.parseInt(matrizClientes[X][0]);
            double totalCompras = calcularTotalComprasCliente(idCliente, matrizVendas);

            if (totalCompras > maiorValorCompras) {
                maiorValorCompras = totalCompras;
                idClienteComMaisGastos = idCliente;
            }
        }

        System.out.println("\n Melhor Cliente \n");
        pesquisaCliente(caminhoClientes, idClienteComMaisGastos);


        System.out.println("Jogos comprados:");

        for (int X = 1; X < matrizVendas.length; X++) {

            int idCliente = Integer.parseInt(matrizVendas[X][1]);

            if (idCliente == idClienteComMaisGastos) {
                System.out.println("- " + matrizVendas[X][4]);
            }
        }
    }

    public static double calcularTotalComprasCliente(int idCliente, String[][] matrizVendas) {

        double totalCompras = 0.0;

        for (int X = 1; X < matrizVendas.length; X++) {

            int id = Integer.parseInt(matrizVendas[X][1]);

            if (id == idCliente) {
                double valorVenda = Double.parseDouble(matrizVendas[X][5]);
                totalCompras += valorVenda;
            }
        }
        return totalCompras;
    }

}
