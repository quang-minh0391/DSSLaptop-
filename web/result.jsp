<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Kết Quả Đề Xuất Laptop</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f7f6; }
        .container { max-width: 1000px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { color: #0056b3; }
        .ai-result { background: #e9ecef; padding: 15px; border-left: 5px solid #007bff; margin-bottom: 20px; font-size: 18px;}
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; border: 1px solid #ddd; text-align: center; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .back-btn { display: inline-block; margin-top: 20px; text-decoration: none; background: #6c757d; color: white; padding: 10px 15px; border-radius: 4px; }
        .back-btn:hover { background: #5a6268; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Kết Quả Tư Vấn (Decision Support System)</h2>
        
        <div class="ai-result">
            <strong>Trí tuệ nhân tạo (AI) dự đoán nhu cầu của bạn là:</strong> 
            <span style="color: #d9534f; font-weight: bold;">${predictedCategory}</span>
        </div>

        <h3>Top Laptop Phù Hợp Nhất (Theo Ngân Sách)</h3>
        
        <c:choose>
            <c:when test="${empty laptopList}">
                <p style="color: red;">Rất tiếc, không tìm thấy laptop nào phù hợp với yêu cầu và ngân sách của bạn trong hệ thống.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <thead>
                        <tr>
                            <th>Tên Máy</th>
                            <th>Thương Hiệu</th>
                            <th>Mức Giá (VNĐ)</th>
                            <th>RAM</th>
                            <th>Ổ Cứng</th>
                            <th>Màn Hình</th>
                            <th>Hiệu Năng (Score)</th>
                            <th>Value Score</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${laptopList}" var="laptop">
                            <tr>
                                <td style="text-align: left; font-weight: bold;">${laptop.laptop_name}</td>
                                <td>${laptop.brand}</td>
                                <td style="color: #28a745; font-weight: bold;">
                                    <fmt:formatNumber value="${laptop.price_vnd}" type="number" pattern="###,###"/> đ
                                </td>
                                <td>${laptop.ram_gb} GB</td>
                                <td>${laptop.storage_gb} GB</td>
                                <td>${laptop.screen_size}</td>
                                <td>${laptop.performance_score}</td>
                                <td>${laptop.value_score}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>

        <a href="index.jsp" class="back-btn">← Thử cấu hình khác</a>
    </div>
</body>
</html>