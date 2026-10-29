package com.uopeople.bookcatalogappunit8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class CsvBookStorage {
    private static final String HEADER = "isbn,title,author,available";

    private CsvBookStorage() { }

    public static void save(Path path, List<Book> books) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(HEADER);
        for (Book book : books) {
            lines.add(csv(book.getIsbn()) + "," + csv(book.getTitle()) + ","
                    + csv(book.getAuthor()) + "," + book.isAvailable());
        }
        Path absolute = path.toAbsolutePath();
        Path parent = absolute.getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.write(absolute, lines, StandardCharsets.UTF_8);
    }

    public static List<Book> load(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        List<Book> loaded = new ArrayList<>();
        if (lines.isEmpty()) {
            return loaded;
        }
        int firstDataLine = lines.get(0).trim().equalsIgnoreCase(HEADER) ? 1 : 0;
        for (int i = firstDataLine; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.isBlank()) {
                continue;
            }
            List<String> fields = parseCsvLine(line);
            if (fields.size() != 4) {
                throw new IOException("Invalid CSV record on line " + (i + 1)
                        + ": expected 4 fields.");
            }
            String isbn = fields.get(0).trim();
            String title = fields.get(1).trim();
            String author = fields.get(2).trim();
            String availableText = fields.get(3).trim();
            if (!availableText.equalsIgnoreCase("true")
                    && !availableText.equalsIgnoreCase("false")) {
                throw new IOException("Invalid availability value on line " + (i + 1) + ".");
            }
            loaded.add(new Book(isbn, title, author, Boolean.parseBoolean(availableText)));
        }
        return loaded;
    }

    private static String csv(String value) {
        String escaped = value.replace("\"", "\"\"");
        if (escaped.contains(",") || escaped.contains("\"")
                || escaped.contains("\n") || escaped.contains("\r")) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }

    private static List<String> parseCsvLine(String line) throws IOException {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean quoted = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (quoted) {
                if (ch == '"') {
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        field.append('"');
                        i++;
                    } else {
                        quoted = false;
                    }
                } else {
                    field.append(ch);
                }
            } else if (ch == ',') {
                fields.add(field.toString());
                field.setLength(0);
            } else if (ch == '"' && field.length() == 0) {
                quoted = true;
            } else {
                field.append(ch);
            }
        }
        if (quoted) {
            throw new IOException("Unclosed quotation mark in CSV record.");
        }
        fields.add(field.toString());
        return fields;
    }
}

