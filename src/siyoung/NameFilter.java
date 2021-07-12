package siyoung;

import java.util.ArrayList;
import java.util.List;

public class NameFilter {
    private final List<String> userNames;

    public NameFilter(List<String> userNames) {
        this.userNames = userNames;
    }

    public List<String> filter(String delimiter) {
        List<String> filteredNames = new ArrayList<>();

        for (String userName : userNames) {
            String lastName = userName.substring(0, 1);
            if (lastName.equals(delimiter)) {
                filteredNames.add(userName);
            }
        }

        return filteredNames;
    }
}