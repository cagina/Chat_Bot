package chat_bot_projesi;

interface Product {
    String getTur();
    String getMarka();
    String getModel();
    double getFiyat();
    
    Product setTur(String tur);
    Product setMarka(String marka);
    Product setModel(String model);
    Product setFiyat(double fiyat);
}
