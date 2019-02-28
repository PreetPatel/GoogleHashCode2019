import java.io.*;
import java.util.ArrayList;

public class Main {

    public static final String inputFilePath = "src/Inputs/b_lovely_landscapes.txt";
    public static final String outputFilePath = "src/output.txt";

    public static ArrayList<Photo> HorizontalPhotos = new ArrayList<>();
    public static ArrayList<Photo> VerticalPhotos = new ArrayList<>();

    public static ArrayList<Slide> Slideshow = new ArrayList<>();

    public static void main(String[] args) {
        FileParser fileParser = new FileParser(new File(inputFilePath));
        ArrayList<Photo> photosCollection = fileParser.parseFile();

        Slideshow.add(new Slide(HorizontalPhotos.get(0)));
        HorizontalPhotos.remove(0);

        while(!HorizontalPhotos.isEmpty()) {
            populateNextSlide();
        }
    }

    public static void populateNextSlide() {
        Slide latest = Slideshow.get(Slideshow.size() - 1);
        int bestScore = 0;
        Photo bestPhoto = HorizontalPhotos.get(0);

        for(Photo photo: HorizontalPhotos) {
            int score = getInterestingScore(latest.getTag(), photo.getTags());
            if(score > bestScore) {
                bestScore = score;
                bestPhoto = photo;
            }
        }
        Slide toAdd = new Slide(bestPhoto);
        Slideshow.add(toAdd);
        HorizontalPhotos.remove(bestPhoto);
    }

    public static int getInterestingScore(ArrayList<String> p1tags, ArrayList<String> p2tags) {

        ArrayList<String> firstPhotoTags = new ArrayList<>(p1tags);
        ArrayList<String> secondPhotoTags = new ArrayList<>(p2tags);

        int same = 0;

        ArrayList<String> sameTags = new ArrayList<>();

        for(String tag: firstPhotoTags) {
            if(secondPhotoTags.contains(tag)){
                sameTags.add(tag);
            }
        }


        return Math.min(Math.min(sameTags.size(), secondPhotoTags.size() - sameTags.size()), firstPhotoTags.size() - sameTags.size());
    }

    public static void printOutputToFile() {
        File outPut = new File(outputFilePath);
        try (PrintWriter pw = new PrintWriter(outputFilePath, "UTF-8")) {
            pw.println(Slideshow.size());
            for(Slide slide : Slideshow) {
                pw.println(slide.getPrintout());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
