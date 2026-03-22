<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hệ Thống Tư Vấn Laptop (DSS)</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 40px; background-color: #f0f2f5;}
        .container { max-width: 900px; margin: auto; background: #fff; padding: 30px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); }
        .form-section { border-bottom: 2px solid #3498db; margin-bottom: 20px; padding-bottom: 5px; color: #2c3e50; }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; color: #34495e; }
        input, select { width: 100%; padding: 12px; box-sizing: border-box; border: 1px solid #cbd5e0; border-radius: 6px; font-size: 14px; outline: none; }
        input:focus, select:focus { border-color: #3498db; box-shadow: 0 0 5px rgba(52,152,219,0.3); }
        button { background: linear-gradient(135deg, #2ecc71 0%, #27ae60 100%); color: white; padding: 15px; border: none; border-radius: 6px; cursor: pointer; width: 100%; font-size: 18px; font-weight: bold; transition: 0.3s; margin-top: 10px; }
        button:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(46,204,113,0.4); }
        .row { display: flex; gap: 15px; flex-wrap: wrap; }
        .col { flex: 1; min-width: 250px; }
    </style>
</head>
<body>
    <div class="container">
        <h2 style="text-align: center; color: #2c3e50;">💻 Hệ Thống Hỗ Trợ Quyết Định Laptop</h2>
        
        <form action="recommend" method="POST">
            
            <div class="form-section"><h3>1. Nhu cầu & Thói quen sử dụng</h3></div>
            
            <div class="row">
                <div class="form-group col">
                    <label>Ngân sách tối đa (VNĐ):</label>
                    <input type="number" name="budget" required value="25000000" placeholder="VD: 25000000">
                </div>
                <div class="form-group col">
                    <label>Mục đích sử dụng:</label>
                    <select name="purpose">
                        <option value="">-- Để AI tự phân tích --</option>
                        <option value="Văn phòng & Học tập">Văn phòng & Học tập</option>
                        <option value="Đa năng / Phổ thông">Đa năng / Phổ thông</option>
                        <option value="Lập trình / Developer">Lập trình / Developer</option>
                        <option value="Đồ họa & Sáng tạo nội dung">Đồ họa & Sáng tạo nội dung</option>
                        <option value="Gaming Phổ thông">Gaming Phổ thông</option>
                        <option value="Gaming Cao cấp">Gaming Cao cấp</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="form-group col">
                    <label>Môi trường sử dụng:</label>
                    <select name="environment" required>
                        <option value="">-- Chọn môi trường từ DB --</option>
                        <%-- Cần đảm bảo HomeServlet đã setAttribute("envList", list) --%>
                        <c:forEach items="${envList}" var="env">
                            <option value="${env.env_name}">${env.env_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col">
                    <label>Tần suất sử dụng (giờ/ngày):</label>
                    <select name="frequency" required>
                        <option value="">-- Chọn tần suất từ DB --</option>
                        <%-- Cần đảm bảo HomeServlet đã setAttribute("freqList", list) --%>
                        <c:forEach items="${freqList}" var="freq">
                            <option value="${freq.freq_name}">${freq.freq_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-section"><h3>2. Cấu hình mong muốn (Bổ sung cho AI)</h3></div>
            
            <div class="row">
                <div class="form-group col">
                    <label>Thương hiệu ưu tiên:</label>
                    <select name="brand">
                        <option value="">Bất kỳ</option>
                        <option value="apple">Apple (Macbook)</option>
                        <option value="asus">Asus</option>
                        <option value="dell">Dell</option>
                        <option value="hp">HP</option>
                        <option value="lenovo">Lenovo</option>
                        <option value="acer">Acer</option>
                        <option value="msi">MSI</option>
                    </select>
                </div>
                <div class="form-group col">
                    <label>Dòng CPU mong muốn:</label>
                    <select name="cpu_class">
                        <option value="">Bất kỳ</option>
                        <option value="mạnh mẽ (i9/r9)">Mạnh mẽ (i9/R9)</option>
                        <option value="khá mạnh (i7/r7)">Khá mạnh (i7/R7)</option>
                        <option value="trung bình (i5/r5)">Trung bình (i5/R5)</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="form-group col">
                    <label>RAM tối thiểu (GB):</label>
                    <input type="number" name="ram_gb" value="16">
                </div>
                <div class="form-group col">
                    <label>Ổ cứng tối thiểu (GB):</label>
                    <input type="number" name="storage_gb" value="512">
                </div>
                <div class="form-group col">
                    <label>Màn hình / Tần số quét:</label>
                    <select name="refresh_rate">
                        <option value="">Bất kỳ</option>
                        <option value="gaming (144hz+)">Siêu mượt (144Hz+)</option>
                        <option value="tốt (90-120hz)">Mượt mà (90-120Hz)</option>
                        <option value="tiêu chuẩn (60hz)">Tiêu chuẩn (60Hz)</option>
                    </select>
                </div>
            </div>

            <%-- Đồng bộ lại tên name cho khớp với RecommendServlet --%>
            <input type="hidden" name="gpu_type" value="">
            <input type="hidden" name="screen_size" value="15.6">
            <input type="hidden" name="battery" value="50">

            <button type="submit">Phân Tích Bằng AI & Gợi Ý 🏆</button>
        </form>
    </div>
</body>
</html>