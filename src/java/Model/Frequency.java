package Model;

public class Frequency {
    private int id;
    private String freq_name;

    public Frequency() {}
    public Frequency(int id, String freq_name) {
        this.id = id;
        this.freq_name = freq_name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFreq_name() { return freq_name; }
    public void setFreq_name(String freq_name) { this.freq_name = freq_name; }
}