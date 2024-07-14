import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static BaseFuncoes.Login.login;

public class Start {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println();
        imprimirAquivo("Ficheiros/Header.txt");

        //função para iniciar o programa
        login();
    }

    public static String caminhosArquivos(int numeroFicheiro) {

        switch (numeroFicheiro) {
            case 1:
                return "Ficheiros/GameStart_Vendas.csv";
            case 2:
                return "Ficheiros/GameStart_Admins.csv";
            case 3:
                return "Ficheiros/GameStart_Categorias.csv";
            case 4:
                return "Ficheiros/GameStart_Clientes.csv";
            case 5:
                return "Ficheiros/GameStart_Copyright.txt";
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        return "caminho não definido";
    }

}

