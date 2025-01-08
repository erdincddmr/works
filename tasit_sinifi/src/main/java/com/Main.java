package com;

import com.model.Otomobil;
import com.model.Motosiklet;
import com.model.Kamyon;

public class Main {
    public static void main(String[] args) {
        // Taşıtları oluştur
        Otomobil otomobil = new Otomobil("BMW", "520i", 2023, "Siyah", 4, 
                                        "Otomatik", "Dizel", 520.0);
        Motosiklet motosiklet = new Motosiklet("Honda", "CBR", 2022, "Kırmızı", 
                                              1000, true, "Sport", true);
        Kamyon kamyon = new Kamyon("Mercedes", "Actros", 2021, "Beyaz", 
                                  25.0, 3, true);
        
        // Otomobil işlemleri
        System.out.println("\n--- Otomobil İşlemleri ---");
        otomobil.ozellikGoster();
        otomobil.calistir();
        otomobil.bagajAc();
        otomobil.durdur();
        
        // Motosiklet işlemleri
        System.out.println("\n--- Motosiklet İşlemleri ---");
        motosiklet.ozellikGoster();
        motosiklet.kaskTak();
        motosiklet.calistir();
        motosiklet.durdur();
        
        // Kamyon işlemleri
        System.out.println("\n--- Kamyon İşlemleri ---");
        kamyon.ozellikGoster();
        kamyon.calistir();
        kamyon.yukYukle(15.0, "Kum");
        kamyon.durdur();
    }
}