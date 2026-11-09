public class Impresora implements Runnable {

    private final String nombre;
    private final int totalPaginas;


    public Impresora(String nombre, int totalPaginas) {
        this.nombre = nombre;
        this.totalPaginas = totalPaginas;
    }


    @Override
    public void run() {
        for (int pagina = 1; pagina <= totalPaginas; pagina++) {
            System.out.println(nombre + ": página " + pagina + " de " + totalPaginas);

            try {
                // Simulamos que imprimir una página tarda 1 segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Restablecemos la interrupción y terminamos la tarea
                Thread.currentThread().interrupt();
                System.out.println(nombre + ": impresión interrumpida");
                return;
            }
        }

        System.out.println(nombre + ": impresión finalizada");
    }
}