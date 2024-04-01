
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Sim {

    protected int idSim;
    protected String nombre;
    protected String primerApellido;
    protected String segundoApeliido;
    protected String genero;
    protected Boolean esMayorDeEdad = Boolean.TRUE;
    protected GregorianCalendar fechaNacimiento;
    protected int sueldo;
    protected String estudios;
    protected String trabajo;
    protected String ciudad;
    protected ArrayList estadoSim;
    protected int hambre = 50;
    protected int vejiga = 50;
    protected int energia = 70;
    protected int diversion = 50;
    protected int interaccionSocial = 50;
    protected int higiene = 100;

    protected static int contSims = 0;

    public Sim() {
        this.idSim = contSims;
        contSims++;
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApeliido = "";
        this.fechaNacimiento = new GregorianCalendar();
        this.hambre = 50;
        this.vejiga = 50;
        this.energia = 50;
        this.diversion = 50;
        this.interaccionSocial = 50;
        this.higiene = 50;
        this.sueldo = 2000;
    }

    public Sim(String nombre, String primerApellido, String segundoApeliido, String genero, GregorianCalendar fechaNacimiento) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApeliido = segundoApeliido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        contSims++;
    }

    public int getIdSim() {
        return this.idSim;
    }

    public void setidSim(int idSim) {
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

    public static int getContSims() {
        return contSims;
    }

    public static void setContPersonas(int contSims) {
        Sim.contSims = contSims;
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

    public void setEstadoSim(ArrayList estado) {
        this.estadoSim = estado;
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

    public void irAlLavabo() {
        System.out.println("El sim " + this.nombre + " va al lavabo");
        this.vejiga += 50;
    }

    public void comer() {
        System.out.println("El sim " + this.nombre + " esta comiendo");
        this.hambre -= 50;
    }

    public void hacerFooting() {
        System.out.println("El sim " + this.nombre + " se va a hacer footing");
        energia -= 25;
    }

    public void echarseSiesta() {
        System.out.println("El sim " + this.nombre + " se esta echando una siesta... zzzzzzzz");
        energia += 25;
    }
    
    public void dormir() {
        System.out.println("El sim " + this.nombre + " se ha ido a dormir...");
        this.energia += (this.energia + (100 - this.energia));
    }

    

    public void darseUnaDucha() {
        System.out.println("El sim " + this.nombre + " se esta duchando LALALALALALALALALALA");
        this.higiene += (this.higiene + (100 - this.higiene));
    }

    public String mostrarNecesidades() {
        return "\nHambre: " + this.hambre
                + "\nVejiga: " + this.vejiga
                + "\nEnergia: " + this.energia
                + "\nDiversion: " + this.diversion
                + "\nInteraccion social: " + this.interaccionSocial
                + "\nHigiene: " + this.higiene;
        
    }

    @Override
    public String toString() {
        return "\nID: " + this.idSim
                + "\nGenero: " + this.genero
                + "\nNombre: " + this.nombre
                + "\nPrimer apellido: " + this.primerApellido
                + "\nSegundo apellido: " + this.segundoApeliido
                + "\nEdad: " + this.fechaNacimiento
                + "\nTrabajo: " + this.trabajo;
    }

}