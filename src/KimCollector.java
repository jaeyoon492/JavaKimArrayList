import java.util.ArrayList;
import java.util.Scanner;

public class KimCollector {
    Scanner scanner = new Scanner(System.in);
    private String lastName;
    private final int USER_INPUT_NUM_OF_NAME = 5;
    private int lastNameCount;
    private final ArrayList<String> LAST_NAME_ARRAY_LIST = new ArrayList<>();
    private final ArrayList<String> NOT_USER_INPUT_LAST_NAME_ARRAY_LIST = new ArrayList<>();

    
    public void run() {
        displayInputMessage();
        ArrayList<String> nameList = getName();
        getLastName();
        filter(nameList, lastName);
        displayOutputMessage();
    }

    private void getLastName() {
        System.out.println("=================================");
        System.out.println("어떤 성씨를 골라줄까요?");
        System.out.println("=================================");
        String value = scanner.next();
        if (value.length() > 1){
            System.out.println("성씨는 한글자 까지만 허용됩니다.");
            System.out.println("다시 입력해주세요.");
            System.out.println("=================================");
            getLastName();
        } else {
            this.lastName = value;
        }
    }

    private void filter(ArrayList<String> nameList, String delimiter) {
        for (int index = 0; index < USER_INPUT_NUM_OF_NAME; index++) {
            setKimList(nameList, delimiter, lastNameCount, LAST_NAME_ARRAY_LIST, index);
            setNotKimList(nameList, delimiter, NOT_USER_INPUT_LAST_NAME_ARRAY_LIST, index);
        }
        if (NOT_USER_INPUT_LAST_NAME_ARRAY_LIST.size() == USER_INPUT_NUM_OF_NAME) {
            displayNotExistKim();
        }
    }

    private void displayNotExistKim() {
        System.out.println("=================================");
        System.out.println(lastName+"씨가 한명도 존재하지 않습니다.ㅠㅅㅠ");
        System.out.println("=================================");
    }

    private void setKimList(ArrayList<String> nameList, String delimiter, int kimCount, ArrayList<String> kimArrayList, int index) {
        if (nameList.get(index).substring(0, 1).equals(delimiter)) {
            kimArrayList.add(nameList.get(index));
            this.lastNameCount = ++kimCount;
        }
    }

    private void setNotKimList(ArrayList<String> nameList, String delimiter, ArrayList<String> notKimArrayList, int index) {
        if (!nameList.get(index).substring(0, 1).equals(delimiter)) {
            notKimArrayList.add(nameList.get(index));
        }
    }

    private ArrayList<String> getName() {
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
        if (lastNameCount > 0) {
            showNumberOfKims();
        }
        if (NOT_USER_INPUT_LAST_NAME_ARRAY_LIST.size() > 0) {
            showNotKimList();
        }
    }

    private void showNotKimList() {
        System.out.println(NOT_USER_INPUT_LAST_NAME_ARRAY_LIST + "님은 " + lastName + "씨가 아닙니다.");
        System.out.println("=================================");
    }

    private void showNumberOfKims() {
        System.out.println("=================================");
        System.out.println(lastName + "씨는 총 " + lastNameCount + "명이며 " + LAST_NAME_ARRAY_LIST + "님 입니다.");
        System.out.println("=================================");
    }
}
