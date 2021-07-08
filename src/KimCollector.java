import java.util.ArrayList;
import java.util.Scanner;

public class KimCollector {
    public int numberOfPeople = 5;
    private int kimCount;
    private final ArrayList<String> KIM_ARRAY_LIST = new ArrayList<>();
    private final ArrayList<String> NOT_KIM_ARRAY_LIST = new ArrayList<>();

    public void run() {
        disPlayInputMessage();
        ArrayList<String> nameList = getName();
        filter(nameList, "김");
        disPlayOutputMessage();
    }

    private void disPlayOutputMessage() {
        if (kimCount > 0) {
            showNumberOfKims();
        }
    }

    private void showNumberOfKims() {
        System.out.println("=================================");
        System.out.println("김씨는 총 " + kimCount + "명이며 " + KIM_ARRAY_LIST + "님 입니다.");
        System.out.println("=================================");
    }

    private void filter(ArrayList<String> nameList, String delimiter) {
        for (int index = 0; index < numberOfPeople; index++) {
            kimCount = getKimCount(nameList, delimiter, kimCount, KIM_ARRAY_LIST, index);
            checkLastName(nameList, delimiter, index);
        }
        notExistKim();
    }

    private void notExistKim() {
        if (NOT_KIM_ARRAY_LIST.size() == numberOfPeople) {
            System.out.println("김씨가 한명도 존재하지 않습니다.");
        }else if(NOT_KIM_ARRAY_LIST.size() > 0){
            System.out.println(NOT_KIM_ARRAY_LIST + "는 김씨가 아닙니다.");
        }
    }

    private int getKimCount(ArrayList<String> nameList, String delimiter, int kimCount, ArrayList<String> kimArrayList, int index) {
        if (nameList.get(index).substring(0, 1).equals(delimiter)) {
            kimArrayList.add(nameList.get(index));
            kimCount++;
        }
        return kimCount;
    }

    private void checkLastName(ArrayList<String> nameList, String delimiter, int index) {
        if (!nameList.get(index).substring(0, 1).equals(delimiter)) {
            NOT_KIM_ARRAY_LIST.add(nameList.get(index));
        }
    }

    private ArrayList<String> getName() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        for (int index = 0; index < numberOfPeople; index++) {
            nameList.add(scanner.next());
        }
        return nameList;
    }

    private static void disPlayInputMessage() {
        System.out.println("=================================");
        System.out.println("김씨 콜렉터를 사용해주셔서 감사합니다.");
        System.out.println("아무 이름 5개를 입력해 주세요.");
        System.out.println("=================================");
    }
}
