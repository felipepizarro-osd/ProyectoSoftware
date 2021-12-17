import java.util.*;
public class Estadia{
  private ServicioTransporte servicio_t;
  private Reserva reserva;
  private Apartment apartment;
  private int coste;
  private String destino;
  private Calendar fecha;
  public Estadia(Apartment apartment){
    this.apartment = apartment;
  }
  public Reserva getReserva(){
    return this.reserva;
  }

  public void SetReserva(Reserva reserva){
    this.reserva = reserva;
  }
  
  public int getCoste(){
    return this.coste;
  }
}