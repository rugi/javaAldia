public class CompactHeaderDemo {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        long before = rt.totalMemory() - rt.freeMemory();

        Cliente[] clientes = new Cliente[10_000_000];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(i, i * 10L);
        }

        long after = rt.totalMemory() - rt.freeMemory();

        System.out.printf("Memoria usada: %d MB%n", (after - before) / (1024 * 1024));
    }

    static class Cliente {
        int id;
        long saldo;

        Cliente(int id, long saldo) {
            this.id = id;
            this.saldo = saldo;
        }
    }
}
