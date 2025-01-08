package com.model;

import java.util.ArrayList;
import java.util.List;

public class Mudur extends Calisan {
    private List<Calisan> ekip;
    private String seviye;
    private double primOrani;
    private int yonetimTecrubesi;
    private List<String> sorumluluklar;
    
    public Mudur(String ad, String soyad, String tcNo, double maas, String departman, 
                String seviye, String egitimDurumu, int tecrube, int yonetimTecrubesi) {
        super(ad, soyad, tcNo, maas, departman, egitimDurumu, tecrube);
        this.seviye = seviye;
        this.ekip = new ArrayList<>();
        this.primOrani = seviye.equals("Üst Düzey") ? 30 : 20;
        this.yonetimTecrubesi = yonetimTecrubesi;
        this.sorumluluklar = new ArrayList<>();
        varsayilanSorumluluklariEkle();
    }
    
    private void varsayilanSorumluluklariEkle() {
        sorumluluklar.add("Ekip Yönetimi");
        sorumluluklar.add("Performans Değerlendirme");
        sorumluluklar.add("Raporlama");
        if (seviye.equals("Üst Düzey")) {
            sorumluluklar.add("Stratejik Planlama");
            sorumluluklar.add("Bütçe Yönetimi");
        }
    }
    
    public void ekipUyesiEkle(Calisan calisan) {
        if (ekip.size() < 10) {
            ekip.add(calisan);
            System.out.println(calisan.getAd() + " " + calisan.getSoyad() + " ekibe eklendi.");
            System.out.println("Güncel ekip büyüklüğü: " + ekip.size());
        } else {
            System.out.println("Maksimum ekip büyüklüğüne ulaşıldı!");
        }
    }
    
    public void ekipUyesiCikar(Calisan calisan) {
        if (ekip.remove(calisan)) {
            System.out.println(calisan.getAd() + " " + calisan.getSoyad() + " ekipten çıkarıldı.");
            System.out.println("Güncel ekip büyüklüğü: " + ekip.size());
        } else {
            System.out.println("Bu çalışan ekipte bulunamadı.");
        }
    }
    
    public void toplantiDuzenle() {
        System.out.println("\n" + getAd() + " " + getSoyad() + " toplantı düzenliyor...");
        System.out.println("Toplantı Gündemi:");
        for (String sorumluluk : sorumluluklar) {
            System.out.println("- " + sorumluluk);
        }
        System.out.println("\nKatılımcılar:");
        for (Calisan calisan : ekip) {
            System.out.println("- " + calisan.getAd() + " " + calisan.getSoyad() + 
                             " (" + calisan.getDepartman() + ")");
        }
    }
    
    public void performansDegerlendirmesiYap() {
        System.out.println("\n" + getAd() + " " + getSoyad() + " performans değerlendirmesi yapıyor...");
        for (Calisan calisan : ekip) {
            int performansPuani = 70 + (int)(Math.random() * 31);
            System.out.println(calisan.getAd() + " " + calisan.getSoyad() + 
                             " değerlendiriliyor... Performans: " + performansPuani);
            
            if (performansPuani >= 90) {
                calisan.maasZammi(10.0);
            } else if (performansPuani >= 80) {
                calisan.maasZammi(5.0);
            } else {
                System.out.println("Eğitim öneriliyor: " + calisan.getAd() + " için gelişim programı");
                calisan.egitimeKatil("Performans Gelişim Programı");
            }
        }
    }

    public void primHesapla() {
        double primTutari = getMaas() * (primOrani / 100);
        System.out.println("\nPrim Hesaplaması (" + getSeviye() + "):");
        System.out.println("Baz Maaş: " + getMaas() + " TL");
        System.out.println("Prim Oranı: %" + primOrani);
        System.out.println("Prim Tutarı: " + primTutari + " TL");
        System.out.println("Toplam Kazanç: " + (getMaas() + primTutari) + " TL");
    }
    
    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
        System.out.println("Seviye: " + seviye);
        System.out.println("Yönetim Tecrübesi: " + yonetimTecrubesi + " yıl");
        System.out.println("Prim Oranı: %" + primOrani);
        System.out.println("Ekip Büyüklüğü: " + ekip.size() + " kişi");
        System.out.println("\nSorumluluklar:");
        for (String sorumluluk : sorumluluklar) {
            System.out.println("- " + sorumluluk);
        }
    }
    
    // Getter ve Setter metodları
    public List<Calisan> getEkip() { return ekip; }
    public void setEkip(List<Calisan> ekip) { this.ekip = ekip; }
    
    public String getSeviye() { return seviye; }
    public void setSeviye(String seviye) { this.seviye = seviye; }
    
    public double getPrimOrani() { return primOrani; }
    public void setPrimOrani(double primOrani) { this.primOrani = primOrani; }
    
    public int getYonetimTecrubesi() { return yonetimTecrubesi; }
    public void setYonetimTecrubesi(int yonetimTecrubesi) { this.yonetimTecrubesi = yonetimTecrubesi; }
    
    public List<String> getSorumluluklar() { return sorumluluklar; }
    public void setSorumluluklar(List<String> sorumluluklar) { this.sorumluluklar = sorumluluklar; }
} 