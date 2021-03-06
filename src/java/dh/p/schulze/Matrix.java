package dh.p.schulze;

import java.util.Formatter;
import java.util.Map;

public class Matrix {

	int[][] data;
	int n;

	public Matrix(int n) {
		this.n = n;
		this.data = new int[n][n];
	}

	public int get(int i, int j) {
		return this.data[i][j];
	}

	public void set(int i, int j, int val) {
		this.data[i][j] = val;
	}

	public void inc(int i, int j) {
		this.data[i][j]++;
	}

	public void add(Matrix m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.data[i][j] += m.get(i, j);
			}
		}
	}
  
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);

		for (int i = 0; i < n; i++) {
			f.format("[");
			for (int j = 0; j < (n - 1); j++) {
				f.format("%2d,", this.data[i][j]);
			}
			f.format("%2d]%n", this.data[i][n - 1]);
		}

		f.close();
		return sb.toString();
	}
  
	public String toStringWith(Map<Integer, Candidate> candidates) {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
    
    f.format("||  -> ||");
    for(Candidate c : candidates.values()) {
			f.format(" %s||", c.niceAndShort());
    }
    f.format("%n");
    
		for (int i = 0; i < n; i++) {
			f.format("|| %s ||", candidates.get(i).niceAndShort());
			for (int j = 0; j < n; j++) {
				f.format("%3d ||", this.data[i][j]);
			}
			f.format("%n");
		}

		f.close();
		return sb.toString();
	}

}
