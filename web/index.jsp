<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hệ Thống Tư Vấn Laptop (DSS)</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f7f6;}
        .container { max-width: 600px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input[type="number"], input[type="text"] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        button { background-color: #28a745; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; width: 100%; font-size: 16px; }
        button:hover { background-color: #218838; }
    </style>
</head>
<body>
    <div class="container">
        <h2 style="text-align: center; color: #333;">Nhập Cấu Hình Mong Muốn</h2>
        <form action="recommend" method="POST">
            
            <div class="form-group">
                <label>Ngân sách tối đa (VNĐ):</label>
                <input type="number" name="budget" required placeholder="VD: 30000000">
            </div>

            <div class="form-group">
                <label>Điểm hiệu năng CPU (CPU Score):</label>
                <input type="number" name="cpu_score" required placeholder="VD: 15000">
            </div>

            <div class="form-group">
                <label>Dung lượng RAM (GB):</label>
                <input type="number" name="ram_gb" required placeholder="VD: 16">
            </div>

            <div class="form-group">
                <label>Loại Card Đồ Họa (GPU Encoded):</label>
                <input type="number" name="gpu_encoded" required placeholder="VD: 2 (1: Tích hợp, 2: Rời)">
            </div>

            <div class="form-group">
                <label>Dung lượng Ổ cứng (GB):</label>
                <input type="number" name="storage_gb" required placeholder="VD: 512">
            </div>

            <div class="form-group">
                <label>Kích thước màn hình (Inch):</label>
                <input type="number" step="0.1" name="screen_size" required placeholder="VD: 15.6">
            </div>

            <div class="form-group">
                <label>Dung lượng Pin (Wh):</label>
                <input type="number" step="0.1" name="battery_wh" required placeholder="VD: 50.5">
            </div>

            <div class="form-group">
                <label>Tần số quét màn hình (Refresh Rate Score):</label>
                <input type="number" name="refresh_rate" required placeholder="VD: 144">
            </div>

            <div class="form-group">
                <label>Hệ điều hành (OS Encoded):</label>
                <input type="number" name="os_encoded" required placeholder="VD: 1 (Windows), 2 (Mac)">
            </div>

            <button type="submit">Phân Tích & Tìm Máy Phù Hợp</button>
        </form>
    </div>
</body>
</html>