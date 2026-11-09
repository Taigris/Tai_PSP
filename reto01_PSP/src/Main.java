import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        String sistema = System.getProperty("os.name").toLowerCase();

        String comando;
        String directorio;

        if (sistema.contains("windows")) {
            comando = "cmd /c dir";
            directorio = "c:/temp";
        } else {
            comando = "sh -c ls";
            directorio = "/tmp";
        }

        try {

            ProcessBuilder constructor = new ProcessBuilder(comando.split("\\s"));


            constructor.directory(new File(directorio));


            constructor.inheritIO();


            Process proceso = constructor.start();
            proceso.waitFor();

        } catch (IOException e) {
            System.out.println("Error al ejecutar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El proceso se ha interrumpido.");
        }
    }
}