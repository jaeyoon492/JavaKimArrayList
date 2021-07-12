package siyoung;

public class Application {
    private static final NameFilterController nameFilterController = new NameFilterController();

    public static void main(String[] args) {
        nameFilterController.run();
    }
}