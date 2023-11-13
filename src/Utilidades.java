import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Utilidades {
    public static String[] obtenerDatos(char separador, String cadenaSeparar, int numeroDatos){
        String[] listaDatos = new String[numeroDatos];
        int indiceDisponible = 0;
        String stringAux = "";
        for(int contador = 0; contador < cadenaSeparar.length(); contador++){
            if(cadenaSeparar.charAt(contador) == separador){
                listaDatos[indiceDisponible] = stringAux;
                indiceDisponible++;
                stringAux = "";
            }
            else{
                stringAux += Character.toString(cadenaSeparar.charAt(contador));
            }
        }
        return listaDatos;
    }

    public static int contarSeparador(char separador, String cadena){
        int numeroSeparador = 0;
        for(int contador = 0; contador < cadena.length(); contador++){
            if(cadena.charAt(contador) == separador){
                numeroSeparador++;
            }
        }
        return numeroSeparador;
    }

    public static int contarLineasArchivo(File archivo){
        int contador = 0;
        try {
            Scanner lectura = new Scanner(archivo);
            while(lectura.hasNext()){
                contador++;
                lectura.nextLine();
            }
        }
        catch(IOException excepcion){

        }
        return contador;
    }

}
