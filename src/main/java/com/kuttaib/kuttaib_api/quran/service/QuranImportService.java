package com.kuttaib.kuttaib_api.quran.service;

import com.kuttaib.kuttaib_api.quran.dto.ApiResponse;
import com.kuttaib.kuttaib_api.quran.dto.AyahResponse;
import com.kuttaib.kuttaib_api.quran.dto.JuzJson;
import com.kuttaib.kuttaib_api.quran.dto.QuranPageJson;
import com.kuttaib.kuttaib_api.quran.dto.SurahResponse;
import com.kuttaib.kuttaib_api.quran.entity.Ayah;
import com.kuttaib.kuttaib_api.quran.entity.Juz;
import com.kuttaib.kuttaib_api.quran.entity.QuranPage;
import com.kuttaib.kuttaib_api.quran.entity.Surah;
import com.kuttaib.kuttaib_api.quran.repository.AyahRepository;
import com.kuttaib.kuttaib_api.quran.repository.JuzRepository;
import com.kuttaib.kuttaib_api.quran.repository.QuranPageRepository;
import com.kuttaib.kuttaib_api.quran.repository.SurahRepository;
import lombok.RequiredArgsConstructor;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.core.type.TypeReference;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class QuranImportService {

    private final SurahRepository surahRepository;
    private final AyahRepository ayahRepository;
    private final JuzRepository juzRepository;
    private final QuranPageRepository quranPageRepository;

    private final RestClient restClient =
            RestClient.create();

    @Transactional
    public void importSurah(
            Integer surahNumber
    ) {

        ApiResponse<SurahResponse> response =
                restClient.get()
                        .uri(
                                "https://equran.id/api/v2/surat/"
                                        + surahNumber
                        )
                        .retrieve()
                        .body(
                                new ParameterizedTypeReference<>() {
                                }
                        );

        if (response == null ||
                response.getData() == null) {
            return;
        }

        SurahResponse data =
                response.getData();

        if (
                surahRepository
                        .findByNumber(
                                data.getNomor()
                        )
                        .isPresent()
        ) {
            return;
        }

        Surah surah =
                Surah.builder()
                        .number(data.getNomor())
                        .arabicName(data.getNama())
                        .latinName(data.getNamaLatin())
                        .meaning(data.getArti())
                        .revelationPlace(
                                data.getTempatTurun()
                        )
                        .verseCount(
                                data.getJumlahAyat()
                        )
                        .description(
                                data.getDeskripsi()
                        )
                        .build();

        surah = surahRepository.save(
                surah
        );

        for (AyahResponse ayahData :
                data.getAyat()) {

            Ayah ayah =
                    Ayah.builder()
                            .surah(surah)
                            .verseNumber(
                                    ayahData.getNomorAyat()
                            )
                            .arabicText(
                                    ayahData.getTeksArab()
                            )
                            .latinText(
                                    ayahData.getTeksLatin()
                            )
                            .indonesianText(
                                    ayahData.getTeksIndonesia()
                            )
                            .audio01(
                                    ayahData.getAudio().get("01")
                            )
                            .audio02(
                                    ayahData.getAudio().get("02")
                            )
                            .audio03(
                                    ayahData.getAudio().get("03")
                            )
                            .audio04(
                                    ayahData.getAudio().get("04")
                            )
                            .audio05(
                                    ayahData.getAudio().get("05")
                            )
                            .audio06(
                                    ayahData.getAudio().get("06")
                            )
                            .build();

            ayahRepository.save(
                    ayah
            );
        }
    }

    @Transactional
    public void importAll() throws Exception {

        for (int i = 1; i <= 114; i++) {

            try {

                System.out.println(
                        "Importing Surah " + i
                );

                importSurah(i);

                System.out.println(
                        "Success Surah " + i
                );

            } catch (Exception ex) {

                System.out.println(
                        "Failed Surah " + i
                );

                ex.printStackTrace();
            }

            Thread.sleep(200);
        }
    }

    @Transactional
    public void importJuzs() throws Exception {

        if (juzRepository.count() > 0) {

            System.out.println(
                    "Juz already imported"
            );

            return;
        }

        Resource resource =
                new ClassPathResource(
                        "quran/Juzs.json"
                );

        String json =
                new String(
                        resource
                                .getInputStream()
                                .readAllBytes(),
                        StandardCharsets.UTF_8
                );

        ObjectMapper mapper =
                new ObjectMapper();

        List<JuzJson> juzList =
                mapper.readValue(
                        json,
                        new TypeReference<List<JuzJson>>() {}
                );

        int juzNumber = 1;

        for (JuzJson item : juzList) {

            Surah startSurah =
                    surahRepository
                            .findByNumber(
                                    item.getStartSurah()
                            )
                            .orElseThrow();

            Surah endSurah =
                    surahRepository
                            .findByNumber(
                                    item.getEndSurah()
                            )
                            .orElseThrow();

            Juz juz =
                    Juz.builder()
                            .number(juzNumber++)
                            .startSurah(startSurah)
                            .startAyahNumber(
                                    item.getStartAyah()
                            )
                            .endSurah(endSurah)
                            .endAyahNumber(
                                    item.getEndAyah()
                            )
                            .startPage(
                                    item.getStartPage()
                            )
                            .endPage(
                                    item.getEndPage()
                            )
                            .totalVerseCount(
                                    calculateTotalVerseCount(item)
                            )
                            .build();

            juzRepository.save(juz);
        }

        System.out.println(
                "All Juz Imported"
        );
    }

    private Integer calculateTotalVerseCount(
            JuzJson item
    ) {

        if (
                item.getStartSurah().equals(
                        item.getEndSurah()
                )
        ) {

            return item.getEndAyah()
                    - item.getStartAyah()
                    + 1;
        }

        int total = 0;

        for (
                int surahNumber = item.getStartSurah();
                surahNumber <= item.getEndSurah();
                surahNumber++
        ) {

            Surah surah =
                    surahRepository
                            .findByNumber(surahNumber)
                            .orElseThrow();

            if (
                    surahNumber ==
                            item.getStartSurah()
            ) {

                total +=
                        surah.getVerseCount()
                                - item.getStartAyah()
                                + 1;

            } else if (
                    surahNumber ==
                            item.getEndSurah()
            ) {

                total += item.getEndAyah();

            } else {

                total += surah.getVerseCount();
            }
        }

        return total;
    }

    @Transactional
    public void importPages() throws Exception {

        if (quranPageRepository.count() > 0) {

            System.out.println(
                    "Pages already imported"
            );

            return;
        }

        Resource resource =
                new ClassPathResource(
                        "quran/Pages.json"
                );

        String json =
                new String(
                        resource
                                .getInputStream()
                                .readAllBytes(),
                        StandardCharsets.UTF_8
                );

        ObjectMapper mapper =
                new ObjectMapper();

        List<QuranPageJson> pages =
                mapper.readValue(
                        json,
                        new TypeReference<
                                List<QuranPageJson>
                                >() {}
                );

        for (QuranPageJson item : pages) {

            Surah startSurah =
                    surahRepository
                            .findByNumber(
                                    item.getStartSurah()
                            )
                            .orElseThrow();

            Surah endSurah =
                    surahRepository
                            .findByNumber(
                                    item.getEndSurah()
                            )
                            .orElseThrow();

            QuranPage page =
                    QuranPage.builder()
                            .pageNumber(
                                    item.getPage()
                            )
                            .startSurah(
                                    startSurah
                            )
                            .startAyah(
                                    item.getStartAyah()
                            )
                            .endSurah(
                                    endSurah
                            )
                            .endAyah(
                                    item.getEndAyah()
                            )
                            .juzNumber(
                                    item.getSection()
                            )
                            .build();

            quranPageRepository.save(
                    page
            );
        }

        System.out.println(
                "All Pages Imported"
        );
    }
}