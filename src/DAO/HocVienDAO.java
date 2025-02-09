/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
import ENTITY.HocVien;
import UTILS.XJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HocVienDAO {

    // Thêm một bản ghi HocVien mới vào cơ sở dữ liệu
    public void insert(HocVien model) {
        String sql = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
        XJdbc.update(sql, model.getMaKH(), model.getMaNH(), model.getDiem());
    }

    // Cập nhật một bản ghi HocVien hiện có trong cơ sở dữ liệu
    public void update(HocVien model) {
        String sql = "UPDATE HocVien SET Diem=? WHERE MaHV=?";
        XJdbc.update(sql, model.getDiem(), model.getMaHV());
    }
    

    // Xóa một bản ghi HocVien khỏi cơ sở dữ liệu bằng MaHV
    public void delete(Integer MaHV) {
        String sql = "DELETE FROM HocVien WHERE MaHV=?";
        XJdbc.update(sql, MaHV);
    }

    // Truy vấn tất cả các bản ghi HocVien từ cơ sở dữ liệu
    public List<HocVien> select() {
        String sql = "SELECT * FROM HocVien";
        return select(sql);
    }

    // Tìm một bản ghi HocVien bằng MaHV
    public HocVien findById(Integer MaHV) {
        String sql = "SELECT * FROM HocVien WHERE MaHV=?";
        List<HocVien> list = select(sql, MaHV);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
    public int findById(int maKH, String maNH) {
        
        int maHV = -1; // Giả sử -1 là giá trị mặc định khi không tìm thấy

        String sql = "SELECT MaHV FROM HocVien WHERE MaKH = ? AND MaNH = ?";
        try {
            ResultSet rs = XJdbc.query(sql, maKH, maNH);
            if (rs.next()) {
                maHV = rs.getInt("MaHV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maHV;
    }
    public boolean isEnrolled(int maKH, String maNH) {
        String sql = "SELECT COUNT(*) AS Count FROM HocVien WHERE MaKH = ? AND MaNH = ?";
        try {
            ResultSet rs = XJdbc.query(sql, maKH, maNH);
            if (rs.next()) {
                int count = rs.getInt("Count");
                return count > 0; // Trả về true nếu có ít nhất một học viên tồn tại trong khóa học
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu có lỗi xảy ra hoặc không có học viên nào tồn tại trong khóa học
    }
    // Thực thi một truy vấn SQL và trả về danh sách các đối tượng HocVien
    private List<HocVien> select(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try (ResultSet rs = XJdbc.query(sql, args)) {
            while (rs.next()) {
                HocVien model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    // Chuyển đổi một hàng trong ResultSet thành một đối tượng HocVien
    private HocVien readFromResultSet(ResultSet rs) throws SQLException {
        HocVien model = new HocVien();
        model.setMaHV(rs.getInt("MaHV"));
        model.setMaKH(rs.getInt("MaKH"));
        model.setMaNH(rs.getString("MaNH"));
        model.setDiem(rs.getDouble("Diem"));
        return model;
    }

}