import java.util.Date;
public class Reserva {
  private Estadia estadia;
  private Cliente cliente;
  private Date fecha;
  private boolean aceptado = false;

  //fecha string debe ser por ej "01/01/2021"
  public Reserva (Estadia estadia, Cliente cliente, Date fecha){
    this.estadia = estadia;
    this.cliente = cliente;
    Date fecha = new Date(fecha);
  }
  public void setAceptacion(){
    this.aceptado = true;
  }

}