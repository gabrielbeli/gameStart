import java.io.FileNotFoundException;
import java.util.Scanner;

import static BaseFuncoes.ImprimirArquivo.imprimirAquivo;
import static BaseFuncoes.Login.login;

public class start {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println();
        imprimirAquivo("Ficheiros/Header.txt");

        login();
    }

}

