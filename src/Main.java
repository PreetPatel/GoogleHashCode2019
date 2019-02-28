import java.io.File;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Photo> HorizontalPhotos = new ArrayList<>();
    public static ArrayList<Photo> VerticalPhotos = new ArrayList<>();

    public static ArrayList<Slide> Slideshow = new ArrayList<>();

    public static void main(String[] args) {
        FileParser fileParser = new FileParser(new File("src/Inputs/b_lovely_landscapes.txt"));
        ArrayList<Photo> photosCollection = fileParser.parseFile();
    }

    public static int getInterestingScore(ArrayList<String> p1tags, ArrayList<String> p2tags) {

        ArrayList<String> firstPhotoTags = new ArrayList<>(p1tags);
        ArrayList<String> secondPhotoTags = new ArrayList<>(p2tags);

        int same = 0;

        for(String tag: firstPhotoTags) {
            if(secondPhotoTags.contains(tag)){
                same++;
                firstPhotoTags.remove(tag);
                secondPhotoTags.remove(tag);
            }
        }

        return Math.min(Math.min(same, secondPhotoTags.size()), firstPhotoTags.size());
    }
}
