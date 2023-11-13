import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Database {
    private File archivo;
    private String nombreArchivo;
    private int numeroCuentas;
    Usuarios[] listaUsuarios;
    public Database(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
        try{
            if(!archivo.createNewFile()){
                setNumeroCuentas(Utilidades.contarLineasArchivo(archivo));
                this.listaUsuarios = hacerListaUsuarios(numeroCuentas, archivo);
            }
        }
        catch (IOException exception) {
        }
    }

    public void setNumeroCuentas(int numeroCuentas){
        this.numeroCuentas = numeroCuentas;
    }

    public int getNumeroCuentas(){
        return this.numeroCuentas;
    }

    public File getArchivo(){
        return this.archivo;
    }

    public Usuarios[] getListaUsuarios(){
        return listaUsuarios;
    }


    public Usuarios[] hacerListaUsuarios(int numeroCuentas, File archivo){
        Usuarios[] arregloUsuarios = new Usuarios[numeroCuentas];
        try {
            Scanner lectura = new Scanner(archivo);
            for (int contador = 0; contador < numeroCuentas; contador++) {
                String linea = lectura.nextLine();
                String[] datosUsuario = Utilidades.obtenerDatos('|', linea, Utilidades.contarSeparador('|', linea));
                arregloUsuarios[contador] = new Usuarios(datosUsuario[0], datosUsuario[1], datosUsuario[2]);
            }

        }
        catch(IOException excepcion){
        }
        return arregloUsuarios;
    }

    public void guardarUsuario(Usuarios usuarioGuardar, String nombreArchivo){
        try {
            FileWriter escribir = new FileWriter(nombreArchivo);
            escribir.append(usuarioGuardar.getLineaBaseDatos());
            escribir.close();
        }
        catch (IOException excepcion){}
    }
}
