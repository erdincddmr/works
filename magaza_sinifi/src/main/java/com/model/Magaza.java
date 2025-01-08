package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Magaza {
    private String magazaAdi;
    private String adres;
    private String vergiNo;
    private Map<String, Sube> subeler;
    private double toplamCiro;
    private List<String> urunKategorileri;
    private Map<String, Double> kategoriCirolari;
    private int kurulusYili;
    
    public Magaza(String magazaAdi, String adres, String vergiNo, int kurulusYili) {
        this.magazaAdi = magazaAdi;
        this.adres = adres;
        this.vergiNo = vergiNo;
        this.kurulusYili = kurulusYili;
        this.subeler = new HashMap<>();
        this.toplamCiro = 0;
        this.urunKategorileri = new ArrayList<>();
        this.kategoriCirolari = new HashMap<>();
        varsayilanKategorileriEkle();
    }
    
    private void varsayilanKategorileriEkle() {
        urunKategorileri.add("Gıda");
        urunKategorileri.add("Elektronik");
        urunKategorileri.add("Giyim");
        urunKategorileri.add("Kozmetik");
        
        for (String kategori : urunKategorileri) {
            kategoriCirolari.put(kategori, 0.0);
        }
    }
    
    public void subeEkle(Sube sube) {
        if (!subeler.containsKey(sube.getSubeKodu())) {
            subeler.put(sube.getSubeKodu(), sube);
            System.out.println(sube.getSubeAdi() + " mağazaya eklendi.");
            System.out.println("Toplam şube sayısı: " + subeler.size());
        } else {
            System.out.println("Bu şube kodu zaten kullanımda: " + sube.getSubeKodu());
        }
    }
    
    public void subeSil(String subeKodu) {
        if (subeler.containsKey(subeKodu)) {
            Sube sube = subeler.get(subeKodu);
            if (sube.getCalisanlar().isEmpty()) {
                subeler.remove(subeKodu);
                System.out.println(sube.getSubeAdi() + " mağazadan silindi.");
                System.out.println("Kalan şube sayısı: " + subeler.size());
            } else {
                System.out.println("Bu şubede hala " + sube.getCalisanlar().size() + 
                                 " çalışan var! Önce çalışanları transfer edin.");
            }
        } else {
            System.out.println("Bu şube kodu bulunamadı: " + subeKodu);
        }
    }
    
    public void calisanTransfer(String kaynakSubeKodu, String hedefSubeKodu, String calisanTcNo) {
        if (subeler.containsKey(kaynakSubeKodu) && subeler.containsKey(hedefSubeKodu)) {
            Sube kaynakSube = subeler.get(kaynakSubeKodu);
            Sube hedefSube = subeler.get(hedefSubeKodu);
            
            Calisan transferEdilecek = null;
            for (Calisan calisan : kaynakSube.getCalisanlar()) {
                if (calisan.getTcNo().equals(calisanTcNo)) {
                    transferEdilecek = calisan;
                    break;
                }
            }
            
            if (transferEdilecek != null) {
                kaynakSube.calisanCikar(calisanTcNo);
                transferEdilecek.setSubeKodu(hedefSubeKodu);
                hedefSube.calisanEkle(transferEdilecek);
                System.out.println("Transfer başarılı!");
                System.out.println(transferEdilecek.getAd() + " " + transferEdilecek.getSoyad() + 
                                 " -> " + hedefSube.getSubeAdi());
            } else {
                System.out.println("Belirtilen TC numarasına sahip çalışan bulunamadı: " + calisanTcNo);
            }
        } else {
            System.out.println("Geçersiz şube kodu! Kaynak: " + kaynakSubeKodu + 
                             ", Hedef: " + hedefSubeKodu);
        }
    }
    
    public void kategoriCirosuEkle(String kategori, double miktar) {
        if (urunKategorileri.contains(kategori)) {
            kategoriCirolari.put(kategori, kategoriCirolari.get(kategori) + miktar);
            System.out.println(kategori + " kategorisine " + miktar + 
                             " TL ciro eklendi. Toplam: " + kategoriCirolari.get(kategori) + " TL");
        } else {
            System.out.println("Geçersiz kategori: " + kategori);
        }
    }
    
    public void toplamCiroHesapla() {
        toplamCiro = 0;
        for (Sube sube : subeler.values()) {
            toplamCiro += sube.getAylikCiro();
        }
        System.out.println("\nToplam Ciro Bilgileri:");
        System.out.println("Genel Toplam: " + toplamCiro + " TL");
        
        System.out.println("\nKategori Bazlı Cirolar:");
        for (Map.Entry<String, Double> entry : kategoriCirolari.entrySet()) {
            double yuzde = (entry.getValue() / toplamCiro) * 100;
            System.out.println(entry.getKey() + ": " + entry.getValue() + 
                             " TL (%" + String.format("%.1f", yuzde) + ")");
        }
    }
    
    public void enBasariliSubeyiBul() {
        Sube enBasarili = null;
        double enYuksekCiro = 0;
        
        for (Sube sube : subeler.values()) {
            if (sube.isAktif() && sube.getAylikCiro() > enYuksekCiro) {
                enYuksekCiro = sube.getAylikCiro();
                enBasarili = sube;
            }
        }
        
        if (enBasarili != null) {
            System.out.println("\nEn Başarılı Şube Raporu:");
            System.out.println("Şube: " + enBasarili.getSubeAdi());
            System.out.println("Ciro: " + enYuksekCiro + " TL");
            System.out.println("Çalışan Sayısı: " + enBasarili.getCalisanlar().size());
            System.out.println("Başarı Primi: " + (enYuksekCiro * 0.02) + " TL");
        } else {
            System.out.println("\nAktif şube bulunamadı!");
        }
    }
    
    public void magazaBilgileriGoster() {
        System.out.println("\nMağaza Bilgileri:");
        System.out.println("Mağaza Adı: " + magazaAdi);
        System.out.println("Merkez Adres: " + adres);
        System.out.println("Vergi No: " + vergiNo);
        System.out.println("Kuruluş Yılı: " + kurulusYili);
        System.out.println("Faaliyet Süresi: " + (2024 - kurulusYili) + " yıl");
        System.out.println("Toplam Şube Sayısı: " + subeler.size());
        System.out.println("Toplam Ciro: " + toplamCiro + " TL");
        
        int aktifSubeSayisi = 0;
        int toplamCalisan = 0;
        
        for (Sube sube : subeler.values()) {
            if (sube.isAktif()) {
                aktifSubeSayisi++;
            }
            toplamCalisan += sube.getCalisanlar().size();
        }
        
        System.out.println("Aktif Şube Sayısı: " + aktifSubeSayisi);
        System.out.println("Toplam Çalışan Sayısı: " + toplamCalisan);
        
        System.out.println("\nÜrün Kategorileri:");
        for (String kategori : urunKategorileri) {
            System.out.println("- " + kategori);
        }
    }
    
    public void subeleriListele() {
        System.out.println("\nŞubeler Listesi:");
        if (subeler.isEmpty()) {
            System.out.println("Henüz şube bulunmamaktadır.");
        } else {
            for (Sube sube : subeler.values()) {
                System.out.println("\n" + sube.getSubeAdi() + " Detayları:");
                System.out.println("Kod: " + sube.getSubeKodu());
                System.out.println("Adres: " + sube.getAdres());
                System.out.println("Durum: " + (sube.isAktif() ? "Aktif" : "Kapalı"));
                System.out.println("Çalışan Sayısı: " + sube.getCalisanlar().size());
                System.out.println("Aylık Ciro: " + sube.getAylikCiro() + " TL");
            }
        }
    }

    public void yeniKategoriEkle(String kategori) {
        if (!urunKategorileri.contains(kategori)) {
            urunKategorileri.add(kategori);
            kategoriCirolari.put(kategori, 0.0);
            System.out.println("Yeni kategori eklendi: " + kategori);
        } else {
            System.out.println("Bu kategori zaten mevcut!");
        }
    }
    
    // Getter ve Setter metodları
    public String getMagazaAdi() { return magazaAdi; }
    public void setMagazaAdi(String magazaAdi) { this.magazaAdi = magazaAdi; }
    
    public Map<String, Sube> getSubeler() { return subeler; }
    
    public double getToplamCiro() { return toplamCiro; }
    public void setToplamCiro(double toplamCiro) { this.toplamCiro = toplamCiro; }
    
    public List<String> getUrunKategorileri() { return urunKategorileri; }
    public void setUrunKategorileri(List<String> urunKategorileri) { 
        this.urunKategorileri = urunKategorileri; 
    }
    
    public Map<String, Double> getKategoriCirolari() { return kategoriCirolari; }
    public void setKategoriCirolari(Map<String, Double> kategoriCirolari) { 
        this.kategoriCirolari = kategoriCirolari; 
    }
    
    public int getKurulusYili() { return kurulusYili; }
    public void setKurulusYili(int kurulusYili) { this.kurulusYili = kurulusYili; }
    
    public String getVergiNo() { return vergiNo; }
    public void setVergiNo(String vergiNo) { this.vergiNo = vergiNo; }
} 