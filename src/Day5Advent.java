

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Day5Advent {
	static Path path = Paths
			.get("/Users/thomaskennedy/Documents/workspace/montecarlofantasy/src/montecarlofantasy/day5.file");
	static Pattern pattern = Pattern.compile(".*([A-Za-z]{2}).*\\1+.*");
	static Pattern vowelPattern = Pattern.compile(".*([A-Za-z]{1}).\\1+.*");
//	static Pattern excluePattern = Pattern.compile(".*(ab|cd|pq|xy).*");
	static int nice = 0;
	public static void main(String args[]) throws IOException {
		
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach((s) -> {
				Matcher matcher = pattern.matcher(s);
				Matcher vowelMatcher = vowelPattern.matcher(s);
//				Matcher excludePattern = excluePattern.matcher(s);
//				boolean exclusion = excludePattern.matches();
				boolean vowel = vowelMatcher.matches();
				boolean doubleLetter = matcher.matches();
				if(doubleLetter && vowel) {
					System.out.println(s);
					nice++;
				}
			});
			System.out.println(nice);
		}
	}
}
