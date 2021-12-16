import java.util.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<Apartment> l_apartment = new ArrayList<Apartment>();
        ArrayList<Cliente> l_cliente = new ArrayList<Cliente>();
        ArrayList<Propietario> l_propietario = new ArrayList<Propietario>();
        ArrayList<Reserva> l_reserva = new ArrayList<Reserva>();
        
        PublicarApartamento(l_apartment);
    }

    public void PublicarApartamento(Apartment lista){
      Scanner s = new Scanner(System.in);
      System.out.println("Ingrese el tipo de apartamento B&B/CasaVacaciones: ");
      String tipo = s.nextLine();
      System.out.println("Ingrese el nombre del apartamento: ");
      String nombre = s.nextLine();
      System.out.println("Ingrese numero de baños del apartamento: ");
      int num_bannio = s.nextInt();
      System.out.println("Ingrese el numero de habitaciones del apartamento: ");
      int num_hab = s.nextInt();
      System.out.println("Ingrese la ciudad del apartamento: ");
      String ciudad = s.nextLine();
      System.out.println("Ingrese la direccion del apartamento: ");
      String direccion = s.nextLine();
      System.out.println("Ingrese el precio del apartamento: ");
      int precio = s.nextInt();
      
      Apartment apartamento = new Apartment(tipo, nombre, num_bannio, num_hab , direccion, ciudad, precio);
      
      while (true){
        System.out.println("Describir lugar: ");
        System.out.println("1) Ingresar lugar ");
        System.out.println("2) Salir: ");
        
        int opcion = s.nextInt();
        if(opcion == 1){
          apartamento.l_lugar.add(DescribirLugar());
        }
        if(opcion == 2){
          break;
        }

      }
    }
    
    public void Reservar(Apartment l_apartment){
        System.out.println("Departamentos disponibles ");
        Scanner s = new Scanner(System.in);
        //sacar apartamentos
        for (int i = 0; i < l_apartment.length; i++){
          Apartment ap= l_apartment[i];

          //sacar lista estadia
        
        }        

    }
    public void RecibirReserva(Reserva l_reserva){
      for(int i = 0; i < l_reserva.size(); i++) {   
        System.out.print(l_reserva.get(i));
        
      }       

    }

    public Lugar DescribirLugar(){
        Scanner s = new Scanner(System.in);
        String nombreLugar= s.nextLine();
        System.out.println("Ingrese nombre del Lugar: ");
        String descripcion= s.nextLine();
        System.out.println("Ingrese descripcion del Lugar: ");
        Lugar lugar = new Lugar(nombreLugar,descripcion);
        return lugar;
        
    }

    public Lugar DescribirSuministros(){
        Scanner s = new Scanner(System.in);
        String nombreLugar= s.nextLine();
        System.out.println("Ingrese nombre del Lugar: ");
        String descripcion= s.nextLine();
        System.out.println("Ingrese descripcion del Lugar: ");
        Lugar lugar = new Lugar(nombreLugar,descripcion);
        return lugar;
        
    }

}



