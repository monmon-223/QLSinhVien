/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ENTITY;

/**
 *
 * @author nguye
 */
public class HocVien {
    private int maHV;
    private int maKH;
    private String maNH;
    private Double diem;
    private String hoten;

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public HocVien() {
    }

    public HocVien(int maHV, int maKH, String maNH, double diem, String hoten) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.diem = diem;
        this.hoten = hoten;
    }

    

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public Double getDiem() {
        
        return diem;
    }
    
    public void setDiem(Double diem) {
        if (diem == null) {
            this.diem = null;
        } else {
            this.diem = diem;
        }
    }
    

    

    
}
