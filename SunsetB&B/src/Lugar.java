public class Lugar{
  private String tipoLugar;
  private String nombre;
  private String horarioEntrada;
  private String horarioSalida;
  private boolean locomocion; 
  private String tiempoLlegada;
  
  public Lugar(String tipoLugar,String nombre,String horarioEntrada, String horarioSalida,boolean locomocion, String tiempoLlegada){
    this.tipoLugar=tipoLugar;
    this.nombre=nombre;
    this.horarioEntrada=horarioEntrada;
    this.horarioSalida=horarioSalida;
    this.locomocion=locomocion;
    this.tiempoLlegada=tiempoLlegada;
  }

  public String getTipoLugar(){
    return this.tipoLugar;
  }
  public String getNombre(){
    return this.nombre;
  }
  public String getHorarioEntrada(){
    return this.horarioEntrada;
  }
  public String getHorarioSalida(){
    return this.horarioSalida;
  }
    public boolean getLocomocion(){
    return this.locomocion;
  }
  public String getTiempoLlegada(){
    return this.tiempoLlegada;
  }
}