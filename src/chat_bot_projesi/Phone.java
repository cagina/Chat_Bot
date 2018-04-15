package chat_bot_projesi;

public class Phone extends Elektronik {
    
    public Phone(int ram,String os,String renk,String Tur,String Marka,String Model,double Fiyat){
      
        super.setFiyat(Fiyat);
        super.setMarka(Marka);
        super.setModel(Model);
        super.setOs(os);
        super.setRam(ram);
        super.setRenk(renk);
        super.setTur(Tur);
    
    }
     public int getRam() {
        return super.getRam();
    }

    public String getOs() {
        return super.getOs();
    }

    public String getRenk() {
        return super.getRenk();
    }

    public String getTur() {
        return super.getTur();
    }

    public String getMarka() {
        return super.getMarka();
    }

    public String getModel() {
        return super.getModel();
    }

    public double getFiyat() {
        return super.getFiyat();
    }
    
    public String ToString()
    { return ("\n-- "+getModel()+" --\nRam : "+this.getRam()+"\nOs : "+this.getOs()+"\nFiyat : "+getFiyat()+"\nModel :"+getModel()+ "\nMarka : "+getMarka()+ "\nTur: "+ getTur()+"\nRenk : "+getRenk());}
    
}
