public class estadoContento implements estadoSim {
    
    protected int contEstado;
    
    public void mostrarEstado() {
        System.out.println("El sim esta contento");
    }

    public int getContEstado() {
        return contEstado;
    }

    public void setContEstado(int contEstado) {
        this.contEstado = contEstado;
    }
    
}