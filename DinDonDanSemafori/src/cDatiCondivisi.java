/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.concurrent.Semaphore;

public class cDatiCondivisi {

    private String rintocco;

    private Semaphore SemDin;
    private Semaphore SemDon;
    private Semaphore SemDan;
    private Semaphore sinc1;
    private Semaphore sinc2;
    private Semaphore sinc3;
    private Semaphore sincVisualizza1;
    private Semaphore sincVisualizza2;

    public cDatiCondivisi() {
        SemDin = new Semaphore(0);
        SemDon = new Semaphore(0);
        SemDan = new Semaphore(0);

        sincVisualizza1 = new Semaphore(0);
        sincVisualizza2 = new Semaphore(1);
        
        sinc1 = new Semaphore(1);
        sinc2 = new Semaphore(0);
        sinc3 = new Semaphore(0);
    }

    public void waitsincVisualizza1() throws InterruptedException {
        sincVisualizza1.acquire();
    }

    public void signalsincVisualizza1() {
        sincVisualizza1.release();
    }

    public void waitsincVisualizza2() throws InterruptedException {
        sincVisualizza2.acquire();
    }

    public void signalsincVisualizza2() {
        sincVisualizza2.release();
    }

    public void waitsinc1() throws InterruptedException {
        sinc1.acquire();
    }

    public void signalsinc1() {
        sinc1.release();
    }

    public void waitsinc2() throws InterruptedException {
        sinc2.acquire();
    }

    public void signalsinc2() {
        sinc2.release();
    }

    public void waitsinc3() throws InterruptedException {
        sinc3.acquire();
    }

    public void signalsinc3() {
        sinc3.release();
    }

    public void waitSemDin() throws InterruptedException {
        SemDin.acquire();
    }

    public void signalSemDin() {
        SemDin.release();
    }

    public void waitSemDon() throws InterruptedException {
        SemDon.acquire();
    }

    public void signalSemDon() {
        SemDon.release();
    }

    public void waitSemDan() throws InterruptedException {
        SemDan.acquire();
    }

    public void signalSemDan() {
        SemDan.release();
    }

    public synchronized void setRintocco(String x) {
        rintocco = x;
    }
    public synchronized String getRintocco() {
        return rintocco;
    }
}
