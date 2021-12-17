public class Suministro{
  private boolean televisor;
  private boolean aire_acond;
  private boolean calefaccion;
  private boolean refrigerador;
  private boolean cocina;
  private boolean lavadora;
  
  public Suministro(boolean televisor,boolean aire_acond,boolean calefaccion, boolean refrigerador,boolean cocina,boolean lavadora){
    this.televisor = televisor;
    this.aire_acond = aire_acond;
    this.calefaccion = calefaccion;
    this.refrigerador = refrigerador;
    this.cocina = cocina;
    this.lavadora = lavadora;
  }

  //SETS
  public void setTelevisor(boolean televisor){
    this.televisor = televisor;
  }

  public void setAire_acond(boolean aire_acond){
    this.aire_acond = aire_acond;
  }

  public void setCalefaccion(boolean calefaccion){
    this.calefaccion = calefaccion;
  }

  public void setRefrigerador(boolean refrigerador){
    this.refrigerador = refrigerador;
  }

  public void setCocina(boolean cocina){
    this.cocina = cocina;
  }

  public void setLavadora(boolean lavadora){
    this.lavadora = lavadora;
  }

  //GETS
  public boolean getTelevisor(){
    return this.televisor;
  }

  public boolean getAire_acond(){
    return this.aire_acond;
  }

  public boolean getCalefaccion(){
    return this.calefaccion;
  }

  public boolean getRefrigerador(){
    return this.refrigerador;
  }

  public boolean getCocina(){
    return this.cocina;
  }

  public boolean getLavadora(){
    return this.lavadora;
  }
}