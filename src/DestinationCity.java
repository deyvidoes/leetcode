import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("New York");
        path.add("Texas");
        List<String> path2 = new ArrayList<>();
        path2.add("Texas");
        path2.add("New Jersey");
        List<String> path3 = new ArrayList<>();
        path3.add("New Jersey");
        path3.add("Houston");
        List<String> path4 = new ArrayList<>();
        path4.add("Houston");
        path4.add("Dominican republic");
        paths.add(path);
        paths.add(path2);
        paths.add(path3);

        System.out.println("SHOULD BE HOUSTON: " + destCity(paths));
        System.out.println("SHOULD BE HOUSTON: " + destCity2(paths));
    }

    //O(n)
    public static String destCity(List<List<String>> paths) {
        Map<String, String> pathMap = new HashMap<>();
        for (var path : paths)
            pathMap.put(path.get(0), path.get(1));

        for (var destination : pathMap.values())
            if (pathMap.get(destination) == null)
                return destination;

        return null;
    }

    //O(n²)
    public static String destCity2(List<List<String>> paths) {
        List<String> from = new ArrayList<>();
        for (var path : paths)
            from.add(path.get(0));

        for (var path : paths)
            if (!from.contains(path.get(1)))
                return path.get(1);

        return null;
    }
}
