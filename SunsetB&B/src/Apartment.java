import java.util.ArrayList;

public class Apartment{
    String tipo, name ,direccion,ciudad;
    int num_bath , num_hab, precio ; 
    ArrayList<Lugar> l_lugar;
    Suministro suministro;

    public Apartment(String tipo,String name , int num_bath , int num_hab , String direccion, String ciudad, int precio){
        this.ciudad = ciudad;
        this.name = name;
        this.num_bath = num_bath;
        this.num_hab = num_hab;
        this.direccion = direccion;
        this.tipo = tipo;
        this.precio = precio;
        l_lugar = new ArrayList<Lugar>();
        suministro = new Suministro();
    }
    
    public String getName(){return this.name; };
    public String getcuidad(){return this.ciudad; };
    public int getnum_bath(){return this.num_bath; };
    public int getnum_hab(){return this.num_hab; };
    public String getdireccion(){return this.direccion; };
    public String getTipo(){return this.tipo; };
    public int getprecio(){return this.precio; };
    
}
