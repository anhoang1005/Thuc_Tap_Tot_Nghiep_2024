package VCCORP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai_1 {

	public static boolean timKiemNhiPhan(int[] a, int tag) {
        int l = 0;
        int r = a.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (a[m] == tag) {
                return true;
            } else if (a[m] < tag) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
		return false;
	}
	
	public static List<Integer> timGiao(int[] a1, int[] a2) {
        List<Integer> giaonhau = new ArrayList<>();

        for (int n : a1) {
            if (timKiemNhiPhan(a2, n)) {
                giaonhau.add(n);
            }
        }

        return giaonhau;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		m = sc.nextInt(); n = sc.nextInt();
		int[] a1 = new int[m];
		int[] a2 = new int[n];
		for(int i = 0; i<m; i++) {
			a1[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++) {
			a2[i] = sc.nextInt();
		}
		
        List<Integer> listGiaoNhau = timGiao(a1, a2);
        System.out.println(listGiaoNhau);
	}
}
