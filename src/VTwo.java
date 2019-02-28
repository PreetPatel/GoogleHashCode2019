import java.util.ArrayList;
public class VTwo {

    public ArrayList<JoinedVerticalPhotos> squaredVertArray = new ArrayList<JoinedVerticalPhotos>();

    public VTwo (ArrayList<Photo> V){
        for (Photo i:V){
            for (Photo j:V){
                if (i!=j){
                    merge(i,j);
                }
            }
            V.remove(i);
        }
    }

    public void removeAllWithID(int id){
        for (JoinedVerticalPhotos j : squaredVertArray){
            if ((j.getIds()[0] == id )||(j.getIds()[1] == id)){
                squaredVertArray.remove(j);
            }
        }
    }

    public void merge(Photo i,Photo j){
        ArrayList<String> mergedTags = new ArrayList<>();

        for (String a:i.getTags()){
            mergedTags.add(a);
        }
        for (String b:j.getTags()){
            if (!(mergedTags.contains(b))){
                mergedTags.add(b);
            }
        }

        JoinedVerticalPhotos jvp = new JoinedVerticalPhotos();
        jvp.setTags(mergedTags);
        jvp.setIds( new int[]{i.getId(),j.getId()});
        jvp.setTagCount(mergedTags.size());
        squaredVertArray.add(jvp);
    }
}
