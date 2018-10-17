package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA13012IdentifyingTea {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String lineA;
		int r = 0;
		PrintWriter out = new PrintWriter(System.out);
		while ((line = br.readLine()) != null && line.length() != 0) {
			char x = line.charAt(0);
			lineA = br.readLine();
			for (int i = 0; i < lineA.length(); i += 2) {
				if (lineA.charAt(i) == x) {
					r++;
				}
			}
			out.append(r + "\n");
			r = 0;
		}
		out.flush();
		out.close();
	}
}
