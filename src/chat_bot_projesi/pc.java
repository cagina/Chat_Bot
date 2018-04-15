package chat_bot_projesi;

public  class pc  extends Elektronik {
    public pc(int ram,String renk,String Tur,String Marka,String Model,double Fiyat)
    {
        super.setFiyat(Fiyat);
        super.setMarka(Marka);
        super.setModel(Model);
        super.setRam(ram);
        super.setRenk(renk);
        super.setTur(Tur);
    
    }
    
     public int getRam() {
        return super.getRam();
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
    { return ("\nRam : "+this.getRam()+"\nFiyat : "+getFiyat()+"\nModel :"+getModel()+ "\nMarka : "+getMarka()+ "\nTur: "+ getTur()+"\nRenk : "+getRenk());}
    
    
}
