public class Propietario {
  private String rut;
  private String nombre;
  private Apartment[] ap;
  private int cant_prop = 0;
  public Propietario(String rut, String nombre){
    this.rut = rut;
    this.nombre = nombre;
  }
  public String getRut(){
    return this.rut;
  }
  public String getNombre(){
    return this.nombre;
  }
  public setApartment (Apartment a ){
    ap[cant_prop] = a;
    this.cant_prop += 1;
  }

}