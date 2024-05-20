
class MyLogger {

    // l'objetcif est d'assurer que il y'a une instance unique du classe MyLogger
    // durant tout la vie de l'App
    // mais avce un accées globale aussi :

    // un attribuit de type MyLogger : final private
    final private static MyLogger instance = new MyLogger();

    // constructeur MyLogger : private
    private MyLogger() {

    }

    // get static :
    public static MyLogger getLogger() {
        return instance;
    }
}

public class App {

    public static void main(String[] args) {
        MyLogger log = MyLogger.getLogger();
    }

}
