package com.kuttaib.kuttaib_api.quran.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SurahResponse {

    private Integer nomor;

    private String nama;

    private String namaLatin;

    private Integer jumlahAyat;

    private String tempatTurun;

    private String arti;

    private String deskripsi;

    private List<AyahResponse> ayat;
}