
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try {

            ProcessBuilder pb = new ProcessBuilder("ping", "-c", "4", "localhost");
            Process proceso = pb.start();

            ProcessHandle ph = proceso.toHandle();

            System.out.println("INFORMACION DEL PROCESO");
            System.out.println("Esta vivo: " + ph.isAlive());
            System.out.println("PID: " + ph.pid());
            System.out.println("Comando: " + ph.info().command().orElse("No disponible"));

            System.out.print("Argumentos: ");

            if (ph.info().arguments().isPresent()) {

                String[] argumentos = ph.info().arguments().get();

                for (int i = 0; i < argumentos.length; i++) {
                    System.out.print(argumentos[i] + " ");
                }

                System.out.println();

            } else {
                System.out.println("No disponibles");
            }

            System.out.println("Usuario: " + ph.info().user().orElse("No disponible"));

            System.out.println("RESULTADO DEL PING");

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            int resultado = proceso.waitFor();

            System.out.println("RESULTADO FINAL");
            System.out.println("Codigo de salida: " + resultado);
            System.out.println("Esta vivo: " + ph.isAlive());

        } catch (IOException e) {

            System.out.println("Error al ejecutar el proceso.");

        } catch (InterruptedException e) {

            System.out.println("El proceso ha sido interrumpido.");
            Thread.currentThread().interrupt();

        }
    }
}
