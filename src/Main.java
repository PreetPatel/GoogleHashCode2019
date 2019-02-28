import java.io.File;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Photo> HorizontalPhotos = new ArrayList<>();
    public static ArrayList<Photo> VerticalPhotos = new ArrayList<>();

    public static void main(String[] args) {
        FileParser fileParser = new FileParser(new File("src/Inputs/b_lovely_landscapes.txt"));
        ArrayList<Photo> photosCollection = fileParser.parseFile();
    }

    public static int getInterestingScore(ArrayList<String> firstPhotoTags, ArrayList<String> secondPhotoTags) {
        int same = 0;
        int notSame = 0;

        for(String tag: firstPhotoTags) {
            if(secondPhotoTags.contains(tag)){
                same++;
            } else {
                notSame++;
            }
            secondPhotoTags.remove(tag);
        }

        return Math.min(same, notSame);
    }
}
