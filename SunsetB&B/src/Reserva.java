import java.util.Date;
public class Reserva {
  private Estadia estadia;
  private Cliente cliente;
  private Date fecha_entrada;
  private Date fecha_salida;
  private boolean aceptado ;

  //fecha string debe ser por ej "01/01/2021"
  public Reserva (Estadia estadia, Cliente cliente, Date fecha_entrada, Date fecha_salida){
    this.estadia = estadia;
    this.cliente = cliente;
    this.fecha_entrada = fecha_entrada;
    this.fecha_salida = fecha_salida;
    this.aceptado = false;
  }
  public void setAceptacion(){
    this.aceptado = true;
  }

  public boolean getAceptacion(){
    return this.aceptado;
  }

  public Date getFecha_entrada(){
    return this.fecha_entrada;
  }
  public Date getFecha_salida(){
    return this.fecha_salida;
  }

}