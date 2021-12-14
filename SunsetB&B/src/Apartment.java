public class Apartment{
    String tipo, name ,direccion,cuidad;
    int num_bath , num_hab ; 

    public Apartment(String tipo,String name , int num_bath , int num_hab , String direccion, String cuidad){
        this.cuidad = cuidad;
        this.name = name;
        this.num_bath = num_bath;
        this.num_hab = num_hab;
        this.direccion = direccion;
        this.tipo = tipo;  
    }

    public String getName(){return this.name; };
    public String getcuidad(){return this.cuidad; };

    public int getnum_bath(){return this.num_bath; };
    public int getnum_hab(){return this.num_hab; };
    
    public String getdireccion(){return this.direccion; };
    public String getTipo(){return this.tipo; };

    
}
