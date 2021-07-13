import java.util.ArrayList;
import java.util.Scanner;

public class LastNameCollector {
    Scanner scanner = new Scanner(System.in);
    private String lastName;
    private final int USER_INPUT_NUM_OF_NAME = 5;
    private int lastNameCount;
    private final ArrayList<String> USER_PICK_LAST_NAME_ARRAY_LIST = new ArrayList<>();
    private final ArrayList<String> NOT_USER_PICK_LAST_NAME_ARRAY_LIST = new ArrayList<>();
    
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
        String userInput = scanner.next();
        if (userInput.length() > 1) {
            System.out.println("성씨는 한글자 까지만 허용됩니다.");
            System.out.println("다시 입력해주세요.");
            System.out.println("=================================");
            getLastName();
        } else {
            this.lastName = userInput;
        }
    }

    private void filter(ArrayList<String> nameList, String delimiter) {
        for (int index = 0; index < USER_INPUT_NUM_OF_NAME; index++) {
            setUserPickLastNameList(nameList, delimiter, lastNameCount, USER_PICK_LAST_NAME_ARRAY_LIST, index);
            setNotUserPickLastNameList(nameList, delimiter, NOT_USER_PICK_LAST_NAME_ARRAY_LIST, index);
        }
        if (NOT_USER_PICK_LAST_NAME_ARRAY_LIST.size() == USER_INPUT_NUM_OF_NAME) {
            displayNotExistUserPickLastName();
        }
    }

    private void displayNotExistUserPickLastName() {
        System.out.println("=================================");
        System.out.println(lastName + "씨가 한명도 존재하지 않습니다.ㅠㅅㅠ");
        System.out.println("=================================");
    }

    private void setUserPickLastNameList(ArrayList<String> nameList, String delimiter, int lastNameCount, ArrayList<String> userPickArrayList, int index) {
        if (nameList.get(index).substring(0, 1).equals(delimiter)) {
            userPickArrayList.add(nameList.get(index));
            this.lastNameCount = ++lastNameCount;
        }
    }

    private void setNotUserPickLastNameList(ArrayList<String> nameList, String delimiter, ArrayList<String> notUserPickArrayList, int index) {
        if (!nameList.get(index).substring(0, 1).equals(delimiter)) {
            notUserPickArrayList.add(nameList.get(index));
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
        System.out.println("Lastname Filter를 사용해주셔서 감사합니다.");
        System.out.println("아무 이름 5개를 입력해 주세요.");
        System.out.println("=================================");
    }

    private void displayOutputMessage() {
        if (lastNameCount > 0) {
            displayNumberOfUserPickLastName();
        }
        if (NOT_USER_PICK_LAST_NAME_ARRAY_LIST.size() > 0) {
            displayNotUserPickLastNameList();
        }
    }

    private void displayNotUserPickLastNameList() {
        System.out.println(NOT_USER_PICK_LAST_NAME_ARRAY_LIST + "님은 " + lastName + "씨가 아닙니다.");
        System.out.println("=================================");
    }

    private void displayNumberOfUserPickLastName() {
        System.out.println("=================================");
        System.out.println(lastName + "씨는 총 " + lastNameCount + "명이며 " + USER_PICK_LAST_NAME_ARRAY_LIST + "님 입니다.");
        System.out.println("=================================");
    }
}
