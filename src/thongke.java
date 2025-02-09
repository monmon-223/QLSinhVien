/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import DAO.ThongKeDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nguye
 */
public class thongke {
    private final ThongKeDAO thongKeDAO;

    public thongke() {
        this.thongKeDAO = new ThongKeDAO();
    }

    // Hiển thị thống kê người học lên bảng
    public void hienThiThongKeNguoiHoc(DefaultTableModel model) {
        List<Object[]> list = thongKeDAO.getNguoiHoc();
        hienThiDuLieuLenBang(model, list);
    }

    // Hiển thị thống kê điểm theo chuyên đề lên bảng
    public void hienThiThongKeDiemTheoChuyenDe(DefaultTableModel model) {
        List<Object[]> list = thongKeDAO.getDiemTheoChuyenDe();
        hienThiDuLieuLenBang(model, list);
    }

    // Hiển thị thống kê doanh thu lên bảng
    public void hienThiThongKeDoanhThu(DefaultTableModel model, int nam) {
        List<Object[]> list = thongKeDAO.getDoanhThu(nam);
        hienThiDuLieuLenBang(model, list);
    }

    // Hiển thị bảng dữ liệu lên model của JTable
    private void hienThiDuLieuLenBang(DefaultTableModel model, List<Object[]> list) {
        model.setRowCount(0);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }
}
