import java.util.ArrayList;

public class Slide {

    private String printout;
    private ArrayList<String> tags;

    public Slide(JoinedVerticalPhotos jVPhotos) {
        tags = jVPhotos.getTags();
        int[] ids = jVPhotos.getIds();
        printout = ids[0] + " " + ids[1];
    }

    public Slide(Photo photo) {
        tags = photo.getTags();
        printout = Integer.toString(photo.getId());
    }

    public ArrayList<String> getTag() {
        return tags;
    }

    public String getPrintout() {
        return printout;
    }
}
