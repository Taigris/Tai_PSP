import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lanza un comando con un parámetro erróneo y muestra
 * el error que genera usando getErrorStream().
 */
public class Main {

    public static void main(String[] args) {

        String sistema = System.getProperty("os.name").toLowerCase();
        String comando;

        if (sistema.contains("windows")) {
            comando = "cmd /c dir /zzz";
        } else {
            comando = "ls --zzz";
        }

        try {

            Process proceso = new ProcessBuilder(comando.split("\\s")).start();


            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getErrorStream()));

            System.out.println("Error del proceso:");
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }


            int codigo = proceso.waitFor();
            System.out.println("Código de salida: " + codigo);

        } catch (IOException e) {
            System.out.println("Error al ejecutar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El proceso ha sido interrumpido.");
        }
    }
}