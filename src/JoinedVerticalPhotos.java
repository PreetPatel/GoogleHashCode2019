import java.util.ArrayList;

public class JoinedVerticalPhotos {
    private int[] _ids = new int[2];
    private int _tagCount;
    private ArrayList<String> _tags;

    public int[] getIds() {
        return _ids;
    }

    public void setIds(int[] _ids) {
        this._ids = _ids;
    }

    public int getTagCount() {
        return _tagCount;
    }

    public void setTagCount(int _tagCount) {
        this._tagCount = _tagCount;
    }

    public ArrayList<String> getTags() {
        return _tags;
    }

    public void setTags(ArrayList<String> _tags) {
        this._tags = _tags;
    }

}
