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

    public static void PublicarApartamento(ArrayList<Apartment> lista){
      Scanner s = new Scanner(System.in);

      System.out.println("Ingrese su rut: ");
      String rut = s.nextLine();
      System.out.println("Ingrese su nombre: ");
      String nombreP = s.nextLine();
      Propietario propietario = new Propietario(rut, nombreP);

      System.out.println("Ingrese el tipo de apartamento B&B/CasaVacaciones: ");
      String tipo = s.nextLine();
      System.out.println("Ingrese el nombre del apartamento: ");
      String nombre = s.nextLine();
      System.out.println("Ingrese numero de baños del apartamento: ");
      int num_baño = s.nextInt();
      System.out.println("Ingrese el numero de habitaciones del apartamento: ");
      int num_hab = s.nextInt();
      System.out.println("Ingrese la ciudad del apartamento: ");
      String ciudad = s.nextLine();
      System.out.println("Ingrese la direccion del apartamento: ");
      String direccion = s.nextLine();
      
      Apartment apartamento = new Apartment(tipo, nombre, num_baño, num_hab , direccion, ciudad, propietario);
      
      while (true){
        System.out.println("Describir lugar: ");
        System.out.println("1) Ingresar lugar ");
        System.out.println("2) Salir ");       
        int opcion = s.nextInt();
        
        while(opcion < 1 || opcion > 2){
          System.out.println("Ingrese un numero valido!!");
          System.out.println("1) Ingresar lugar ");
          System.out.println("2) Salir ");
          opcion= s.nextInt();
        }
        if(opcion == 1){
          apartamento.getL_lugar().add(DescribirLugar());
        }
        if(opcion == 2){
          break;
        }
      }
      apartamento.setSuministro(DescribirSuministros());     
    }
    
    
    public static void Reservar(ArrayList<Apartment> l_apartment, Date fecha_entrada, Date fecha_salida,String tipo,int presupuesto, Cliente cliente,ArrayList<Reserva> l_reserva){
        //lista de apartamentos disponibles
        ArrayList<Apartment> l_apartamento_d = new ArrayList<Apartment>();
        System.out.println("Departamentos disponibles ");
        Scanner s = new Scanner(System.in);
        //saca apartamentos
        
        for (int i = 0; i < l_apartment.size(); i++){
          //por cada apartamento
          boolean desocupado = false; //se asume que está ocupado
          Apartment apartamento= l_apartment.get(i);
            //saca lista estadia
          if(apartamento.getTipo().equals(tipo)){
            //verifica que el aprtamento sea del tipo definido
            ArrayList <Estadia> lista_estadia = apartamento.getLista_Estadia();
            //sacar cada estadia
            for (int j = 0; j < lista_estadia.size(); j++){
              Estadia estadia = lista_estadia.get(j);
              //sacar reserva de la estadia
              if(estadia.getCoste() <= presupuesto){
                Reserva reserva = estadia.getReserva();
                if (reserva.getAceptacion()){ //si ha sido reservada
                  
                  Date f1 = reserva.getFecha_entrada();
                  Date f2 = reserva.getFecha_salida();


                  //-------------------------------------------------------------------------------
                  //NO VERIFIQUE QUE FUNCIONE BIEN .BEFORE AFTER, DPS LO REVISO
                  boolean permitir1 = (!(fecha_entrada.before(f1) && fecha_entrada.after(f2))); //quiero : #t si no está reservada en la fecha consultada, #f si ya está reservada en la fecha de consulta


                  boolean permitir2 = (!(fecha_salida.before(f1) && fecha_salida.after(f2))); //quiero : #t si no está reservada en la fecha consultada, #f si ya está reservada en la fecha de consulta
                  //-------------------------------------------------------------------------------
                  
                  if(permitir1 && permitir2){ //si no choca en ninguna de las fechas
                    desocupado = true;
                  }
                }
              }
            }
          }
          if (desocupado){
            System.out.println("Desocupado apartamento : "+ apartamento.getName());
            l_apartamento_d.add(apartamento);

            
          }

        }    
         //se pide apartamento que quieren
        System.out.println("Ingrese nombre apartamento a arrendar: ");
        String apartamento_d = s.nextLine(); //apartamento deseado

        for (int i = 0; i < l_apartamento_d.size(); i++){
          Apartment apartamento_analizar = l_apartamento_d.get(i);
          if (apartamento_analizar.getName().equals(apartamento_d)){ 
            
            Estadia estadia_n = new Estadia(apartamento_analizar);
            
            Reserva reserva_n = new Reserva (estadia_n, cliente, fecha_entrada, fecha_salida);
            //se agrega la reserva a su lista y se da por terminada
            l_reserva.add(reserva_n);
            System.out.println("reserva realizada ");
            
          }else{
            //pedir que reserve otra vez porque  está ocupado el apartamento o no existe
            System.out.println("reserva denegada, se reiniciará la consulta");
            Reservar(l_apartment, fecha_entrada, fecha_salida, tipo, presupuesto, cliente, l_reserva);
          }
          
        }
    }

    public static void RecibirReserva(ArrayList<Reserva> l_reserva){
      for(int i = 0; i < l_reserva.size(); i++) {   
        System.out.print(l_reserva.get(i));
        Scanner s = new  Scanner(System.in);
        String acep = s.nextLine();
        if (acep.equals('s') || acep.equals('S')){
          l_reserva.get(i).setAceptacion();
        }else if (acep.equals('n') || acep.equals('n')){
          System.out.println("Reserva rechazada ");
        }else{
          System.out.println("Respuesta no aceptada");
        }
      }
    }

    public static Lugar DescribirLugar(){
        Scanner s = new Scanner(System.in);
        String tipoLugar;
        boolean locomocion = false;
        System.out.println("Tipo de lugares: ");
        System.out.println("1) Monumentos.");
        System.out.println("2) Lugar de interés turístico.");
        System.out.println("Ingrese tipo del Lugar: ");
        int tipoLugarN= s.nextInt();
        while(tipoLugarN != 1 || tipoLugarN != 2){
          System.out.println("ERROR! Ingrese tipo del Lugar: ");
          tipoLugarN= s.nextInt();
        }
        if(tipoLugarN == 1){
          tipoLugar="Monumento";
        }
        else{
          tipoLugar="Lugar de interés turístico";
        }
        System.out.println("Ingrese nombre del Lugar: ");
        String nombreLugar= s.nextLine();
        System.out.println("Ingrese horario de entrada: ");
        String horarioEntrada= s.nextLine();
        System.out.println("Ingrese horario de salida: ");
        String horarioSalida= s.nextLine();
        System.out.println("Tiene locomocion? (Si/No): ");
        String locomocionBool= s.nextLine();
        while(!locomocionBool.equalsIgnoreCase("no") || !locomocionBool.equalsIgnoreCase("si")){
          System.out.println("ERROR! Ingrese si o no. Tiene locomocion? (Si/No): ");
          locomocionBool= s.nextLine();
        }
        if(locomocionBool.equalsIgnoreCase("si")){
          locomocion=true;
        }
        else{
          if(locomocionBool.equalsIgnoreCase("no")){
            locomocion=false;
          }
        }
        System.out.println("Ingrese horario de salida: ");
        String tiempoLlegada= s.nextLine();
        Lugar lugar = new Lugar(tipoLugar,nombreLugar,horarioEntrada,horarioSalida,locomocion,tiempoLlegada);
        return lugar;
        
    }

    public static Suministro DescribirSuministros(){
        Scanner s = new Scanner(System.in);
        boolean televisor = true;
        boolean AC = true;
        boolean calefaccion = true;
        boolean refrigerador = true;
        boolean cocina = true;
        boolean lavadora = true;
        String respuesta = "";
        
        while(!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")){
          System.out.println("Tiene televisor incorporado el apartamento?(si/no)");
          respuesta = s.nextLine();
          if(respuesta.equalsIgnoreCase("si")){
            televisor = true;
          }else{
            if(respuesta.equalsIgnoreCase("no")){
              televisor = false;
            }else{
              System.out.println("ERROR: No se ingreso una respuesta valida");
            }
          }
        }

        respuesta = "";

        while(!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")){
          System.out.println("Tiene aire acondicionado incorporado el apartamento?(si/no)");
          respuesta = s.nextLine();
          if(respuesta.equalsIgnoreCase("si")){
            AC = true;
          }else{
            if(respuesta.equalsIgnoreCase("no")){
              AC = false;
            }else{
              System.out.println("ERROR: No se ingreso una respuesta valida");
            }
          }
        }

        respuesta = "";

        while(!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")){
          System.out.println("Tiene calefaccion incorporada el apartamento?(si/no)");
          respuesta = s.nextLine();
          if(respuesta.equalsIgnoreCase("si")){
            calefaccion = true;
          }else{
            if(respuesta.equalsIgnoreCase("no")){
              calefaccion = false;
            }else{
              System.out.println("ERROR: No se ingreso una respuesta valida");
            }
          }
        }

        respuesta = "";

        while(!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")){
          System.out.println("Tiene refrigerador incorporado el apartamento?(si/no)");
          respuesta = s.nextLine();
          if(respuesta.equalsIgnoreCase("si")){
            refrigerador = true;
          }else{
            if(respuesta.equalsIgnoreCase("no")){
              refrigerador = false;
            }else{
              System.out.println("ERROR: No se ingreso una respuesta valida");
            }
          }
        }

        respuesta = "";

        while(!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")){
          System.out.println("Tiene cocina incorporada el apartamento?(si/no)");
          respuesta = s.nextLine();
          if(respuesta.equalsIgnoreCase("si")){
            cocina = true;
          }else{
            if(respuesta.equalsIgnoreCase("no")){
              cocina = false;
            }else{
              System.out.println("ERROR: No se ingreso una respuesta valida");
            }
          }
        }

        respuesta = "";

        while(!respuesta.equalsIgnoreCase("si") || !respuesta.equalsIgnoreCase("no")){
          System.out.println("Tiene lavadora incorporada el apartamento?(si/no)");
          respuesta = s.nextLine();
          if(respuesta.equalsIgnoreCase("si")){
            lavadora = true;
          }else{
            if(respuesta.equalsIgnoreCase("no")){
              lavadora = false;
            }else{
              System.out.println("ERROR: No se ingreso una respuesta valida");
            }
          }
        }
        Suministro suministro = new Suministro(televisor,AC,calefaccion,refrigerador,cocina,lavadora);
        return suministro;
        
    }

}