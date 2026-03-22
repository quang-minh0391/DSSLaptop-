package Model;

public class Environment {
    private int id;
    private String env_name;

    public Environment() {}
    public Environment(int id, String env_name) {
        this.id = id;
        this.env_name = env_name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getEnv_name() { return env_name; }
    public void setEnv_name(String env_name) { this.env_name = env_name; }
}