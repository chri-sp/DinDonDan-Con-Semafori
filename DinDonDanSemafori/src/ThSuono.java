/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ThSuono extends Thread {
    
    private String suono;

    cDatiCondivisi ptrDati;

    public ThSuono(String x, cDatiCondivisi p) {
        suono = x;
        ptrDati = p;
    }

    public void run() {
        boolean verify = true;
        try {
            while (verify == true) {

                switch (this.suono) {
                    case "DIN":
                        ptrDati.waitsinc1();
                        continua();
                        ptrDati.signalsinc2();
                        break;
                        
                    case "DON":
                        ptrDati.waitsinc2();
                        continua();
                        ptrDati.signalsinc3();
                        break;
                        
                    case "DAN":
                        ptrDati.waitsinc3();
                        continua();
                        ptrDati.signalsinc1();
                        break;
                }

                Thread.sleep((int) (Math.random() * 10));

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        } catch (InterruptedException ex) {

        }
        switch (this.suono) {
            case "DIN":
                ptrDati.signalSemDin();
                break;
            case "DON":
                ptrDati.signalSemDon();
                break;
            case "DAN":
                ptrDati.signalSemDan();
                break;

        }
    }

    public void continua() {
        try {
            
            ptrDati.waitsincVisualizza2();
            ptrDati.setRintocco(suono);
            ptrDati.signalsincVisualizza1();
            
        } catch (InterruptedException ex) {

        }
    }
}
