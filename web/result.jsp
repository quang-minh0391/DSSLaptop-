<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kết Quả Đề Xuất Laptop</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; margin: 40px; background-color: #f4f7f6; }
        .container { max-width: 1200px; margin: auto; background: #fff; padding: 25px; border-radius: 12px; box-shadow: 0 4px 20px rgba(0,0,0,0.08); }
        h2 { color: #2c3e50; text-align: center; margin-bottom: 30px; }
        .ai-result { background: #e3f2fd; padding: 15px; border-left: 6px solid #2196f3; margin-bottom: 25px; border-radius: 4px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; font-size: 14px; }
        th, td { padding: 12px; border: 1px solid #e2e8f0; text-align: center; }
        th { background-color: #2196f3; color: white; text-transform: uppercase; font-size: 13px; letter-spacing: 0.5px; }
        tr:nth-child(even) { background-color: #f8fafc; }
        tr:hover { background-color: #edf2f7; transition: 0.3s; }
        /* Tự động đổi màu Badge dựa trên độ phù hợp nếu cần (logic bổ sung) */
        .score-badge { background: #4caf50; color: white; padding: 6px 10px; border-radius: 20px; font-weight: bold; font-size: 13px; display: inline-block; min-width: 50px; }
        .back-btn { display: inline-block; margin-top: 25px; text-decoration: none; background: #64748b; color: white; padding: 10px 20px; border-radius: 6px; font-weight: bold; transition: background 0.2s; }
        .back-btn:hover { background: #475569; }
        .price-tag { color: #d32f2f; font-weight: bold; font-size: 15px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🏆 KẾT QUẢ TƯ VẤN HỆ THỐNG DSS</h2>
        
        <div class="ai-result">
            <strong>Phân khúc AI xác định cho bạn:</strong> 
            <span style="color: #1976d2; font-size: 22px; text-transform: uppercase; font-weight: 800; margin-left: 10px;">
                <%-- Sử dụng thuộc tính đã được map chính xác --%>
                ${not empty laptopList ? laptopList[0].target_category : 'Đang phân tích...'}
            </span>
        </div>

        <h3>Top 5 Laptop Phù Hợp Nhất Với Yêu Cầu</h3>
        
        <c:choose>
            <%-- Kiểm tra nếu danh sách trống hoặc chứa máy báo lỗi từ Python --%>
            <c:when test="${empty laptopList || laptopList[0].laptop_name == 'KHÔNG CÓ MÁY PHÙ HỢP VỚI NGÂN SÁCH/YÊU CẦU'}">
                <div style="text-align: center; padding: 40px; border: 2px dashed #cbd5e0; border-radius: 8px;">
                    <p style="color: #e53e3e; font-size: 18px; font-weight: bold;">Rất tiếc, không tìm thấy laptop nào phù hợp với ngân sách của bạn.</p>
                    <p>Mẹo: Hãy thử tăng <b>Ngân sách</b> hoặc điều chỉnh lại yêu cầu cấu hình.</p>
                </div>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th width="30%">Tên Laptop</th>
                            <th>Thương Hiệu</th>
                            <th>Giá Bán</th>
                            <th>RAM</th>
                            <th>Ổ Cứng</th>
                            <th>Màn Hình</th>
                            <th>Tần Số Quét</th>
                            <th>Độ Phù Hợp</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${laptopList}" var="laptop">
                            <tr>
                                <td style="text-align: left; font-weight: 600; color: #2d3748;">
                                    ${laptop.laptop_name}
                                </td>
                                <td style="text-transform: uppercase; font-weight: 500;">
                                    ${laptop.brand}
                                </td>
                                <td>
                                    <span class="price-tag">
                                        <fmt:formatNumber value="${laptop.price_vnd}" type="number" pattern="###,###"/> đ
                                    </span>
                                </td>
                                <td>${laptop.ram_gb} GB</td>
                                <td>${laptop.storage_gb} GB</td>
                                <td>${laptop.screen_size_num}"</td>
                                <td>${laptop.refresh_rate}</td>
                                <td>
                                    <span class="score-badge">
                                        <%-- Định dạng hiển thị phần trăm phù hợp --%>
                                        <fmt:formatNumber value="${laptop.similarity_score}" maxFractionDigits="1"/>%
                                    </span>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <a href="home" class="back-btn">← Quay lại chỉnh sửa cấu hình</a>
    </div>
</body>
</html>