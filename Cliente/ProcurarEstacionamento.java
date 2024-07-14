package Cliente;

import java.io.FileNotFoundException;

public class ProcurarEstacionamento {

    /**
     * Método: Usado para verificar as vagas de estacionamento disponiveis no momento dentro de um total de 121.
     * @return imprime vagas disponiveis, sendo essas identificadas como numeros triangulares multiplos de 5.
     */
    public static void estacionamento() {

        int limite = 121;

        System.out.println("\n      As vagas disponiveis no estacionamento nesse momento: \n");

        for (int num = 1; ; num++) {
            int numeroTriangular = (num * (num + 1)) / 2;

            if (numeroTriangular > limite) {
                break;
            }
            if (numeroTriangular % 5 == 0) {

                System.out.println("      \uD83D\uDE97 vaga: " + numeroTriangular+"\n");
            }
        }
    }
}
