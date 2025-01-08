package com.model;

public class Kamyon extends Tasit {
    private double yukKapasitesi;
    private double mevcutYuk;
    private int dingilSayisi;
    private boolean dorseTakili;
    private String yukTipi;
    
    public Kamyon(String marka, String model, int yil, String renk, double yukKapasitesi, 
                  int dingilSayisi, boolean dorseTakili) {
        super(marka, model, yil, renk, 140.0);
        this.yukKapasitesi = yukKapasitesi;
        this.mevcutYuk = 0;
        this.dingilSayisi = dingilSayisi;
        this.dorseTakili = dorseTakili;
        this.yukTipi = "Boş";
    }
    
    public void yukYukle(double yukMiktari, String yukTipi) {
        if (mevcutYuk + yukMiktari <= yukKapasitesi) {
            if (!dorseTakili && yukMiktari > yukKapasitesi * 0.6) {
                System.out.println("Bu kadar yük için dorse gerekli!");
                return;
            }
            mevcutYuk += yukMiktari;
            this.yukTipi = yukTipi;
            System.out.println(yukMiktari + " ton " + yukTipi + " yüklendi.");
            System.out.println("Mevcut yük: " + mevcutYuk + " ton");
            if (mevcutYuk > yukKapasitesi * 0.8) {
                System.out.println("Uyarı: Ağır yük, hız sınırlaması uygulanacak!");
            }
        } else {
            System.out.println("Bu kadar yük yüklenemez! Kapasite: " + yukKapasitesi + " ton");
        }
    }
    
    public void yukBosalt(double yukMiktari) {
        if (mevcutYuk - yukMiktari >= 0) {
            mevcutYuk -= yukMiktari;
            System.out.println(yukMiktari + " ton " + yukTipi + " boşaltıldı.");
            System.out.println("Kalan yük: " + mevcutYuk + " ton");
            if (mevcutYuk == 0) {
                yukTipi = "Boş";
            }
        } else {
            System.out.println("Bu kadar yük boşaltılamaz! Mevcut yük: " + mevcutYuk + " ton");
        }
    }

    public void dorseTakCikar() {
        dorseTakili = !dorseTakili;
        if (dorseTakili) {
            yukKapasitesi *= 1.5;
            System.out.println("Dorse takıldı. Yeni kapasite: " + yukKapasitesi + " ton");
        } else {
            if (mevcutYuk > yukKapasitesi / 1.5) {
                System.out.println("Dorse çıkarılamaz! Önce yükü boşaltın.");
                dorseTakili = true;
                return;
            }
            yukKapasitesi /= 1.5;
            System.out.println("Dorse çıkarıldı. Yeni kapasite: " + yukKapasitesi + " ton");
        }
    }
    
    @Override
    public void hizlan(double artis) {
        if (mevcutYuk > yukKapasitesi * 0.8) {
            artis = Math.min(artis, 10);
            System.out.println("Ağır yük nedeniyle hız sınırlandı!");
        }
        if (dorseTakili) {
            artis = artis * 0.8;
            System.out.println("Dorse nedeniyle hız kontrollü artırılıyor.");
        }
        super.hizlan(artis);
    }
    
    @Override
    public void ozellikGoster() {
        System.out.println("\nKamyon Özellikleri:");
        System.out.println("Marka: " + getMarka());
        System.out.println("Model: " + getModel());
        System.out.println("Yıl: " + getYil());
        System.out.println("Renk: " + getRenk());
        System.out.println("Yük Kapasitesi: " + yukKapasitesi + " ton");
        System.out.println("Mevcut Yük: " + mevcutYuk + " ton");
        System.out.println("Yük Tipi: " + yukTipi);
        System.out.println("Dingil Sayısı: " + dingilSayisi);
        System.out.println("Dorse Durumu: " + (dorseTakili ? "Takılı" : "Takılı Değil"));
        System.out.println("Maksimum Hız: " + getMaksimumHiz() + " km/saat");
        System.out.println("Yakıt Durumu: %" + String.format("%.1f", getYakitDurumu()));
    }
    
    // Getter ve Setter metodları
    public double getYukKapasitesi() { return yukKapasitesi; }
    public void setYukKapasitesi(double yukKapasitesi) { this.yukKapasitesi = yukKapasitesi; }
    
    public double getMevcutYuk() { return mevcutYuk; }
    public void setMevcutYuk(double mevcutYuk) { this.mevcutYuk = mevcutYuk; }
    
    public int getDingilSayisi() { return dingilSayisi; }
    public void setDingilSayisi(int dingilSayisi) { this.dingilSayisi = dingilSayisi; }
    
    public boolean isDorseTakili() { return dorseTakili; }
    public void setDorseTakili(boolean dorseTakili) { this.dorseTakili = dorseTakili; }
    
    public String getYukTipi() { return yukTipi; }
    public void setYukTipi(String yukTipi) { this.yukTipi = yukTipi; }
} 