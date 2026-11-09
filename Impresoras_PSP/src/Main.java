/**
 * Lanza tres impresoras que trabajan en paralelo, cada una en su hilo.
 */
public class Main {

    public static void main(String[] args) {
        // Creamos las tres tareas
        Impresora impresoraA = new Impresora("Impresora A", 3);
        Impresora impresoraB = new Impresora("Impresora B", 5);
        Impresora impresoraC = new Impresora("Impresora C", 4);

        // Asociamos cada tarea a un hilo
        Thread hiloA = new Thread(impresoraA);
        Thread hiloB = new Thread(impresoraB);
        Thread hiloC = new Thread(impresoraC);

        // Iniciamos los tres hilos. Los mensajes saldrán intercalados.
        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}