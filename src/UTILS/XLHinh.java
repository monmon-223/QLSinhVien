package UTILS;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

public class XLHinh {
    /*
     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
     */
   public static Image getAppIcon()
   {
       URL url=XLHinh.class.getResource("/ICON/fpt.png");
       return new ImageIcon(url).getImage();
           
   }
   /*
     * Sao chép file logo chuyên đề vào thư mục logo
     * @param src là đối tượng file ảnh
     */   
    
     
    public static void save(File src) {
        File dst = new File("src\\resources\\logos", src.getName());
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /*
     * Đọc hình ảnh logo chuyên đề
     * @param fileName  là tên file logo
     * @param width là chiều rộng của JLabel
     * @param height là chiều cao của JLabel
     * @return ảnh đọc được và thay đổi kích thước
     */
    public static ImageIcon read(String fileName, int width, int height) {
        File path = new File("src\\resources\\logos", fileName);
        ImageIcon icon = new ImageIcon(path.getAbsolutePath());
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
    
}
