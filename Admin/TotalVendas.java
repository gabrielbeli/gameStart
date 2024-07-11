package Admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;

public class TotalVendas {

    // 2. Total de Vendas: Imprima quantas vendas foram executadas e o seu valor total.
    public static void totalVendas(String caminho) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(caminho));

        String linha = fileScanner.nextLine();

        double total = 0, quantidadeVendida, precoUnitario;

        while (fileScanner.hasNextLine()) {
            linha = fileScanner.nextLine();
            String[] itensLinha = linha.split(";");

            precoUnitario = Double.parseDouble(itensLinha[5]);

            total += (precoUnitario);
        }

        System.out.println("Total: " + total + " €");
    }
}
