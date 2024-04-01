
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Mujer extends Sim {
    
    protected Boolean embarazada;
    
    public Mujer(String nombre, String primerApellido,String segundoApeliido,String genero, GregorianCalendar fechaNacimiento) {
        super(nombre, primerApellido, segundoApeliido, genero, fechaNacimiento);
    }

    public Boolean getEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(Boolean embarazada) {
        this.embarazada = embarazada;
    }

    public int getIdSim() {
        return idSim;
    }

    public void setIdSim(int idSim) {
        this.idSim = idSim;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApeliido() {
        return segundoApeliido;
    }

    public void setSegundoApeliido(String segundoApeliido) {
        this.segundoApeliido = segundoApeliido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Boolean getEsMayorDeEdad() {
        return esMayorDeEdad;
    }

    public void setEsMayorDeEdad(Boolean esMayorDeEdad) {
        this.esMayorDeEdad = esMayorDeEdad;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList getEstadoSim() {
        return estadoSim;
    }

    public void setEstadoSim(ArrayList estadoSim) {
        this.estadoSim = estadoSim;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getVejiga() {
        return vejiga;
    }

    public void setVejiga(int vejiga) {
        this.vejiga = vejiga;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getDiversion() {
        return diversion;
    }

    public void setDiversion(int diversion) {
        this.diversion = diversion;
    }

    public int getInteraccionSocial() {
        return interaccionSocial;
    }

    public void setInteraccionSocial(int interaccionSocial) {
        this.interaccionSocial = interaccionSocial;
    }

    public int getHigiene() {
        return higiene;
    }

    public void setHigiene(int higiene) {
        this.higiene = higiene;
    }

    public static int getContSims() {
        return contSims;
    }

    public static void setContSims(int contSims) {
        Sim.contSims = contSims;
    }
    
    
    
}
