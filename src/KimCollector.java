import java.util.ArrayList;
import java.util.Scanner;

public class KimCollector {
    private final int USER_INPUT_NUM_OF_NAME = 5;
    private int kimCount;
    private final ArrayList<String> KIM_ARRAY_LIST = new ArrayList<>();
    private final ArrayList<String> NOT_KIM_ARRAY_LIST = new ArrayList<>();

    public void run() {
        displayInputMessage();
        ArrayList<String> nameList = getName();
        filter(nameList, "김");
        displayOutputMessage();
    }

    private void filter(ArrayList<String> nameList, String delimiter) {
        for (int index = 0; index < USER_INPUT_NUM_OF_NAME; index++) {
            setKimList(nameList, delimiter, kimCount, KIM_ARRAY_LIST, index);
            setNotKimList(nameList, delimiter, NOT_KIM_ARRAY_LIST,index);
        }
        if (NOT_KIM_ARRAY_LIST.size() == USER_INPUT_NUM_OF_NAME) {
            displayNotExistKim();
        }
    }

    private void displayNotExistKim() {
        System.out.println("=================================");
        System.out.println("김씨가 한명도 존재하지 않습니다.ㅠㅅㅠ");
        System.out.println("=================================");
    }

    private void setKimList(ArrayList<String> nameList, String delimiter, int kimCount, ArrayList<String> kimArrayList, int index) {
        if (nameList.get(index).substring(0, 1).equals(delimiter)) {
            kimArrayList.add(nameList.get(index));
            this.kimCount = ++kimCount;
        }
    }

    private void setNotKimList(ArrayList<String> nameList, String delimiter, ArrayList<String> notKimArrayList, int index) {
        if (!nameList.get(index).substring(0, 1).equals(delimiter)) {
            notKimArrayList.add(nameList.get(index));
        }
    }

    private ArrayList<String> getName() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();
        for (int index = 0; index < USER_INPUT_NUM_OF_NAME; index++) {
            nameList.add(scanner.next());
        }
        return nameList;
    }

    private static void displayInputMessage() {
        System.out.println("=================================");
        System.out.println("김씨 콜렉터를 사용해주셔서 감사합니다.");
        System.out.println("아무 이름 5개를 입력해 주세요.");
        System.out.println("=================================");
    }

    private void displayOutputMessage() {
        if (kimCount > 0) {
            showNumberOfKims();
        }
        if (NOT_KIM_ARRAY_LIST.size() > 0) {
            showNotKimList();
        }
    }

    private void showNotKimList() {
        System.out.println(NOT_KIM_ARRAY_LIST + "님은 김씨가 아닙니다.");
        System.out.println("=================================");
    }

    private void showNumberOfKims() {
        System.out.println("=================================");
        System.out.println("김씨는 총 " + kimCount + "명이며 " + KIM_ARRAY_LIST + "님 입니다.");
        System.out.println("=================================");
    }
}
