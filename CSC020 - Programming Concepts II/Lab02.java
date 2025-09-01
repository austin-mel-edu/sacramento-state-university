// Austin Melendez

package Main;

import java.util.StringTokenizer;

public class Lab02{
	public static void main(String[] args){
		// My code to dynamically create a small movie database (DO NOT MODIFY OR REMOVE!)
		String[] movies = new String[5];
		movies[0] = "Shawshank Redemption*1994*Tim Robbins*2.36";
		movies[1] = "The Godfather*1972*Al Pacino*2.92";
		movies[2] = "Raging Bull*1980*Robert De Niro*2.15";
		movies[3] = "Million Dollar Baby*2004*Hilary Swank*2.2";
		movies[4] = "Straight Outta Compton*2015*Jason Mitchell*2.45";
		
		// End of code
		
		String[] titles = new String[movies.length];
		int[] years = new int[movies.length];
		String[] stars = new String[movies.length];
		float[] runtimes = new float[movies.length];
		
		String raw;
		
		for(int i=0; i < movies.length; i++){
			raw = movies[i];
			StringTokenizer st = new StringTokenizer(raw, "*");
			String[] tokens = new String[st.countTokens()];
			for(int j=0; j < tokens.length; j++) {
				tokens[j] = st.nextToken();
			}
			titles[i] = tokens[0];
			years[i] = Integer.parseInt(tokens[1]);
			stars[i] = tokens[2];
			runtimes[i] = Float.parseFloat(tokens[3]);
		}
		
		System.out.println("-----MOVIES-----");
		for(int a=0; a<titles.length; a++) {
			System.out.println(titles[a]);
		}
		System.out.println("-----YEARS-----");
		for(int b=0; b<years.length; b++) {
			System.out.println(years[b]);
		}
		System.out.println("-----STARS-----");
		for(int c=0; c<stars.length; c++) {
			System.out.println(stars[c]);
		}
		System.out.println("-----RUNTIMES-----");
		for(int d=0; d<runtimes.length; d++) {
			System.out.println(runtimes[d]);
		}
			
	}
}