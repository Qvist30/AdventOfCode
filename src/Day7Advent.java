import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Day7Advent {
	static Path path = Paths.get("/Users/thomaskennedy/Documents/workspace/AdventOfCode/src/day7.file");

	public static void main(String args[]) throws Exception {
		Map<String, Integer> circuits = new HashMap<String, Integer>();
		List<String> commands = new ArrayList<String>();
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach((s) -> {
				commands.add(s);
			});
		}
		while(!commands.isEmpty()) {
			Iterator<String> iterator = commands.iterator(); 
			while(iterator.hasNext()) {
				String s = iterator.next();
				String[] splitString = s.split(" -> ");
				String wire = splitString[1];
				String command = splitString[0];
				try {
					if (command.contains("AND")) {
						String[] andString = command.split(" AND ");
						int firstValue = getVlue(circuits, andString[0]);
						int secondValue = getVlue(circuits, andString[1]);

						int andValue = firstValue & secondValue;
						circuits.put(wire, andValue);
					} else if (command.contains("OR")) {
						String[] orString = command.split(" OR ");
						int firstValue = getVlue(circuits, orString[0]);
						int secondValue = getVlue(circuits, orString[1]);
						int orValue = firstValue | secondValue;

						circuits.put(wire, orValue);

					} else if (command.contains("NOT")) {
						String[] notString = command.split("NOT ");
						int firstValue = getVlue(circuits, notString[1]);
						int notValue = 65535 - firstValue;
						circuits.put(wire, notValue);
					} else if (command.contains("LSHIFT")) {
						String[] lshiftString = command.split(" LSHIFT ");
						int firstValue = getVlue(circuits, lshiftString[0]);
						int secondValue = getVlue(circuits, lshiftString[1]);

						int lshiftValue = firstValue << secondValue;
						circuits.put(wire, lshiftValue);

					} else if (command.contains("RSHIFT")) {
						String[] rshiftString = command.split(" RSHIFT ");
						int firstValue = getVlue(circuits, rshiftString[0]);
						int secondValue = getVlue(circuits, rshiftString[1]);
						int lshiftValue = firstValue >> secondValue;
						circuits.put(wire, lshiftValue);
					} else {
						int firstValue = getVlue(circuits, command);

						circuits.put(wire, Integer.valueOf(firstValue));
					}
					iterator.remove();
					System.out.println(s);
				} catch (Exception e) {
//					e.printStackTrace();
				}
			}
		}
		for (Map.Entry<String, Integer> circuit : circuits.entrySet()) {
			System.out.println(circuit.getKey() + ": " + circuit.getValue());
		}
	}

	private static int getVlue(Map<String, Integer> circuits, String andString) {
		int firstValue;
		try {
			firstValue = Integer.valueOf(andString);
		} catch (Exception e) {
			firstValue = circuits.get(andString);
		}
		return firstValue;
	}
}
