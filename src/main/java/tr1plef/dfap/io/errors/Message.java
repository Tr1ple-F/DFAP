package tr1plef.dfap.io.errors;

public class Message {

    private static int counter = 0;

    private final String message;
    private final int args;
    private LogType type;
    private int id;

    public Message(String message, LogType type, int args) {
        this.message = message;
        this.type = type;
        this.args = args;
        this.id = counter++;
    }

    public String apply(String... arguments) {
        if (arguments.length != args) {
            // If the provided number of arguments does not match the desired amount an exception will be thrown
            throw new IllegalArgumentException();
        } else {
            // Argument requirements are met
            String currentVersion = "[" + id + "] " + type.toString() + " " + message;
            for (int i = 0; i < arguments.length; i++) {
                currentVersion = currentVersion.replaceAll("%\\[" + i + "]", arguments[i]);
            }
            return currentVersion;
        }
    }

}
