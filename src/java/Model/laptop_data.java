/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Entity class for laptop_data table
 * * @author ADMIN
 */
public class laptop_data {

    private int id;
    private String laptop_name;
    private String brand;
    private long price_vnd;
    private String price_segment;
    private String cpu_class;
    private String cpu_technology;
    private String gpu_type;
    private String screen_size;
    private String refresh_rate;
    private String os;
    private String target_category;
    private int cpu_score;
    private int ram_gb;
    private int gpu_encoded;
    private int storage_gb;
    private double screen_size_num;
    private double battery_wh;
    private int refresh_rate_score;
    private int os_encoded;
    private int performance_score;
    private String future_compatibility_level;
    private double value_score;
    private String market_popularity;

    // 1. Constructor rỗng (Bắt buộc cho nhiều framework)
    public laptop_data() {
    }

    // 2. Constructor đầy đủ tất cả các trường (Dùng khi lấy dữ liệu từ Database ra)
    public laptop_data(int id, String laptop_name, String brand, long price_vnd, String price_segment, String cpu_class, String cpu_technology, String gpu_type, String screen_size, String refresh_rate, String os, String target_category, int cpu_score, int ram_gb, int gpu_encoded, int storage_gb, double screen_size_num, double battery_wh, int refresh_rate_score, int os_encoded, int performance_score, String future_compatibility_level, double value_score, String market_popularity) {
        this.id = id;
        this.laptop_name = laptop_name;
        this.brand = brand;
        this.price_vnd = price_vnd;
        this.price_segment = price_segment;
        this.cpu_class = cpu_class;
        this.cpu_technology = cpu_technology;
        this.gpu_type = gpu_type;
        this.screen_size = screen_size;
        this.refresh_rate = refresh_rate;
        this.os = os;
        this.target_category = target_category;
        this.cpu_score = cpu_score;
        this.ram_gb = ram_gb;
        this.gpu_encoded = gpu_encoded;
        this.storage_gb = storage_gb;
        this.screen_size_num = screen_size_num;
        this.battery_wh = battery_wh;
        this.refresh_rate_score = refresh_rate_score;
        this.os_encoded = os_encoded;
        this.performance_score = performance_score;
        this.future_compatibility_level = future_compatibility_level;
        this.value_score = value_score;
        this.market_popularity = market_popularity;
    }

    // 3. Constructor không có ID (Dùng khi thêm mới dữ liệu vào Database vì ID tự động tăng)
    public laptop_data(String laptop_name, String brand, long price_vnd, String price_segment, String cpu_class, String cpu_technology, String gpu_type, String screen_size, String refresh_rate, String os, String target_category, int cpu_score, int ram_gb, int gpu_encoded, int storage_gb, double screen_size_num, double battery_wh, int refresh_rate_score, int os_encoded, int performance_score, String future_compatibility_level, double value_score, String market_popularity) {
        this.laptop_name = laptop_name;
        this.brand = brand;
        this.price_vnd = price_vnd;
        this.price_segment = price_segment;
        this.cpu_class = cpu_class;
        this.cpu_technology = cpu_technology;
        this.gpu_type = gpu_type;
        this.screen_size = screen_size;
        this.refresh_rate = refresh_rate;
        this.os = os;
        this.target_category = target_category;
        this.cpu_score = cpu_score;
        this.ram_gb = ram_gb;
        this.gpu_encoded = gpu_encoded;
        this.storage_gb = storage_gb;
        this.screen_size_num = screen_size_num;
        this.battery_wh = battery_wh;
        this.refresh_rate_score = refresh_rate_score;
        this.os_encoded = os_encoded;
        this.performance_score = performance_score;
        this.future_compatibility_level = future_compatibility_level;
        this.value_score = value_score;
        this.market_popularity = market_popularity;
    }

    // --- GETTERS & SETTERS ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaptop_name() {
        return laptop_name;
    }

    public void setLaptop_name(String laptop_name) {
        this.laptop_name = laptop_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getPrice_vnd() {
        return price_vnd;
    }

    public void setPrice_vnd(long price_vnd) {
        this.price_vnd = price_vnd;
    }

    public String getPrice_segment() {
        return price_segment;
    }

    public void setPrice_segment(String price_segment) {
        this.price_segment = price_segment;
    }

    public String getCpu_class() {
        return cpu_class;
    }

    public void setCpu_class(String cpu_class) {
        this.cpu_class = cpu_class;
    }

    public String getCpu_technology() {
        return cpu_technology;
    }

    public void setCpu_technology(String cpu_technology) {
        this.cpu_technology = cpu_technology;
    }

    public String getGpu_type() {
        return gpu_type;
    }

    public void setGpu_type(String gpu_type) {
        this.gpu_type = gpu_type;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getRefresh_rate() {
        return refresh_rate;
    }

    public void setRefresh_rate(String refresh_rate) {
        this.refresh_rate = refresh_rate;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getTarget_category() {
        return target_category;
    }

    public void setTarget_category(String target_category) {
        this.target_category = target_category;
    }

    public int getCpu_score() {
        return cpu_score;
    }

    public void setCpu_score(int cpu_score) {
        this.cpu_score = cpu_score;
    }

    public int getRam_gb() {
        return ram_gb;
    }

    public void setRam_gb(int ram_gb) {
        this.ram_gb = ram_gb;
    }

    public int getGpu_encoded() {
        return gpu_encoded;
    }

    public void setGpu_encoded(int gpu_encoded) {
        this.gpu_encoded = gpu_encoded;
    }

    public int getStorage_gb() {
        return storage_gb;
    }

    public void setStorage_gb(int storage_gb) {
        this.storage_gb = storage_gb;
    }

    public double getScreen_size_num() {
        return screen_size_num;
    }

    public void setScreen_size_num(double screen_size_num) {
        this.screen_size_num = screen_size_num;
    }

    public double getBattery_wh() {
        return battery_wh;
    }

    public void setBattery_wh(double battery_wh) {
        this.battery_wh = battery_wh;
    }

    public int getRefresh_rate_score() {
        return refresh_rate_score;
    }

    public void setRefresh_rate_score(int refresh_rate_score) {
        this.refresh_rate_score = refresh_rate_score;
    }

    public int getOs_encoded() {
        return os_encoded;
    }

    public void setOs_encoded(int os_encoded) {
        this.os_encoded = os_encoded;
    }

    public int getPerformance_score() {
        return performance_score;
    }

    public void setPerformance_score(int performance_score) {
        this.performance_score = performance_score;
    }

    public String getFuture_compatibility_level() {
        return future_compatibility_level;
    }

    public void setFuture_compatibility_level(String future_compatibility_level) {
        this.future_compatibility_level = future_compatibility_level;
    }

    public double getValue_score() {
        return value_score;
    }

    public void setValue_score(double value_score) {
        this.value_score = value_score;
    }

    public String getMarket_popularity() {
        return market_popularity;
    }

    public void setMarket_popularity(String market_popularity) {
        this.market_popularity = market_popularity;
    }
}