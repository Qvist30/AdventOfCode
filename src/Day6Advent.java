import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day6Advent {
	
	static Path path = Paths
			.get("/Users/thomaskennedy/Documents/workspace/AdventOfCode/src/day6.file");
	static int[][] lit = new int[1000][1000];
	public static void main(String args[]) throws IOException {
		int totalLit = 0;
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach((s) -> {
				if(s.startsWith("turn on")) {
					s = s.replace("turn on ","");
					String[] splitString = s.split(" through ");
					String[] start = splitString[0].split(",");
					String[] end = splitString[1].split(",");
					for(int i=Integer.valueOf(start[0]); i<=Integer.valueOf(end[0]); i++) {
						for(int j=Integer.valueOf(start[1]); j<=Integer.valueOf(end[1]); j++) {
							lit[i][j]++;
						}
					}
				}
				if(s.startsWith("toggle")) {
					s = s.replace("toggle ","");
					String[] splitString = s.split(" through ");
					String[] start = splitString[0].split(",");
					String[] end = splitString[1].split(",");
					for(int i=Integer.valueOf(start[0]); i<=Integer.valueOf(end[0]); i++) {
						for(int j=Integer.valueOf(start[1]); j<=Integer.valueOf(end[1]); j++) {
							lit[i][j] += 2;
						}
					}
				}
				if(s.startsWith("turn off")) {
					s = s.replace("turn off ","");
					String[] splitString = s.split(" through ");
					String[] start = splitString[0].split(",");
					String[] end = splitString[1].split(",");
					for(int i=Integer.valueOf(start[0]); i<=Integer.valueOf(end[0]); i++) {
						for(int j=Integer.valueOf(start[1]); j<=Integer.valueOf(end[1]); j++) {
							if (lit[i][j] > 0) {
								lit[i][j]--;
							}
						}
					}
				}
			});
		}
		for(int i=0; i<=999;i++) {
			for(int j=0; j<=999; j++) {
				totalLit += lit[i][j];
			}
		}
		System.out.println(totalLit);
		
	}
}
