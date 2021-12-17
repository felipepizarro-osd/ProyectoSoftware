import java.util.ArrayList;

public class Apartment{
    String tipo, name ,direccion,ciudad;
    int num_bath , num_hab ; 
    ArrayList<Lugar> l_lugar;
    Suministro suministro;
    Propietario propietario ;
    ArrayList <Estadia> lista_estadia;
    public Apartment(String tipo,String name , int num_bath , int num_hab , String direccion, String ciudad,Propietario c){
        this.ciudad = ciudad;
        this.name = name;
        this.num_bath = num_bath;
        this.num_hab = num_hab;
        this.direccion = direccion;
        this.tipo = tipo;
        this.l_lugar = new ArrayList<Lugar>();
        this.suministro = null;
        this.propietario = c;
        this.lista_estadia = new  ArrayList<Estadia>();
    }
    
    public String getName(){return this.name; };
    public String getcuidad(){return this.ciudad; };
    public int getnum_bath(){return this.num_bath; };
    public int getnum_hab(){return this.num_hab; };
    public String getdireccion(){return this.direccion; };
    public String getTipo(){return this.tipo; };
    /*public void setEstadia(Estadia est){
    };*/
    public ArrayList<Estadia> getLista_Estadia(){
      return this.lista_estadia;
    }
    public ArrayList<Lugar> getL_lugar(){
      return this.l_lugar;
    }
    public void setSuministro(Suministro su){
      suministro = su;
    };
    
}
