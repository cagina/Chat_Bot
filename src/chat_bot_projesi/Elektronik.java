/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_bot_projesi;

/**
 *
 * @author açt
 */
public abstract class Elektronik implements Product{
    private int ram;
    private String os;
    private String renk;
    private  String Tur;
    private String Marka;
   private  String Model;
   private  double Fiyat;

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

  public Product setTur(String Tur) {
        this.Tur = Tur;
        return this;
    }

    public  Product  setMarka(String Marka) {
        this.Marka = Marka;
         return this;
    }

    public  Product  setModel(String Model) {
        this.Model = Model;
         return this;
    }

    public  Product  setFiyat(double Fiyat) {
        this.Fiyat = Fiyat;
         return this;
    }

    public int getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public String getRenk() {
        return renk;
    }

    public String getTur() {
        return Tur;
    }

    public String getMarka() {
        return Marka;
    }

    public String getModel() {
        return Model;
    }

    public double getFiyat() {
        return Fiyat;
    }
    
   
    
}
