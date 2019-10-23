package ee.taltech.iti0202.logger.level;
public final class Level {

    String name;
    int value;
    Level level;
    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);
    public static final Level SEVERE = new Level("SEVERE", 800);
    public static final Level ERROR = new Level("ERROR", 700);
    public static final Level WARNING = new Level("WARNING", 500);
    public static final Level INFO = new Level("INFO", 400);
    public static final Level DEBUG = new Level("DEBUG", 300);
    public static final Level ALL = new Level("ALL", Integer.MIN_VALUE);

    private Level(String name, int value) {
        this.name = name;
        this.value = value;
        switch (name) {
            case "SEVERE":
                this.level = SEVERE;
                break;
            case "ERROR":
                this.level = ERROR;
                break;
            case "WARNING":
                this.level = WARNING;
                break;
            case "INFO":
                this.level = INFO;
                break;
            case "DEBUG":
                this.level = DEBUG;
                break;
            case "ALL":
                this.level = ALL;
                break;
            default:
                this.level = OFF;
        }

    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public Level getlevel() {
        return this.level;
    }

}
