import java.util.ArrayList;
import java.util.List;

public class Photo {
    private int _id;
    private int _tagCount;
    private ArrayList<String> _tags;
    private boolean _isHorizontal;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
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

    public boolean isHorizontal() {
        return _isHorizontal;
    }

    public void setIsHorizontal(boolean _isHorizontal) {
        this._isHorizontal = _isHorizontal;
    }
}
