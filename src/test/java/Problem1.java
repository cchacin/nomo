import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Iterate over the lines of a file,
 * take only the lines that contains the text "Functional"
 * sort the result in natural order
 * and return the first line of that result.
 */
class Problem1 extends Assertions {

    interface Solution1 {

        static String calculate() throws Exception {
            final List<String> filtered = new ArrayList<>();

            final List<String> allLines = Files.readAllLines(
                    Paths.get(Problem1.class.getResource("myfile.txt").toURI())
            );

            for (final String line : allLines) {
                if (line.contains("Functional")) {
                    filtered.add(line);
                }
            }

            filtered.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            return filtered.get(0);
        }

    }

    @Test
    void testSolution1() throws Exception {
        // Given

        // When
        final String result = Solution1.calculate();

        // Then
        assertThat(result).isEqualTo("Functional line 2");
    }
}
