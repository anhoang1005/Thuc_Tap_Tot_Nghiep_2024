package VCCORP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai_2 {
	private static final String URL_REGEX =
            "^(https?://)" + // Bat dau bang http hoac https
            "([\\w-]+\\.)?" + // Co the chua www hoac khong
            "([a-zA-Z0-9-]+)" + // Ten mien chi chua cac ki tu la tinh hoa
            "(\\.[a-z]{2,6})" + // Phan domain extension chua dau cham o dau, theo sau la cac ky tu in thưong có đo dai tu 2 den 6 ky tu
            "(/[^\\s]*)?$";	// Phan path khong chua dau cach
	
	public static boolean kiemTraURL(String url) {
        Pattern pattern = Pattern.compile(URL_REGEX);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
	
	public static void main(String[] args) {
		String test1 = "https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu";
        String test2 = "http://ptit.com";
        String test3 = "https://ptit.edu.sv/path/to/resource";
        String test4 = "https://ptit.123";
        String test5 = "https://www.ptit.com";
        
        System.out.println(kiemTraURL(test1));
        System.out.println(kiemTraURL(test2));
        System.out.println(kiemTraURL(test3));
        System.out.println(kiemTraURL(test4));
        System.out.println(kiemTraURL(test5));
        
	}
}
