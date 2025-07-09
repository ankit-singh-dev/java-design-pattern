package org.example.structuraldesignpattern;

/*
Adapter design pattern is one of the structural design pattern and its used so that two unrelated
interfaces can work together. The object, that joins these unrelated interfaces, is called an Adapter.
 */

/*
https://www.baeldung.com/java-adapter-pattern
https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm#
https://www.geeksforgeeks.org/adapter-pattern/
 */

/*
in java Arrays.asList uses adapter design pattern
 */

/*
generate korean movies subtitle using adapter design pattern
 */

import java.util.*;

// korean movies player interface
interface KoreanMediaPlayer{
    void playKoreanMovies(String fileName);
}

// korean movies player implementation
class KoreanMediaPlayerImpl implements KoreanMediaPlayer{

    @Override
    public void playKoreanMovies(String fileName) {
        System.out.println("Playing korean movie "+fileName);
    }
}

// english movies player interface
interface EnglishMediaPlayer{
    void playEnglishMedia(String fileName);
}

// english movies player implementation
class EnglishMediaPlayerImpl implements EnglishMediaPlayer{

    @Override
    public void playEnglishMedia(String fileName) {
        System.out.println("Playing English movie "+fileName);
    }
}

// Generates english subtitle for koran movies
class AdapterClass implements KoreanMediaPlayer{

    private final KoreanMediaPlayer koreanMediaPlayer;
    private Map<String,String> subtitleMap;

    public AdapterClass(KoreanMediaPlayer koreanMediaPlayer) {
        this.koreanMediaPlayer = koreanMediaPlayer;
        initializeSubtitleMap();
    }

    private void initializeSubtitleMap(){
        subtitleMap = new HashMap<>();
        subtitleMap.put("안녕하세요","Hello");
        subtitleMap.put("안녕히 계세요","Bye");
    }

    private List<String> convertKoreanMoviesToEnglish(String fileName){
        // some logic to generate korean movie subtitle
        List<String> subtitles = new ArrayList<>();
        for(String str : subtitleMap.values()){
            subtitles.add(str);
        }
        return subtitles;
    }

    @Override
    public void playKoreanMovies(String fileName) {
        List<String> subtitles = convertKoreanMoviesToEnglish(fileName);
        System.out.println("Playing korean movie "+fileName+ " with english subtitles");
        System.out.println("Subtitles are");
        subtitles.forEach(System.out::println);
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        KoreanMediaPlayer koreanMediaPlayer = new KoreanMediaPlayerImpl();
        koreanMediaPlayer.playKoreanMovies("train to busan");

        EnglishMediaPlayer englishMediaPlayer = new EnglishMediaPlayerImpl();
        englishMediaPlayer.playEnglishMedia("inception");

        KoreanMediaPlayer koreanMediaPlayerAdapter = new AdapterClass(koreanMediaPlayer);
        koreanMediaPlayerAdapter.playKoreanMovies("train to busan");

    }
}
