package SingletonPatternExample;

    public class Logger {
    // Step 1: Create a private static instance of Logger
    private static Logger instance;

    // Step 2: Make the constructor private to prevent instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Provide a public static method to get the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Sample method to simulate logging
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

    