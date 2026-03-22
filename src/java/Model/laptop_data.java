package Model;

import com.google.gson.annotations.SerializedName;

public class laptop_data {
    private int id;

    @SerializedName("Laptop_Name")
    private String laptop_name;

    @SerializedName("Brand")
    private String brand;

    @SerializedName("Price_VND")
    private long price_vnd;

    @SerializedName("Price_Segment")
    private String price_segment;

    @SerializedName("CPU_Class")
    private String cpu_class;

    @SerializedName("CPU_Technology")
    private String cpu_technology;

    @SerializedName("GPU_Type")
    private String gpu_type;

    @SerializedName("Screen_Size")
    private String screen_size;

    @SerializedName("Refresh_Rate")
    private String refresh_rate;

    @SerializedName("OS")
    private String os;

    @SerializedName("Target_Category")
    private String target_category;

    @SerializedName("CPU_Score")
    private int cpu_score;

    @SerializedName("RAM_GB")
    private int ram_gb;

    @SerializedName("GPU_Encoded")
    private int gpu_encoded;

    @SerializedName("Storage_GB")
    private int storage_gb;

    @SerializedName("Screen_Size_Num")
    private double screen_size_num;

    @SerializedName("Battery_Wh")
    private double battery_wh;

    @SerializedName("Refresh_Rate_Score")
    private int refresh_rate_score;

    @SerializedName("OS_Encoded")
    private int os_encoded;

    @SerializedName("Performance_Score")
    private int performance_score;

    @SerializedName("Future_Compatibility_Level")
    private String future_compatibility_level;

    @SerializedName("Value_Score")
    private double value_score;

    @SerializedName("Market_Popularity")
    private String market_popularity;
    
    // Lưu ý: Trong ảnh Terminal của bạn, Python trả về là "Độ_Tương_Đồng_(%)" 
    // Nếu Flask trả về đúng tên đó, ta map như sau:
    @SerializedName("Similarity_Score") 
    private double similarity_score; 

    public laptop_data() {}

    // --- GETTERS & SETTERS ---
    // Giữ nguyên tên Method như cũ để không làm hỏng file JSP và Servlet

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLaptop_name() { return laptop_name; }
    public void setLaptop_name(String laptop_name) { this.laptop_name = laptop_name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public long getPrice_vnd() { return price_vnd; }
    public void setPrice_vnd(long price_vnd) { this.price_vnd = price_vnd; }

    public String getPrice_segment() { return price_segment; }
    public void setPrice_segment(String price_segment) { this.price_segment = price_segment; }

    public String getCpu_class() { return cpu_class; }
    public void setCpu_class(String cpu_class) { this.cpu_class = cpu_class; }

    public String getCpu_technology() { return cpu_technology; }
    public void setCpu_technology(String cpu_technology) { this.cpu_technology = cpu_technology; }

    public String getGpu_type() { return gpu_type; }
    public void setGpu_type(String gpu_type) { this.gpu_type = gpu_type; }

    public String getScreen_size() { return screen_size; }
    public void setScreen_size(String screen_size) { this.screen_size = screen_size; }

    public String getRefresh_rate() { return refresh_rate; }
    public void setRefresh_rate(String refresh_rate) { this.refresh_rate = refresh_rate; }

    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }

    public String getTarget_category() { return target_category; }
    public void setTarget_category(String target_category) { this.target_category = target_category; }

    public int getCpu_score() { return cpu_score; }
    public void setCpu_score(int cpu_score) { this.cpu_score = cpu_score; }

    public int getRam_gb() { return ram_gb; }
    public void setRam_gb(int ram_gb) { this.ram_gb = ram_gb; }

    public int getGpu_encoded() { return gpu_encoded; }
    public void setGpu_encoded(int gpu_encoded) { this.gpu_encoded = gpu_encoded; }

    public int getStorage_gb() { return storage_gb; }
    public void setStorage_gb(int storage_gb) { this.storage_gb = storage_gb; }

    public double getScreen_size_num() { return screen_size_num; }
    public void setScreen_size_num(double screen_size_num) { this.screen_size_num = screen_size_num; }

    public double getBattery_wh() { return battery_wh; }
    public void setBattery_wh(double battery_wh) { this.battery_wh = battery_wh; }

    public int getRefresh_rate_score() { return refresh_rate_score; }
    public void setRefresh_rate_score(int refresh_rate_score) { this.refresh_rate_score = refresh_rate_score; }

    public int getOs_encoded() { return os_encoded; }
    public void setOs_encoded(int os_encoded) { this.os_encoded = os_encoded; }

    public int getPerformance_score() { return performance_score; }
    public void setPerformance_score(int performance_score) { this.performance_score = performance_score; }

    public String getFuture_compatibility_level() { return future_compatibility_level; }
    public void setFuture_compatibility_level(String future_compatibility_level) { this.future_compatibility_level = future_compatibility_level; }

    public double getValue_score() { return value_score; }
    public void setValue_score(double value_score) { this.value_score = value_score; }

    public String getMarket_popularity() { return market_popularity; }
    public void setMarket_popularity(String market_popularity) { this.market_popularity = market_popularity; }

    public double getSimilarity_score() { return similarity_score; }
    public void setSimilarity_score(double similarity_score) { this.similarity_score = similarity_score; }
}