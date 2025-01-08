package com;

public class AsciiArtPrinter {
    private static final int HARF_YUKSEKLIK = 7;
    private static final int HARF_GENISLIK = 8;
    private static final int BOSLUK_GENISLIK = 2;
    private static final String KARAKTER = "#";
    private static final String BOSLUK = " ";

    private static final String[][] HARFLER = {
        { // A
            "   ###   ",
            "  #   #  ",
            " #     # ",
            " ####### ",
            " #     # ",
            " #     # ",
            " #     # "
        },
        { // B
            " ######  ",
            " #     # ",
            " #     # ",
            " ######  ",
            " #     # ",
            " #     # ",
            " ######  "
        },
        { // C
            "  ##### ",
            " #     #",
            " #      ",
            " #      ",
            " #      ",
            " #     #",
            "  ##### "
        },
        { // D
            " #####   ",
            " #    #  ",
            " #     # ",
            " #     # ",
            " #     # ",
            " #    #  ",
            " #####   "
        },
        { // E
            " ####### ",
            " #       ",
            " #       ",
            " #####   ",
            " #       ",
            " #       ",
            " ####### "
        },
        { // F
            " ####### ",
            " #       ",
            " #       ",
            " #####   ",
            " #       ",
            " #       ",
            " #       "
        },
        { // G
            "  #####  ",
            " #     # ",
            " #       ",
            " #   ### ",
            " #     # ",
            " #     # ",
            "  #####  "
        },
        { // H
            " #     # ",
            " #     # ",
            " #     # ",
            " ####### ",
            " #     # ",
            " #     # ",
            " #     # "
        },
        { // I
            " ####### ",
            "    #    ",
            "    #    ",
            "    #    ",
            "    #    ",
            "    #    ",
            " ####### "
        },
        { // J
            " ####### ",
            "    #    ",
            "    #    ",
            "    #    ",
            " #  #    ",
            " #  #    ",
            "  ##     "
        },
        { // K
            " #    #  ",
            " #   #   ",
            " #  #    ",
            " ###     ",
            " #  #    ",
            " #   #   ",
            " #    #  "
        },
        { // L
            " #       ",
            " #       ",
            " #       ",
            " #       ",
            " #       ",
            " #       ",
            " ####### "
        },
        { // M
            " #     # ",
            " ##   ## ",
            " # # # # ",
            " #  #  # ",
            " #     # ",
            " #     # ",
            " #     # "
        },
        { // N
            " #     # ",
            " ##    # ",
            " # #   # ",
            " #  #  # ",
            " #   # # ",
            " #    ## ",
            " #     # "
        },
        { // O
            "  #####  ",
            " #     # ",
            " #     # ",
            " #     # ",
            " #     # ",
            " #     # ",
            "  #####  "
        },
        { // P
            " ######  ",
            " #     # ",
            " #     # ",
            " ######  ",
            " #       ",
            " #       ",
            " #       "
        },
        { // Q
            "  #####  ",
            " #     # ",
            " #     # ",
            " #     # ",
            " #   # # ",
            " #    #  ",
            "  #### # "
        },
        { // R
            " ######  ",
            " #     # ",
            " #     # ",
            " ######  ",
            " #   #   ",
            " #    #  ",
            " #     # "
        },
        { // S
            "  ##### ",
            " #     #",
            " #      ",
            "  ####  ",
            "      # ",
            " #    # ",
            "  ####  "
        },
        { // T
            " ####### ",
            "    #    ",
            "    #    ",
            "    #    ",
            "    #    ",
            "    #    ",
            "    #    "
        },
        { // U
            " #     # ",
            " #     # ",
            " #     # ",
            " #     # ",
            " #     # ",
            " #     # ",
            "  #####  "
        },
        { // V
            " #     # ",
            " #     # ",
            " #     # ",
            " #     # ",
            "  #   #  ",
            "   # #   ",
            "    #    "
        },
        { // W
            " #     # ",
            " #     # ",
            " #     # ",
            " #  #  # ",
            " # # # # ",
            " ##   ## ",
            " #     # "
        },
        { // X
            " #     # ",
            "  #   #  ",
            "   # #   ",
            "    #    ",
            "   # #   ",
            "  #   #  ",
            " #     # "
        },
        { // Y
            " #     # ",
            "  #   #  ",
            "   # #   ",
            "    #    ",
            "    #    ",
            "    #    ",
            "    #    "
        },
        { // Z
            " ####### ",
            "      #  ",
            "     #   ",
            "   #     ",
            "  #      ",
            " #       ",
            " ####### "
        }
    };

    public void yazdir(String metin) {
        metin = metin.toUpperCase();
        
        // Her satır için
        for (int satir = 0; satir < HARF_YUKSEKLIK; satir++) {
            // Metindeki her harf için
            for (int i = 0; i < metin.length(); i++) {
                char harf = metin.charAt(i);
                if (harf >= 'A' && harf <= 'Z') {
                    String[] harfDeseni = HARFLER[harf - 'A'];
                    String satirDeseni = harfDeseni[satir].replace("#", KARAKTER);
                    System.out.print(satirDeseni);
                    
                    // Son harf değilse boşluk ekle
                    if (i < metin.length() - 1) {
                        System.out.print(BOSLUK.repeat(BOSLUK_GENISLIK));
                    }
                } else {
                    // Tanımlanmamış karakterler için boşluk bırak
                    System.out.print(BOSLUK.repeat(HARF_GENISLIK));
                    if (i < metin.length() - 1) {
                        System.out.print(BOSLUK.repeat(BOSLUK_GENISLIK));
                    }
                }
            }
            System.out.println();
        }
    }
} 