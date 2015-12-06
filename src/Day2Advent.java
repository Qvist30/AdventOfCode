

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day2Advent {

	static Path path = Paths
			.get("/Users/thomaskennedy/Documents/workspace/montecarlofantasy/src/montecarlofantasy/day2.file");
	 static int totalWrappingPaper = 0;
	 static int totalRibbon = 0;


	public static void main(String args[]) throws IOException {
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach((s) -> {
				String[] numbers = s.split("x");
				
				int length = Integer.valueOf(numbers[0]);
				int width = Integer.valueOf(numbers[1]);
				int height = Integer.valueOf(numbers[2]);
				int smallestSide = Integer.MAX_VALUE;
				int secondSmallestSide = Integer.MAX_VALUE;
				for(String number : numbers) {
					int num = Integer.valueOf(number);
					if(num < smallestSide) {
						secondSmallestSide = smallestSide;
						smallestSide = num;
					} else if(num < secondSmallestSide) {
						secondSmallestSide = num;
					}
					
				}
				int smallestArea =smallestSide * secondSmallestSide;
				int smallestPerimiter = smallestSide * 2 + secondSmallestSide*2;
				int wrappingPapper = 2*length* width + 2*length*height + 2*width*height + smallestArea;
				totalWrappingPaper += wrappingPapper;
				int ribbon = smallestPerimiter + length*width*height;
				totalRibbon += ribbon;
			});
		}
		System.out.println(totalWrappingPaper);
		System.out.println(totalRibbon);

	}
}
