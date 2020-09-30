package tr1plef.dfap.io.console;

import tr1plef.dfap.io.errors.Message;

public class Console {

    public static void message(Message m, String... arguments) {
        System.out.println(m.apply(arguments));
    }

}
