import java.util.Calendar;
public class Reserva {
  private Estadia estadia;
  private Cliente cliente;
  private Calendar fecha_entrada;
  private Calendar fecha_salida;
  private boolean aceptado ;

 
  public Reserva (Estadia estadia, Cliente cliente, Calendar fecha_entrada, Calendar fecha_salida){
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

  public Calendar getFecha_entrada(){
    return this.fecha_entrada;
  }
  public Calendar getFecha_salida(){
    return this.fecha_salida;
  }

}