package com.model;

public class Otomobil extends Tasit {
    private int kapiSayisi;
    private String vitesTipi;
    private boolean klimaAcik;
    private String yakitTipi;
    private double bagajHacmi;
    
    public Otomobil(String marka, String model, int yil, String renk, int kapiSayisi, 
                    String vitesTipi, String yakitTipi, double bagajHacmi) {
        super(marka, model, yil, renk, 220.0);
        this.kapiSayisi = kapiSayisi;
        this.vitesTipi = vitesTipi;
        this.klimaAcik = false;
        this.yakitTipi = yakitTipi;
        this.bagajHacmi = bagajHacmi;
    }
    
    public void klimaAc() {
        if (isCalisiyor()) {
            if (!klimaAcik) {
                klimaAcik = true;
                setYakitDurumu(getYakitDurumu() - 2.0);
                System.out.println("Klima açıldı. Yakıt durumu: %" + String.format("%.1f", getYakitDurumu()));
            } else {
                System.out.println("Klima zaten açık!");
            }
        } else {
            System.out.println("Araç çalışmıyor! Önce çalıştırın.");
        }
    }
    
    public void klimaKapat() {
        if (klimaAcik) {
            klimaAcik = false;
            System.out.println("Klima kapatıldı. Yakıt tasarrufu sağlanacak.");
        } else {
            System.out.println("Klima zaten kapalı!");
        }
    }

    public void bagajAc() {
        System.out.println(bagajHacmi + " litrelik bagaj açıldı.");
    }
    
    @Override
    public void ozellikGoster() {
        System.out.println("\nOtomobil Özellikleri:");
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Yıl: " + getYil());
        System.out.println("Renk: " + getRenk());
        System.out.println("Kapı Sayısı: " + kapiSayisi);
        System.out.println("Vites Tipi: " + vitesTipi);
        System.out.println("Yakıt Tipi: " + yakitTipi);
        System.out.println("Bagaj Hacmi: " + bagajHacmi + " litre");
        System.out.println("Maksimum Hız: " + getMaksimumHiz() + " km/saat");
        System.out.println("Yakıt Durumu: %" + String.format("%.1f", getYakitDurumu()));
        System.out.println("Klima Durumu: " + (klimaAcik ? "Açık" : "Kapalı"));
    }
    
    // Getter ve Setter metodları
    public int getKapiSayisi() { return kapiSayisi; }
    public void setKapiSayisi(int kapiSayisi) { this.kapiSayisi = kapiSayisi; }
    
    public String getVitesTipi() { return vitesTipi; }
    public void setVitesTipi(String vitesTipi) { this.vitesTipi = vitesTipi; }
    
    public boolean isKlimaAcik() { return klimaAcik; }
    public void setKlimaAcik(boolean klimaAcik) { this.klimaAcik = klimaAcik; }
    
    public String getYakitTipi() { return yakitTipi; }
    public void setYakitTipi(String yakitTipi) { this.yakitTipi = yakitTipi; }
    
    public double getBagajHacmi() { return bagajHacmi; }
    public void setBagajHacmi(double bagajHacmi) { this.bagajHacmi = bagajHacmi; }
} 