package datos;

import modelo.Bug;

import java.util.Random;
import java.time.LocalDate;

public class GeneradorBugs {
    public static final int prioridadMinima = 1;
    public static final int prioridadMaxima = 3;

    public static final int nivelSeguridadMin=1;
    public static final int nivelSeguridadMax=5;

    static final LocalDate fechaMax = LocalDate.now(); // la máxima en este caso es hoy mismo
    static final int fechaMin = 2000; // lo máximo son hace 2000 días ⚞^. .^⚟
    
    public static final Random rand = new Random();

    public static Bug generarBug(){
        final String[] bucketAccion = {"Error 404", "Error desconocido", "Crasheo de la app", "Falla al cargar datos"
            ,"Fallo al renderizar", "Desconexión al servidor", "Cierre de sesión", "Fatal Error"
            , "TLE", "Wronge Answer","'No Responde'", "Información Vulnerada","Consumo excesivo de bateria"
        };
        final int nAcciones=bucketAccion.length;

        final String[] bucketComponente = {" al tratar de iniciar sesion", " en el menú","en módulo de login",
            " en pasarela de pagos", " en carrito de compras", " en tabla de clientes", " en generador de PDFs", 
            " en API de autenticación", " en panel de administración"," en la database", " en el main"};
        final int nComponentes=bucketComponente.length;

        final String[] bucketContexto = {", al cambiar a chino", ", en dispositivos móviles",", en computadoras de escritorio",
                ", en portatiles",", en televisiones ", ", en la pantalla de un refri", ", al cambiar a aleman"
                ,", al rotar la pantalla", ", activando el modo oscuro", ", activando el modo claro",", al derramar café"
                ,", al desinstalar la app"
        };
        final int nContextos = bucketContexto.length;

        final String[] bucketEquipos = {"Frontend", "Backend", "BaseDatos", "Seguridad", "DevOps", "QA","Administración",
                        "FarmaciasBenavides", "Ventas"};
        final int nEquipos = bucketEquipos.length; 

        final String[] bucketCategoria = {"interfaz", "lógica", "rendimiento", "seguridad", "persistencia", "indeterminada"};
        final int nCategorias = bucketCategoria.length; 

        final String[] bucketEstado = {"Abierto","En revisión","Cerrado","Olvidado","Ignorado","Estado: De méxico"};
        final int nEstados = bucketEstado.length; 

        int indice = rand.nextInt(nAcciones); 
        String aux1 = bucketAccion[indice];
        indice = rand.nextInt(nComponentes); 
        String aux2 = bucketComponente[indice];
        indice = rand.nextInt(nContextos); 
        String aux3 = bucketContexto[indice];

        int prioridad = rand.nextInt(prioridadMaxima)+prioridadMinima; // del 1 al 3
        int seguridad = rand.nextInt(nivelSeguridadMax)+nivelSeguridadMin; // del 1 al 5

        indice = rand.nextInt(nEquipos); 
        String equipo = bucketEquipos[indice];

        indice = rand.nextInt(nCategorias); 
        String categoria = bucketCategoria[indice];

        indice = rand.nextInt(nEstados); 
        String estado = bucketEstado[indice];

        int r = rand.nextInt(fechaMin)+1;
        LocalDate fecha = fechaMax.minusDays(r);

        Bug bug = new Bug(aux1+aux2+aux3, prioridad, seguridad,equipo ,categoria ,estado , fecha.toString());

        return bug;
    }
}
