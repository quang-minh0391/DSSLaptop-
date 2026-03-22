/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Entity class for target_category table
 * @author ADMIN
 */
public class target_category {
    
    private int id;
    private String category_name;

    // 1. Constructor rỗng
    public target_category() {
    }

    // 2. Constructor đầy đủ (Dùng khi lấy dữ liệu từ DB)
    public target_category(int id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    // 3. Constructor không có ID (Dùng khi insert dữ liệu mới vì ID tự động tăng)
    public target_category(String category_name) {
        this.category_name = category_name;
    }

    // --- GETTERS & SETTERS ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}