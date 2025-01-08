package com.model;

public class Calisan {
    private String ad;
    private String soyad;
    private String tcNo;
    private double maas;
    private String pozisyon;
    private String subeKodu;
    private int izinGunleri;
    private String egitimDurumu;
    private int performansPuani;
    
    public Calisan(String ad, String soyad, String tcNo, double maas, String pozisyon, 
                  String subeKodu, String egitimDurumu) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.maas = maas;
        this.pozisyon = pozisyon;
        this.subeKodu = subeKodu;
        this.izinGunleri = 14;
        this.egitimDurumu = egitimDurumu;
        this.performansPuani = 70;
    }
    
    public void bilgileriGoster() {
        System.out.println("\nÇalışan Bilgileri:");
        System.out.println("Ad: " + ad);
        System.out.println("Soyad: " + soyad);
        System.out.println("TC No: " + tcNo);
        System.out.println("Maaş: " + maas + " TL");
        System.out.println("Pozisyon: " + pozisyon);
        System.out.println("Şube Kodu: " + subeKodu);
        System.out.println("Eğitim Durumu: " + egitimDurumu);
        System.out.println("Performans Puanı: " + performansPuani);
        System.out.println("Kalan İzin: " + izinGunleri + " gün");
    }

    public void izinKullan(int gun) {
        if (gun <= izinGunleri) {
            izinGunleri -= gun;
            System.out.println(ad + " " + soyad + " " + gun + " gün izin kullandı.");
            System.out.println("Kalan izin: " + izinGunleri + " gün");
        } else {
            System.out.println("Yetersiz izin günü! Mevcut izin: " + izinGunleri + " gün");
        }
    }

    public void performansGuncelle(int puan) {
        if (puan >= 0 && puan <= 100) {
            int eskiPuan = this.performansPuani;
            this.performansPuani = puan;
            System.out.println(ad + " " + soyad + " performans puanı güncellendi:");
            System.out.println("Eski puan: " + eskiPuan);
            System.out.println("Yeni puan: " + puan);
            
            if (puan >= 90) {
                System.out.println("Tebrikler! Yüksek performans.");
            } else if (puan < 50) {
                System.out.println("Uyarı: Düşük performans!");
            }
        } else {
            System.out.println("Geçersiz performans puanı! (0-100 arası olmalı)");
        }
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
    
    public String getPozisyon() { return pozisyon; }
    public void setPozisyon(String pozisyon) { this.pozisyon = pozisyon; }
    
    public String getSubeKodu() { return subeKodu; }
    public void setSubeKodu(String subeKodu) { this.subeKodu = subeKodu; }
    
    public int getIzinGunleri() { return izinGunleri; }
    public void setIzinGunleri(int izinGunleri) { this.izinGunleri = izinGunleri; }
    
    public String getEgitimDurumu() { return egitimDurumu; }
    public void setEgitimDurumu(String egitimDurumu) { this.egitimDurumu = egitimDurumu; }
    
    public int getPerformansPuani() { return performansPuani; }
    public void setPerformansPuani(int performansPuani) { this.performansPuani = performansPuani; }
} 