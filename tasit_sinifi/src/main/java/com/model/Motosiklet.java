package com.model;

public class Motosiklet extends Tasit {
    private int motorHacmi;
    private boolean kasklı;
    private boolean seleli;
    private String motosikletTipi;
    private boolean abs;
    
    public Motosiklet(String marka, String model, int yil, String renk, int motorHacmi, 
                      boolean seleli, String motosikletTipi, boolean abs) {
        super(marka, model, yil, renk, 180.0);
        this.motorHacmi = motorHacmi;
        this.kasklı = false;
        this.seleli = seleli;
        this.motosikletTipi = motosikletTipi;
        this.abs = abs;
    }
    
    public void kaskTak() {
        if (!kasklı) {
            kasklı = true;
            System.out.println("Kask takıldı. Güvenli sürüş! ABS sistemi: " + (abs ? "Aktif" : "Yok"));
        } else {
            System.out.println("Kask zaten takılı!");
        }
    }
    
    public void kaskCikar() {
        if (kasklı) {
            if (getHiz() == 0) {
                kasklı = false;
                System.out.println("Kask çıkarıldı. Sürüş için tekrar takın.");
            } else {
                System.out.println("Hareket halindeyken kask çıkarılamaz! Önce durun.");
            }
        } else {
            System.out.println("Kask zaten takılı değil!");
        }
    }

    public void modDegistir() {
        if (motosikletTipi.equalsIgnoreCase("Sport")) {
            setMaksimumHiz(200.0);
            System.out.println("Sport mod aktif! Maksimum hız artırıldı.");
        }
    }
    
    @Override
    public void calistir() {
        if (kasklı) {
            super.calistir();
            if (abs) {
                System.out.println("ABS sistemi hazır.");
            }
        } else {
            System.out.println("Önce kask takmalısınız! Güvenlik öncelikli.");
        }
    }
    
    @Override
    public void hizlan(double artis) {
        if (abs && getHiz() + artis > 100) {
            System.out.println("ABS sistemi devrede, hız kontrollü artırılıyor.");
            artis = artis * 0.8;
        }
        super.hizlan(artis);
    }
    
    @Override
    public void ozellikGoster() {
        System.out.println("\nMotosiklet Özellikleri:");
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Yıl: " + getYil());
        System.out.println("Renk: " + getRenk());
        System.out.println("Motor Hacmi: " + motorHacmi + " cc");
        System.out.println("Motosiklet Tipi: " + motosikletTipi);
        System.out.println("ABS Sistemi: " + (abs ? "Var" : "Yok"));
        System.out.println("Maksimum Hız: " + getMaksimumHiz() + " km/saat");
        System.out.println("Yakıt Durumu: %" + String.format("%.1f", getYakitDurumu()));
        System.out.println("Kask Durumu: " + (kasklı ? "Takılı" : "Takılı Değil"));
        System.out.println("Sele Durumu: " + (seleli ? "Var" : "Yok"));
    }
    
    // Getter ve Setter metodları
    public int getMotorHacmi() { return motorHacmi; }
    public void setMotorHacmi(int motorHacmi) { this.motorHacmi = motorHacmi; }
    
    public boolean isKasklı() { return kasklı; }
    public void setKasklı(boolean kasklı) { this.kasklı = kasklı; }
    
    public boolean isSeleli() { return seleli; }
    public void setSeleli(boolean seleli) { this.seleli = seleli; }
    
    public String getMotosikletTipi() { return motosikletTipi; }
    public void setMotosikletTipi(String motosikletTipi) { this.motosikletTipi = motosikletTipi; }
    
    public boolean isAbs() { return abs; }
    public void setAbs(boolean abs) { this.abs = abs; }
} 