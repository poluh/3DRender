package com.poluhin.render.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static List<Polygon> parse(String pathToFile) throws IOException {
        return Files.readAllLines(Paths.get(pathToFile))
                .stream()
                .map(line -> {
                    var parts = Arrays.stream(line.replaceAll("[(|)]", "")
                            .split("\\s*,\\s*")).map(Integer::parseInt).toArray(Integer[]::new);
                    return new Polygon(new Point(parts[0], parts[1], parts[2]),
                            new Point(parts[3], parts[4], parts[5]),
                            new Point(parts[6], parts[7], parts[8]));
                })
                .collect(Collectors.toList());
    }
}
