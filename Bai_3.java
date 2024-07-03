package VCCORP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai_3 {

	private static int timKiemDauHoacCuoi(int[] n, int tag, boolean dauOrCuoi) {
		int l = 0;
		int r = n.length - 1;
		int rs = -1;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (n[m] == tag) {
				rs = m;
				if (dauOrCuoi) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else if (n[m] < tag) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return rs;
	}

	public static List<Integer> viTriDauCuoi(int[] a, int tag) {
		List<Integer> rs = new ArrayList<>();
		int l = timKiemDauHoacCuoi(a, tag, true);
		int r = timKiemDauHoacCuoi(a, tag, false);

		if (l <= r && r < a.length && a[l] == tag && a[r] == tag) {
			rs.add(l);
			rs.add(r);
		}
		return rs;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int[] n = new int[l];
		for( int i = 0; i<l; i++) {
			n[i] = sc.nextInt();
		}
		int tag = sc.nextInt();
		
//		int[] n = { 5, 6, 7, 8, 8, 15 };
//		int tag = 8;
		List<Integer> rs = viTriDauCuoi(n, tag);
		System.out.println(rs);
	}
}
