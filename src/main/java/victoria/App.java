import java.util.*;
import java.util.Arrays;

class FileSystem {
    
    // map to store the path and value pair
    Map<String, Integer> map;
    
    public FileSystem() {
        map = new HashMap<>();
        // add root directory
        map.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        // check if the parent directory exists
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!map.containsKey(parent)) {
            return false;
        }
        // check if the path already exists
        if (map.containsKey(path)) {
            return false;
        }
        // create the path and assign the value
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}
