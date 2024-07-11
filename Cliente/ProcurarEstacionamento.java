package Cliente;

public class ProcurarEstacionamento {

    public static void estacionamento() {

        int limite = 121;

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
