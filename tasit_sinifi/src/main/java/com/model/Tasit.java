package com.model;

public abstract class Tasit {
    private String marka;
    private String model;
    private int yil;
    private String renk;
    private boolean calisiyor;
    
    public Tasit(String marka, String model, int yil, String renk) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.renk = renk;
        this.calisiyor = false;
    }
    
    public void calistir() {
        if (!calisiyor) {
            calisiyor = true;
            System.out.println(marka + " " + model + " çalıştırıldı.");
        } else {
            System.out.println("Araç zaten çalışıyor!");
        }
    }
    
    public void durdur() {
        if (calisiyor) {
            calisiyor = false;
            System.out.println(marka + " " + model + " durduruldu.");
        } else {
            System.out.println("Araç zaten durmuş durumda!");
        }
    }
    
    public abstract void ozellikGoster();
    
    // Getter ve Setter metodları
    public String getMarka() { return marka; }
    public void setMarka(String marka) { this.marka = marka; }
    
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    
    public int getYil() { return yil; }
    public void setYil(int yil) { this.yil = yil; }
    
    public String getRenk() { return renk; }
    public void setRenk(String renk) { this.renk = renk; }
    
    public boolean isCalisiyor() { return calisiyor; }
    public void setCalisiyor(boolean calisiyor) { this.calisiyor = calisiyor; }
} 