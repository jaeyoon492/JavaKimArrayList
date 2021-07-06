import java.util.ArrayList;
import java.util.Scanner;

public class KimCollector {
    public static void run() {
        disPlayInputMessage();
        ArrayList<String> nameList = getName();
        FiteredKim(nameList);
    }

    private static void FiteredKim(ArrayList<String> nameList) {
        for (int index = 0; index < 5; index++) {
            if (nameList.get(index).contains("김")) {
                System.out.println(nameList.get(index));
            }
        }
    }

    private static ArrayList<String> getName() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        for (int index = 0; index < 5; index++) {
            nameList.add(scanner.next());
        }
        if (!nameList.contains("김")) {
            System.out.println("김씨성의 이름이 하나도 없습니다.");
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
