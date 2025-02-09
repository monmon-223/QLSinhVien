/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */

import ENTITY.ChuyenDe;
import ENTITY.KhoaHoc;
import UTILS.XJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO {

    // Thêm một bản ghi mới vào bảng KhoaHoc
   public void insert(KhoaHoc model) {
        String sql = "INSERT INTO KhoaHoc (MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV) VALUES (?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql,
                model.getMaCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getNgayKG(),
                model.getGhiChu(),
                model.getMaNV());
    }

    // Cập nhật thông tin của một bản ghi trong bảng KhoaHoc
    public void update(KhoaHoc model) {
        String sql = "UPDATE KhoaHoc SET MaCD=?, HocPhi=?, ThoiLuong=?, NgayKG=?, GhiChu=?, MaNV=? WHERE MaKH=?";
        XJdbc.update(sql,
                model.getMaCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getNgayKG(),
                model.getGhiChu(),
                model.getMaNV(),
                model.getMaKH());
    }

    // Xóa một bản ghi từ bảng KhoaHoc dựa trên khóa chính MaKH
    public void delete(Integer MaKH) {
        String sql = "DELETE FROM KhoaHoc WHERE MaKH=?";
        XJdbc.update(sql, MaKH);
    }

    // Lấy danh sách tất cả các bản ghi từ bảng KhoaHoc
    public List<KhoaHoc> select() {
        String sql = "SELECT * FROM KhoaHoc";
        return select(sql);
    }

    // Tìm kiếm một bản ghi trong bảng KhoaHoc dựa trên khóa chính MaKH
    public KhoaHoc findById(Integer makh) {
        String sql = "SELECT * FROM KhoaHoc WHERE MaKH=?";
        List<KhoaHoc> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public String tencd(String macd) {
        String sql = "SELECT TenCD FROM ChuyenDe WHERE MaCD = ?";
        try (ResultSet rs = XJdbc.query(sql, macd)) {
            if (rs.next()) {
                return rs.getString("TenCD");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }

    // Phương thức hỗ trợ thực hiện các truy vấn đặc biệt với các tham số
    private List<KhoaHoc> select(String sql, Object... args) {
        List<KhoaHoc> list = new ArrayList<>();
        try (ResultSet rs = XJdbc.query(sql, args)) {
            while (rs.next()) {
                KhoaHoc model = readFromResultSet(rs);
                list.add(model);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    // Phương thức hỗ trợ đọc một bản ghi từ ResultSet
    private KhoaHoc readFromResultSet(ResultSet rs) throws SQLException {
        KhoaHoc model = new KhoaHoc();
        model.setMaKH(rs.getInt("MaKH"));
        model.setHocPhi((float) rs.getDouble("HocPhi"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        model.setNgayKG(rs.getDate("NgayKG"));
        model.setGhiChu(rs.getString("GhiChu"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayTao(rs.getDate("NgayTao"));
        model.setMaCD(rs.getString("MaCD"));
        return model;
    }
    
    public List<Integer> selectYears() {
    String sql = "SELECT DISTINCT YEAR(NgayKG) AS Year FROM KhoaHoc ORDER BY Year";
        List<Integer> years = new ArrayList<>();
        try (ResultSet rs = XJdbc.query(sql)) {
            while (rs.next()) {
                years.add(rs.getInt("Year"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return years;
    }
}

