import java.io.File;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Photo> HorizontalPhotos;
    public static ArrayList<Photo> VerticalPhotos;

    public static void main(String[] args) {
        FileParser fileParser = new FileParser(new File("src/Inputs/b_lovely_landscapes.txt"));
        ArrayList<Photo> photosCollection = fileParser.parseFile();
    }
}
