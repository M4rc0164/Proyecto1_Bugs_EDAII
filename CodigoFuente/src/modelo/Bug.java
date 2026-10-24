package modelo;

public class Bug {
    private String id;
    private String titulo;
    private int prioridad;
    private int nivelSeguridad;
    private String equipoEncargado;
    private String categoria;
    private String estado;
    private String fechaReporte;

    /*
     * se incializa el modulo para la condensacion como final,
     * así ahorrandonos el uso de pow con cada bug (10^9+7)
     */
    private static final long modulo = 100000007L;

    /*
     * Estas constantes serán utilizadas en el almacen
     * 
     * 
     * es el inverso del
     * número áureo escalado al espacio de un int -> 2^32
     * private static final long inversoAurea = 2654435769L;
     * 
     * Tamaño del contenedor en almacen
     * private static final int contenedor = 1024;
     */

    public Bug(String titulo, int prioridad, int nivelSeguridad, String equipoEncargado, String categoria,
            String estado, String fechaReporte) {
        this.id = this.generarID();
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.nivelSeguridad = nivelSeguridad;
        this.equipoEncargado = equipoEncargado;
        this.categoria = categoria;
        this.estado = estado;
        this.fechaReporte = fechaReporte;
    }

    public Bug(String id, String titulo, int prioridad, int nivelSeguridad, String equipoEncargado, String categoria,
            String estado, String fechaReporte) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.nivelSeguridad = nivelSeguridad;
        this.equipoEncargado = equipoEncargado;
        this.categoria = categoria;
        this.estado = estado;
        this.fechaReporte = fechaReporte;
    }

    public int condensacion(String titulo, String fechaReporte) {
        String captura = titulo + " " + fechaReporte;
        long h = 0L; // Se usa long para evitar desbordamientos
        for (int i = 0; i < captura.length(); i++) {
            h = (h * 31 + captura.charAt(i)) % (modulo);
        }
        return (int) h; // se castea pasando de long a entero
    }

    public String generarID() {
        int k = this.condensacion(this.getTitulo(), this.getFechaReporte());
        String id = Integer.toString(k);
        return ("BUG-" + id);
    }

    /*
     * public String generarID() { ---> Este método será pasado al almacen de bugs
     * cuando este sea creado
     * int k = this.condensacion(this.getTitulo(), this.getFechaReporte());
     * long producto = k * inversoAurea;
     * int enteroDesplazado = (int) ((producto & 0xFFFFFFFFL) >>> 22); //Se usa
     * 0xFFFFFFFFL para descartar los otros 32 bits de los 64 de un long
     * String id = Integer.toString(enteroDesplazado);
     * return ("BUG-"+id);
     * }
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getEquipoEncargado() {
        return equipoEncargado;
    }

    public void setEquipoEncargado(String equipoEncargado) {
        this.equipoEncargado = equipoEncargado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

}