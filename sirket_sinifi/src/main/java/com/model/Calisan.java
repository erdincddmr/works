package com.model;

public class Calisan {
    private String ad;
    private String soyad;
    private String tcNo;
    private double maas;
    private String departman;
    private String egitimDurumu;
    private int tecrube;
    
    public Calisan(String ad, String soyad, String tcNo, double maas, String departman, 
                  String egitimDurumu, int tecrube) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.maas = maas;
        this.departman = departman;
        this.egitimDurumu = egitimDurumu;
        this.tecrube = tecrube;
    }
    
    public void bilgileriGoster() {
        System.out.println("\nÇalışan Bilgileri:");
        System.out.println("Ad: " + ad);
        System.out.println("Soyad: " + soyad);
        System.out.println("TC No: " + tcNo);
        System.out.println("Maaş: " + maas + " TL");
        System.out.println("Departman: " + departman);
        System.out.println("Eğitim Durumu: " + egitimDurumu);
        System.out.println("Tecrübe: " + tecrube + " yıl");
    }
    
    public void calis() {
        System.out.println(ad + " " + soyad + " " + departman + " departmanında çalışıyor...");
    }
    
    public void egitimeKatil(String egitimAdi) {
        System.out.println(ad + " " + soyad + " '" + egitimAdi + "' eğitimine katılıyor...");
        tecrube++;
    }

    public void maasZammi(double zamOrani) {
        if (zamOrani > 0) {
            double eskiMaas = maas;
            maas += maas * (zamOrani / 100);
            System.out.println(ad + " " + soyad + " için %"+ zamOrani + " zam yapıldı.");
            System.out.println("Eski maaş: " + eskiMaas + " TL");
            System.out.println("Yeni maaş: " + maas + " TL");
        }
    }
    
    // Getter ve Setter metodları
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }
    
    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }
    
    public String getTcNo() { return tcNo; }
    public void setTcNo(String tcNo) { this.tcNo = tcNo; }
    
    public double getMaas() { return maas; }
    public void setMaas(double maas) { this.maas = maas; }
    
    public String getDepartman() { return departman; }
    public void setDepartman(String departman) { this.departman = departman; }
    
    public String getEgitimDurumu() { return egitimDurumu; }
    public void setEgitimDurumu(String egitimDurumu) { this.egitimDurumu = egitimDurumu; }
    
    public int getTecrube() { return tecrube; }
    public void setTecrube(int tecrube) { this.tecrube = tecrube; }
} 