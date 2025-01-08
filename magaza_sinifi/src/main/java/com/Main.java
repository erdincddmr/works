package com;

import com.model.Calisan;
import com.model.Magaza;
import com.model.Sube;

public class Main {
    public static void main(String[] args) {
        // Mağaza nesnesi oluşturma
        Magaza magaza = new Magaza("Mega Market", "İstanbul/Merkez", "123456789", 2010);
        
        // Şube nesneleri oluşturma
        Sube sube1 = new Sube("SUB001", "Kadıköy Şubesi", "İstanbul/Kadıköy", 
                             "0216-555-0001", "Ahmet Yılmaz");
        Sube sube2 = new Sube("SUB002", "Beşiktaş Şubesi", "İstanbul/Beşiktaş", 
                             "0212-555-0002", "Mehmet Demir");
        Sube sube3 = new Sube("SUB003", "Kızılay Şubesi", "Ankara/Kızılay", 
                             "0312-555-0003", "Ayşe Kaya");
        
        // Çalışan nesneleri oluşturma
        Calisan calisan1 = new Calisan("Erdinç", "Demir", "12345678901", 12000, 
                                      "Kasiyer", "SUB001", "Lisans");
        Calisan calisan2 = new Calisan("Zeynep", "Yıldız", "12345678902", 15000, 
                                      "Müdür Yardımcısı", "SUB001", "Yüksek Lisans");
        Calisan calisan3 = new Calisan("Ali", "Kaya", "12345678903", 11000, 
                                      "Kasiyer", "SUB002", "Ön Lisans");
        
        // Şubeleri mağazaya ekle
        magaza.subeEkle(sube1);
        magaza.subeEkle(sube2);
        magaza.subeEkle(sube3);
        
        // Çalışanları şubelere ekle
        sube1.calisanEkle(calisan1);
        sube1.calisanEkle(calisan2);
        sube2.calisanEkle(calisan3);
        
        // Şubelere ciro ekle
        sube1.ciroGuncelle(150000);
        sube2.ciroGuncelle(120000);
        sube3.ciroGuncelle(90000);
        
        // Mağaza bilgilerini göster
        magaza.magazaBilgileriGoster();
        
        // Şubeleri listele
        magaza.subeleriListele();
        
        // En başarılı şubeyi bul
        magaza.enBasariliSubeyiBul();
        
        // Çalışan transfer işlemi
        System.out.println("\nÇalışan Transfer İşlemi:");
        magaza.calisanTransfer("SUB001", "SUB002", "12345678901");
        
        // Şube kapatma işlemi
        System.out.println("\nŞube Kapatma İşlemi:");
        sube3.subeyiKapat();
        
        // Son durumu göster
        System.out.println("\nSon Durum:");
        magaza.magazaBilgileriGoster();
    }
}