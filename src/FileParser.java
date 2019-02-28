import java.io.*;
import java.util.ArrayList;

public class FileParser {
    private File _file;

    public FileParser(File file) {
        _file = file;
    }

    public ArrayList<Photo> parseFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(_file));

            String st;
            st = br.readLine();

            ArrayList<Photo> photos = new ArrayList<Photo>(Integer.parseInt(st));
            int id = 0;
            while ((st = br.readLine()) != null) {

                Photo photo = new Photo();
                photo.setId(id);

                String[] stringArray = st.split("\\s+");
                if (stringArray[0].equals("H")) {
                    photo.setIsHorizontal(true);
                } else {
                    photo.setIsHorizontal(false);
                }
                photo.setTagCount(Integer.parseInt(stringArray[1]));

                ArrayList<String> tags = new ArrayList<>(Integer.parseInt(stringArray[1]));

                for (int i = 2; i < stringArray.length; i++) {
                    tags.add(stringArray[i]);
                }
                photo.setTags(tags);

                // Increment ID
                id++;
                photos.add(photo);
            }
            return photos;

        } catch (FileNotFoundException e) {
            System.out.println("File cannot be read properly" + e);
            return null;
        } catch (IOException e) {
            System.out.println("File cannot be parsed properly" + e);
            return null;
        }
    }
}

