package joke;

public class B {

    // How it will handle race condition ?
    // How it will handle multi threading?
    static B instance;

    private B() {
    }

    public static B getInstace(){
        if (instance == null) {
            instance = new B();
        }
        return instance;
    }

    public void showBottomSheet(){
        System.out.println("Returned BottomSheet");
    }
}