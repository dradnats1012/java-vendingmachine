package vendingmachine.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<List<String>> parseAllGoods(String inputGoods) {

        List<String> parsedGoods = Arrays.asList(inputGoods.split(";"));
        return parsedGoods.stream()
            .map(Parser::parseOneGoods)
            .collect(Collectors.toList());
    }

    private static List<String> parseOneGoods(String oneGoods) {
        String goodsRegex = oneGoods.replaceAll("[\\[\\]]", "");

        return Arrays.stream(goodsRegex.trim().split(",")).collect(Collectors.toList());
    }
}
