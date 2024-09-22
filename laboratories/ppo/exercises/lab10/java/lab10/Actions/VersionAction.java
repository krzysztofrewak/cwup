package lab10.Actions;

public class VersionAction {
    public String invoke(String[] parameters) {
        return "java: " + System.getProperty("java.version");
    }
}
