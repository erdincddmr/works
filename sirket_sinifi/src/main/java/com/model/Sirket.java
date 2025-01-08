package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sirket {
    private String ad;
    private String adres;
    private List<Calisan> calisanlar;
    private List<Mudur> mudurler;
    private double toplamButce;
    private Map<String, Double> departmanButceleri;
    private int kurulus_yili;
    private List<String> projeler;
    
    public Sirket(String ad, String adres, double baslangicButcesi, int kurulus_yili) {
        this.ad = ad;
        this.adres = adres;
        this.toplamButce = baslangicButcesi;
        this.kurulus_yili = kurulus_yili;
        this.calisanlar = new ArrayList<>();
        this.mudurler = new ArrayList<>();
        this.departmanButceleri = new HashMap<>();
        this.projeler = new ArrayList<>();
        varsayilanProjeleriEkle();
    }
    
    private void varsayilanProjeleriEkle() {
        projeler.add("Web Sitesi Yenileme");
        projeler.add("Mobil Uygulama Geliştirme");
        projeler.add("Veritabanı Optimizasyonu");
    }
    
    public void calisanEkle(Calisan calisan) {
        calisanlar.add(calisan);
        System.out.println(calisan.getAd() + " " + calisan.getSoyad() + " şirkete eklendi.");
        departmanButcesiGuncelle(calisan.getDepartman(), calisan.getMaas());
    }
    
    public void mudurEkle(Mudur mudur) {
        mudurler.add(mudur);
        System.out.println(mudur.getAd() + " " + mudur.getSoyad() + " şirkete müdür olarak eklendi.");
        departmanButcesiGuncelle(mudur.getDepartman(), mudur.getMaas());
    }
    
    private void departmanButcesiGuncelle(String departman, double maas) {
        departmanButceleri.putIfAbsent(departman, 0.0);
        departmanButceleri.put(departman, departmanButceleri.get(departman) + maas);
    }
    
    public void butceGuncelle(double miktar) {
        this.toplamButce += miktar;
        System.out.println("Şirket bütçesi güncellendi. Yeni bütçe: " + toplamButce + " TL");
        
        if (miktar < 0 && Math.abs(miktar) > toplamButce * 0.2) {
            System.out.println("Uyarı: Büyük bir harcama yapıldı! Bütçe kontrolü gerekebilir.");
        }
    }
    
    public void maaslariOde() {
        double toplamMaas = 0;
        Map<String, Double> departmanMaliyetleri = new HashMap<>();
        
        // Çalışan maaşlarını hesapla
        for (Calisan calisan : calisanlar) {
            toplamMaas += calisan.getMaas();
            String dept = calisan.getDepartman();
            departmanMaliyetleri.putIfAbsent(dept, 0.0);
            departmanMaliyetleri.put(dept, departmanMaliyetleri.get(dept) + calisan.getMaas());
        }
        
        // Müdür maaşları ve primleri
        for (Mudur mudur : mudurler) {
            double mudurMaliyeti = mudur.getMaas() * (1 + mudur.getPrimOrani() / 100);
            toplamMaas += mudurMaliyeti;
            String dept = mudur.getDepartman();
            departmanMaliyetleri.putIfAbsent(dept, 0.0);
            departmanMaliyetleri.put(dept, departmanMaliyetleri.get(dept) + mudurMaliyeti);
        }
        
        if (toplamMaas <= toplamButce) {
            toplamButce -= toplamMaas;
            System.out.println("\nMaaşlar Ödendi:");
            System.out.println("Toplam Ödenen: " + toplamMaas + " TL");
            System.out.println("Kalan Bütçe: " + toplamButce + " TL");
            
            System.out.println("\nDepartman Bazlı Maaş Maliyetleri:");
            for (Map.Entry<String, Double> entry : departmanMaliyetleri.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " TL");
            }
        } else {
            System.out.println("Uyarı: Yeterli bütçe yok!");
            System.out.println("Gereken: " + toplamMaas + " TL");
            System.out.println("Mevcut: " + toplamButce + " TL");
            System.out.println("Eksik: " + (toplamMaas - toplamButce) + " TL");
        }
    }
    
    public void sirketBilgileriGoster() {
        System.out.println("\nŞirket Bilgileri:");
        System.out.println("Ad: " + ad);
        System.out.println("Adres: " + adres);
        System.out.println("Kuruluş Yılı: " + kurulus_yili);
        System.out.println("Faaliyet Süresi: " + (2024 - kurulus_yili) + " yıl");
        System.out.println("Toplam Bütçe: " + toplamButce + " TL");
        System.out.println("Çalışan Sayısı: " + calisanlar.size());
        System.out.println("Müdür Sayısı: " + mudurler.size());
        
        System.out.println("\nAktif Projeler:");
        for (String proje : projeler) {
            System.out.println("- " + proje);
        }
    }
    
    public void departmanRaporuOlustur() {
        System.out.println("\nDepartman Raporu:");
        Map<String, Integer> departmanCalisanSayisi = new HashMap<>();
        Map<String, Double> departmanOrtalamaTecrube = new HashMap<>();
        
        // Çalışan istatistiklerini hesapla
        for (Calisan calisan : calisanlar) {
            String dept = calisan.getDepartman();
            departmanCalisanSayisi.putIfAbsent(dept, 0);
            departmanCalisanSayisi.put(dept, departmanCalisanSayisi.get(dept) + 1);
            
            departmanOrtalamaTecrube.putIfAbsent(dept, 0.0);
            departmanOrtalamaTecrube.put(dept, 
                departmanOrtalamaTecrube.get(dept) + calisan.getTecrube());
        }
        
        // Müdürleri de ekle
        for (Mudur mudur : mudurler) {
            String dept = mudur.getDepartman();
            departmanCalisanSayisi.putIfAbsent(dept, 0);
            departmanCalisanSayisi.put(dept, departmanCalisanSayisi.get(dept) + 1);
            
            departmanOrtalamaTecrube.putIfAbsent(dept, 0.0);
            departmanOrtalamaTecrube.put(dept, 
                departmanOrtalamaTecrube.get(dept) + mudur.getTecrube());
        }
        
        // Raporu yazdır
        for (String departman : departmanCalisanSayisi.keySet()) {
            int calisanSayisi = departmanCalisanSayisi.get(departman);
            double ortalamaTecrube = departmanOrtalamaTecrube.get(departman) / calisanSayisi;
            double departmanButcesi = departmanButceleri.getOrDefault(departman, 0.0);
            
            System.out.println("\nDepartman: " + departman);
            System.out.println("Çalışan Sayısı: " + calisanSayisi);
            System.out.println("Ortalama Tecrübe: " + String.format("%.1f", ortalamaTecrube) + " yıl");
            System.out.println("Departman Bütçesi: " + departmanButcesi + " TL");
        }
    }

    public void projeEkle(String projeAdi) {
        projeler.add(projeAdi);
        System.out.println("Yeni proje eklendi: " + projeAdi);
    }

    public void projeTamamla(String projeAdi) {
        if (projeler.remove(projeAdi)) {
            System.out.println("Proje tamamlandı: " + projeAdi);
        } else {
            System.out.println("Böyle bir proje bulunamadı!");
        }
    }
    
    // Getter ve Setter metodları
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }
    
    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }
    
    public List<Calisan> getCalisanlar() { return calisanlar; }
    public void setCalisanlar(List<Calisan> calisanlar) { this.calisanlar = calisanlar; }
    
    public List<Mudur> getMudurler() { return mudurler; }
    public void setMudurler(List<Mudur> mudurler) { this.mudurler = mudurler; }
    
    public double getToplamButce() { return toplamButce; }
    public void setToplamButce(double toplamButce) { this.toplamButce = toplamButce; }
    
    public Map<String, Double> getDepartmanButceleri() { return departmanButceleri; }
    public void setDepartmanButceleri(Map<String, Double> departmanButceleri) { 
        this.departmanButceleri = departmanButceleri; 
    }
    
    public int getKurulus_yili() { return kurulus_yili; }
    public void setKurulus_yili(int kurulus_yili) { this.kurulus_yili = kurulus_yili; }
    
    public List<String> getProjeler() { return projeler; }
    public void setProjeler(List<String> projeler) { this.projeler = projeler; }
} 