import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VTwo {

    public ArrayList<JoinedVerticalPhotos> squaredVertArray = new ArrayList<JoinedVerticalPhotos>();

    public VTwo (ArrayList<Photo> V){
//        for (Photo i:V){
//            for (Photo j:V){
//                if (i!=j){
//                    merge(i,j);
//                }
//            }
//            V.remove(i);
//        }

        sort(V);

        for (int i = 0; i<V.size()-2;i=i+2){
            merge(V.get(i),V.get(i+1));
        }
    }

    public void removeAllWithID(int id){
        for (JoinedVerticalPhotos j : squaredVertArray){
            if ((j.getIds()[0] == id )||(j.getIds()[1] == id)){
                squaredVertArray.remove(j);
            }
        }
    }

    public void sort(ArrayList<Photo> V){
        Collections.sort(V, new Comparator<Photo>() {
            public int compare(Photo a, Photo b) {
                if(a.getTagCount() > b.getTagCount()) {
                    return 1;
                } else if(a.getTagCount() == b.getTagCount()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
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
