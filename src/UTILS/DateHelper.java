/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package UTILS;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    // Định nghĩa định dạng ngày bạn muốn sử dụng
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    /**
     * Chuyển đổi một đối tượng Date thành một String.
     * @param   tượng Date cần chuyển đổi.
     * @return Một chuỗi biểu diễn ngày được định dạng.
     */
    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        return sdf.format(date);
    }

    /**
     * Chuyển đổi một String thành một đối tượng Date.
     * @param  Chuỗi cần chuyển đổi.
     * @return Một đối tượng Date biểu diễn ngày.
     * @throws ParseException nếu dateStr không thể phân tích.
     */
    public static Date toDate(String dateStr) throws ParseException {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            throw new ParseException("Chuỗi ngày null hoặc trống", 0);
        }
        return sdf.parse(dateStr);
    }

    /**
     * Lấy ngày hiện tại.
     * @return Một đối tượng Date biểu diễn ngày hiện tại.
     */
    public static Date now() {
        return new Date();
    }
    
    // Thêm số ngày vào ngày hiện tại và trả về ngày mới
    public static Date add(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date()); // Lấy ngày hiện tại
        cal.add(Calendar.DAY_OF_MONTH, days); // Thêm số ngày
        return cal.getTime();
    }
}