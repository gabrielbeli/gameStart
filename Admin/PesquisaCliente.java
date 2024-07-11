package Admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PesquisaCliente {

    //4. Pesquisa de Cliente: Dado um idCliente, imprima todas as informações associadas a esse cliente
    // (nome, contacto, email), de forma estruturada (“bonita”).

    public static void pesquisaCliente(String caminho) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File(caminho));
        Scanner scannerCol = new Scanner(new File(caminho));

        int contadorLinhas=0, contadorCol=0;

        while (fileScanner.hasNextLine()){
            contadorLinhas++;
            fileScanner.nextLine();
        }

        while(scannerCol.hasNext()){
            contadorCol++;
            scannerCol.next();
        }

        String[][] matriz = new String[contadorLinhas][contadorCol];

        for (int X = 0; X < matriz.length; X++) {
            for (int Y = 0; Y <  matriz[0].length; Y++) {
                System.out.print(matriz[X][Y] + " ");
            }
            System.out.println();
        }

    }
}
