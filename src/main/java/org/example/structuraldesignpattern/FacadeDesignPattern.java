package org.example.structuraldesignpattern;

/*
https://www.geeksforgeeks.org/facade-design-pattern-introduction/
https://www.baeldung.com/java-facade-pattern
https://www.tutorialspoint.com/design_pattern/facade_pattern.htm
 */

interface IMediaConverter{

    void convert();
}

class Mp4Converter implements IMediaConverter{

    @Override
    public void convert() {
        System.out.println("Convert mp4 video to mp3");
    }
}

class ThreeGpConverter implements IMediaConverter{

    @Override
    public void convert() {
        System.out.println("Convert 3gp video to mp3");
    }
}

class HdVideoConverter implements IMediaConverter{

    @Override
    public void convert() {
        System.out.println("Convert hd video to mp3");
    }
}

class MediaConverter{

    private final Mp4Converter mp4Converter;
    private final ThreeGpConverter threeGpConverter;
    private final HdVideoConverter hdVideoConverter;

    public MediaConverter() {
        this.mp4Converter = new Mp4Converter();
        this.threeGpConverter = new ThreeGpConverter();
        this.hdVideoConverter = new HdVideoConverter();
    }

    public void convertMp4(){
        mp4Converter.convert();
    }

    public void convert3gp(){
        threeGpConverter.convert();
    }

    public void convertHd(){
        hdVideoConverter.convert();
    }
}

public class FacadeDesignPattern {

    public static void main(String[] args) {
        MediaConverter converter = new MediaConverter();
        converter.convertMp4();
        converter.convert3gp();
        converter.convertHd();
    }
}
