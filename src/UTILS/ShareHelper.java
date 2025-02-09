//package UTILS;
//
//import ENTITY.NhanVien;
//import java.awt.Image;
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import javax.swing.ImageIcon;
//
//public class ShareHelper {
//    /**
//     * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
//     */
//    public static final Image APP_ICON;
//
//    static {
//        // Tải biểu tượng ứng dụng
//        String file = "icon/fpt.png";
//        java.net.URL imgURL = ShareHelper.class.getResource(file);
//        if (imgURL != null) {
//            APP_ICON = new ImageIcon(imgURL).getImage();
//        } else {
//            // Xử lý trường hợp không tìm thấy tệp
//            System.err.println("Không tìm thấy tệp: " + file);
//            APP_ICON = null; // hoặc cung cấp một ảnh mặc định
//        }
//    }
//
//    /**
//     * Sao chép file logo chuyên đề vào thư mục logo
//     * @param file là đối tượng file ảnh
//     * @return chép được hay không
//     */ 
//    public static boolean saveLogo(File file) {
//        File dir = new File("logos");
//        // Tạo thư mục nếu chưa tồn tại
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
//        File newFile = new File(dir, file.getName());
//        try {
//            // Copy vào thư mục logos (đè nếu đã tồn tại)
//            Path source = Paths.get(file.getAbsolutePath());
//            Path destination = Paths.get(newFile.getAbsolutePath());
//            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//
//    /**
//     * Đọc hình ảnh logo chuyên đề
//     * @param fileName là tên file logo
//     * @return ảnh đọc được
//     */ 
//    public static ImageIcon readLogo(String fileName) {
//        File path = new File("logos" + File.separator + fileName); // Sử dụng File.separator để tạo đường dẫn phù hợp cho mọi hệ điều hành
//        if (path.exists()) {
//            return new ImageIcon(path.getAbsolutePath());
//        } else {
//            // Xử lý trường hợp không tìm thấy tệp
//            System.out.println("Không tìm thấy tệp logo: " + fileName);
//            return null;
//        }
//    }
//
//    /**
//     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
//     */
//    public static NhanVien USER = null;
//
//    /**
//     * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
//     */
//    public static void logoff() {
//        ShareHelper.USER = null;
//    }
//
//    /**
//     * Kiểm tra xem đăng nhập hay chưa
//     * @return đăng nhập hay chưa
//     */
//    public static boolean authenticated() {
//        return ShareHelper.USER != null;
//    }
//}