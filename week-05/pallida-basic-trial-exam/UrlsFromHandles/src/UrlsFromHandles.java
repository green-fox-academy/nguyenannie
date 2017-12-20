import java.util.ArrayList;
import java.util.List;

public class UrlsFromHandles {
    List<String> urlsFromHandles(List<String> handleList) {
        List<String> result = new ArrayList<>();
        for(String handle:handleList) {
            result.add("https://github.com/greenfox-academy/" + handle);
        }
        return result;
    }
}
