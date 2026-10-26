package algoritmos;

import modelo.Bug;

//Clase para almacenar los valores de un bug buscados por el usuario 
public class TargetAux {
    private Integer prioridad; 
    private Integer nivelSeguridad;
    private String equipoEncargado;
    private String categoria;
    private String estado;
    private String fechaReporte;

    //Cuenta la cantidad de elementos buscados
    int contadorAtributos = 0;

    //Se usa el constructor vacío

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
        contadorAtributos ++;
    }

    public void setNivelSeguridad(Integer nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
        contadorAtributos ++;
    }

    public void setEquipoEncargado(String equipoEncargado) {
        this.equipoEncargado = equipoEncargado;
        contadorAtributos ++;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
        contadorAtributos ++;
    }

    public void setEstado(String estado) {
        this.estado = estado;
        contadorAtributos ++;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
        contadorAtributos ++;
    }

    public boolean comparador(Bug bug) {
        int contador = 0;
        if(this.prioridad != null) {
            if(this.prioridad == bug.getPrioridad())
                contador ++;
        }
        if(this.nivelSeguridad != null) {
            if(this.nivelSeguridad == bug.getNivelSeguridad())
                contador ++;
        }
        if(this.equipoEncargado != null) {
            if(this.equipoEncargado.compareToIgnoreCase(bug.getEquipoEncargado()) == 0)
                contador ++;
        }
        if(this.categoria != null) {
            if(this.categoria.compareToIgnoreCase(bug.getCategoria()) == 0)
                contador ++;
        }
        if(this.estado != null) {
            if(this.estado.compareToIgnoreCase(bug.getEstado()) == 0)
                contador ++;
        }
        if(this.fechaReporte != null) {
            if(this.fechaReporte.equals(bug.getFechaReporte()))
                contador ++;
        }

        //Si ambos objetos coinciden en todos sus atributos buscados se retorna true
        if(contadorAtributos == contador) return true;
        else return false;
    }
}
