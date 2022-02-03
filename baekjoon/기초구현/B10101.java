package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10101 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int angleA = Integer.parseInt(br.readLine());
		int angleB = Integer.parseInt(br.readLine());
		int angleC = Integer.parseInt(br.readLine());
		int sum = angleA + angleB + angleC;
		
		if(sum == 180) {
			if(angleA == angleB && angleB == angleC) {
				System.out.println("Equilateral");
			}
			else if (angleA == angleB || angleB == angleC || angleA == angleC) {
				System.out.println("Isosceles");
			}
			else {
				System.out.println("Scalene");
			}
		}
		else {
			System.out.println("Error");
		}
	}
}
