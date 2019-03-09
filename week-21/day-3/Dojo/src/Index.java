import java.util.List;

public class Index {

  public int findIndex(List<Object> list, Object value) {
    if (list == null) return -1;

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(value)) {
        return i;
      }
    }
    return -1;
  }

}
