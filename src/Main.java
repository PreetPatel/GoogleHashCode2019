import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileParser fileParser = new FileParser(new File("src/Inputs/a_example.txt"));
        ArrayList<Photo> photosCollection = fileParser.parseFile();

        for (int i = 0; i < photosCollection.size(); i++) {
            Photo photo = photosCollection.get(i);
            System.out.println("---------------------------------------------");
            System.out.println("ID: " + photo.getId());
            System.out.println("Tag Count : " + photo.getTagCount() + " And Actual Count: " + photo.getTags().size());
            System.out.println("isHorizontal : " + photo.isHorizontal());

            ArrayList<String> tags = photo.getTags();

            System.out.println("    ------Tags-------");
            for (String tag: tags
                 ) {

                System.out.println("    " + tag);
            }


        }
    }
}
