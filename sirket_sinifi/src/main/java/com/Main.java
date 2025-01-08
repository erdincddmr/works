package com;

import com.model.Calisan;
import com.model.Mudur;
import com.model.Sirket;

public class Main {
    public static void main(String[] args) {
        // Şirket nesnesi oluşturma
        Sirket sirket = new Sirket("Tech Solutions A.Ş.", "İstanbul/Türkiye", 1000000, 2010);
        
        // Müdür nesneleri oluşturma
        Mudur mudur1 = new Mudur("Erdinç", "Demir", "12345678901", 45000, "Yazılım", 
                                "Üst Düzey", "Doktora", 15, 8);
        Mudur mudur2 = new Mudur("Ayşe", "Yılmaz", "12345678902", 35000, "İnsan Kaynakları", 
                                "Orta Düzey", "Yüksek Lisans", 10, 5);
        
        // Çalışan nesneleri oluşturma
        Calisan calisan1 = new Calisan("Ali", "Kaya", "12345678903", 25000, "Yazılım", 
                                      "Lisans", 3);
        Calisan calisan2 = new Calisan("Zeynep", "Demir", "12345678904", 27000, "Yazılım", 
                                      "Yüksek Lisans", 4);
        Calisan calisan3 = new Calisan("Mehmet", "Yıldız", "12345678905", 22000, "İnsan Kaynakları", 
                                      "Lisans", 2);
        
        // Şirkete müdürleri ekle
        sirket.mudurEkle(mudur1);
        sirket.mudurEkle(mudur2);
        
        // Şirkete çalışanları ekle
        sirket.calisanEkle(calisan1);
        sirket.calisanEkle(calisan2);
        sirket.calisanEkle(calisan3);
        
        // Müdürlere ekip üyelerini ekle
        mudur1.ekipUyesiEkle(calisan1);
        mudur1.ekipUyesiEkle(calisan2);
        mudur2.ekipUyesiEkle(calisan3);
        
        // Şirket bilgilerini göster
        sirket.sirketBilgileriGoster();
        
        // Departman raporunu göster
        sirket.departmanRaporuOlustur();
        
        // Çalışan işlemleri
        System.out.println("\nÇalışan İşlemleri:");
        calisan1.egitimeKatil("Python İleri Seviye");
        calisan2.maasZammi(15.0);
        
        // Müdür işlemleri
        System.out.println("\nMüdür İşlemleri:");
        mudur1.primHesapla();
        mudur1.toplantiDuzenle();
        
        // Son durumu göster
        System.out.println("\nSon Durum:");
        sirket.sirketBilgileriGoster();
    }
}