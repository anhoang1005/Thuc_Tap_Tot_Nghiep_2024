package VCCORP;

import java.util.Arrays;

public class Bai_4 {

	public static int[] countingSort(int[] arr) {
		int[] mangSapXep = new int[arr.length];

		int max = 0;
		for (int n : arr) {
			if (n > max) {
				max = n;
			}
		}

		int[] cnt = new int[max + 1];
		for (int n : arr) {
			cnt[n]++;
		}
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			int n = arr[i];
			mangSapXep[cnt[n] - 1] = n;
			cnt[n]--;
		}
		
		System.arraycopy(mangSapXep, 0, arr, 0, arr.length);
		return mangSapXep;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
		System.out.println(Arrays.toString(countingSort(arr)));
	}
}
