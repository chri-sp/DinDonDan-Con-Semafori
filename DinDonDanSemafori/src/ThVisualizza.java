

public class ThVisualizza extends Thread {

    private cDatiCondivisi ptrDati;

    public ThVisualizza(cDatiCondivisi ptrDati) {
        this.ptrDati = ptrDati;
    }

    public void run() {
        try {
            while (true) {

                ptrDati.waitsincVisualizza1();
                
                System.out.println(ptrDati.getRintocco());                
                if(ptrDati.getRintocco().equals("DAN")){
                    System.out.println("\n");
                }
                
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                ptrDati.signalsincVisualizza2();

            }
        } catch (InterruptedException ex) {
            
        }
    }
}
