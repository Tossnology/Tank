import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static Properties props = new Properties();

    private PropertyMgr() {};

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt((String) props.get(key));
    }

    public static void main(String[] args) {
        System.out.println(props.get("initTankCount"));
    }
}
