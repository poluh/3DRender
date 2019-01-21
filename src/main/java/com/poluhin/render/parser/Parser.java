package com.poluhin.render.parser;

import com.poluhin.render.engine.node.Node;
import com.poluhin.render.engine.node.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static Node parse(String pathToFile) throws IOException {
        return new Node(
                Files.readAllLines(Paths.get(pathToFile))
                        .stream()
                        .map(line -> {
                            line = line.substring(3);
                            var parts = Arrays.stream(line.replaceAll("[(|)]", "")
                                    .split("\\s+")).map(Double::new).toArray(Double[]::new);
                            if (parts.length != 3) {
                                throw new IllegalArgumentException("Parse failed in line \"" + line + "\"");
                            }
                            return new Point((parts[0]), (parts[1] * -1.2), (parts[2]));
                        })
                        .collect(Collectors.toSet())
        );
    }
}
