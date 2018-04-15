/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat_bot_projesi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oeem
 */
public class Chat_bot_projesi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        List<Phone> telefonlar = new ArrayList<Phone>();
        List<pc> bilgisayarlar = new ArrayList<pc>();
        Phone a = new Phone(3,"ios","Beyaz","Elektronik","Apple","iphonex", 6049); 
        Phone b = new Phone(6,"Android","Siyah","Elektronik","Samsung","samsung8",4999);
        Phone c = new Phone(4,"Android","Gri","Elektronik","Lg","lgg6",2399);
        pc d = new pc(8,"Metal","Elektronik","Hp","hp",3799);
        telefonlar.add(a);
        telefonlar.add(b);
        telefonlar.add(c);
        bilgisayarlar.add(d);
        Tweet yeni = new Tweet();

        new chat_ekrani(telefonlar,bilgisayarlar,yeni).setVisible(true);
   }
    
}
