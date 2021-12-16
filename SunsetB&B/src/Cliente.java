public class Cliente{
  private String rut;
  private String nombre;
  private String correo;
  
  public Cliente (String rut, String nombre,String correo){
    this.rut = rut;
    this.nombre = nombre;
    this.correo = correo;
  }

  public String getRut(){
    return this.rut;
  }
  public String getNombre(){
    return this.nombre;
  }
  public String getCorreo(){
    return this.correo;
  }

  

}