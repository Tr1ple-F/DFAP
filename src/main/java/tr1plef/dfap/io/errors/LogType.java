package tr1plef.dfap.io.errors;

public enum LogType {

    DEBUG(0),
    INFO(1),
    NOTICE(2),
    WARNING(3),
    ERROR(4),
    CRITICAL(5),
    ALERT(6),
    EMERGENCY(7);

    private int level;

    LogType(int level) {
        this.level = level;
    }

    public static LogType getTypeOf(int level) {
        return LogType.values()[level];
    }

    public int getLevel() {
        return level;
    }

}
