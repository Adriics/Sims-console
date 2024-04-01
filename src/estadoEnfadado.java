
public class estadoEnfadado implements estadoSim {

    protected int contEstado;

    public void mostrarEstado() {
        System.out.println("El sim esta enfadado");
    }

    public int getContEstado() {
        return contEstado;
    }

    public void setContEstado(int contEstado) {
        this.contEstado = contEstado;
    }
    
    

}
