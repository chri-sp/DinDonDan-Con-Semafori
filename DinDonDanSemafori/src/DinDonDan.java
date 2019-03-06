

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DinDonDan {

    /**
     * @brief Main per la gestione dei suoni.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Per iniziare e terminare premere invio");           
                     
            cDatiCondivisi dati = new cDatiCondivisi();

            ThSuono th1 = new ThSuono("DIN", dati);
            ThSuono th2 = new ThSuono("DON", dati);
            ThSuono th3 = new ThSuono("DAN", dati);
            ThVisualizza tv = new ThVisualizza(dati);

            String interruzione = "";
            while (true) {
                interruzione = console.readLine();
                if (interruzione.equals("")) {
                    break;
                }
            }
            
            tv.start();
            th1.start();
            th2.start();
            th3.start();

            interruzione = "";
            while (true) {
                interruzione = console.readLine();
                if (interruzione.equals("")) {
                    break;
                }
            }
            if (interruzione.equals("")) {
                th1.interrupt();
                th2.interrupt();
                th3.interrupt();
            }
            dati.waitSemDin();
            dati.waitSemDon();
            dati.waitSemDan();
            
            if (ThVisualizza.currentThread().isAlive()) {
                dati.signalsincVisualizza1();
                tv.interrupt();
            }

            System.out.println("FINE");

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(DinDonDan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
