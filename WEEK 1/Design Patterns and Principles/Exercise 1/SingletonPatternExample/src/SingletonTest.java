public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();

        Logger logger2 = Logger.getInstance();

        Logger logger3 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");
        logger3.log("Application Closed");

        System.out.println(logger1.hashCode());
        System.out.println(logger2.hashCode());
        System.out.println(logger3.hashCode());

    }
}