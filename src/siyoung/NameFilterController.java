package siyoung;

import java.util.List;
import java.util.Scanner;

public class NameFilterController {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        String userInputNames = getUserInputNames();
        List<String> userNames = StringParser.split(userInputNames, ",");
        String lastNameCondition = getLastNameCondition(userInputNames);

        NameFilter nameFilter = new NameFilter(userNames);
        List<String> filteredNames = nameFilter.filter(lastNameCondition);

        displayResult(filteredNames);
    }

    private void displayResult(List<String> filteredNames) {
        System.out.println("==========================");
        System.out.println(filteredNames);
        System.out.println("==========================");
    }

    private String getLastNameCondition(String userInputNames) {
        System.out.println("==============================");
        System.out.println("입력하신 사용자는, " + userInputNames + "입니다.");
        System.out.println("어떤 성씨를 가진 사람을 찾고 싶으세요?");
        System.out.println("==============================");

        return scanner.nextLine();
    }

    private String getUserInputNames() {
        System.out.println("==============================");
        System.out.println("사용자 이름을 ,를 기준으로 입력해주세요.");
        System.out.println("==============================");

        return scanner.nextLine();
    }
}