import java.util.ArrayList;
import java.util.Scanner;

public class KimCollector {
    public static void run() {
        disPlayInputMessage();
        ArrayList<String> nameList = getName();
        filter(nameList, "김");
    }

    private static void filter(ArrayList<String> nameList, String delimiter) {
        for (int index = 0; index < 5; index++) {
            if (nameList.get(index).substring(0, 1).equals(delimiter)) {
                System.out.println("김씨성을 가진 사람은 " + nameList.get(index) + "입니다요.");
            }
            checkLastName(nameList, delimiter, index);
        }
    }

    private static void checkLastName(ArrayList<String> nameList, String delimiter, int index) {
        if (!nameList.get(index).substring(0, 1).equals(delimiter)) {
            System.out.println((nameList.get(index)) + "는 김씨성이 아닙니다요.");
        }
    }

    private static ArrayList<String> getName() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            nameList.add(scanner.next());
        }
        return nameList;
    }

    private static void disPlayInputMessage() {
        System.out.println("======================");
        System.out.println("김씨 콜렉터를 사용해주셔서 감사합니다.");
        System.out.println("아무 이름 5개를 입력해 주세요.");
        System.out.println("======================");
    }
}
