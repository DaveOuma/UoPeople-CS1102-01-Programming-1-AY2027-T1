package com.uopeople.bookcatalogappunit8;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class BookCatalogApp extends Application {
    private final ObservableList<Book> books = FXCollections.observableArrayList();
    private final FilteredList<Book> filteredBooks = new FilteredList<>(books, book -> true);
    private final TableView<Book> table = new TableView<>();
    private final TextField isbnField = new TextField();
    private final TextField titleField = new TextField();
    private final TextField authorField = new TextField();
    private final TextField searchField = new TextField();
    private final Label statusLabel = new Label("Ready.");
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        stage.setTitle("BookCatalogApp - Community Library");
        table.setItems(filteredBooks);
        table.setPlaceholder(new Label("No books match the current view."));
        configureTable();

        isbnField.setPromptText("ISBN-10 or ISBN-13");
        titleField.setPromptText("Book title");
        authorField.setPromptText("Author name");
        searchField.setPromptText("Search title or author");

        Button addButton = new Button("Add Book");
        Button removeButton = new Button("Remove Selected");
        Button toggleButton = new Button("Check Out / Return");
        Button saveButton = new Button("Save CSV");
        Button loadButton = new Button("Load CSV");
        Button clearSearchButton = new Button("Clear Search");

        addButton.setOnAction(event -> handleAddBook());
        removeButton.setOnAction(event -> handleRemoveBook());
        toggleButton.setOnAction(event -> handleToggleAvailability());
        saveButton.setOnAction(event -> handleSave());
        loadButton.setOnAction(event -> handleLoad());
        clearSearchButton.setOnAction(event -> searchField.clear());
        searchField.textProperty().addListener((observable, oldValue, newValue) ->
                applySearch(newValue));

        GridPane form = new GridPane();
        form.setHgap(8);
        form.setVgap(8);
        form.add(new Label("ISBN"), 0, 0);
        form.add(isbnField, 1, 0);
        form.add(new Label("Title"), 0, 1);
        form.add(titleField, 1, 1);
        form.add(new Label("Author"), 0, 2);
        form.add(authorField, 1, 2);
        form.add(addButton, 1, 3);

        HBox searchRow = new HBox(8, new Label("Search:"), searchField, clearSearchButton);
        HBox managementRow = new HBox(8, removeButton, toggleButton);
        HBox fileRow = new HBox(8, saveButton, loadButton);
        VBox top = new VBox(10, new Label("Community Library Book Catalog"), form,
                searchRow, managementRow, fileRow);
        top.setPadding(new Insets(12));

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(table);
        root.setBottom(statusLabel);
        BorderPane.setMargin(table, new Insets(0, 12, 12, 12));
        BorderPane.setMargin(statusLabel, new Insets(0, 12, 12, 12));

        stage.setScene(new Scene(root, 950, 600));
        stage.show();
    }

    private void configureTable() {
        TableColumn<Book, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        isbnColumn.setPrefWidth(180);

        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setPrefWidth(260);

        TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorColumn.setPrefWidth(260);

        TableColumn<Book, Boolean> availableColumn = new TableColumn<>("Available");
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        availableColumn.setPrefWidth(120);

        table.getColumns().setAll(isbnColumn, titleColumn, authorColumn, availableColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
    }

    private void handleAddBook() {
        String isbn = isbnField.getText().trim().replace("-", "").replace(" ", "");
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();

        if (title.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation", "Enter a book title.");
            titleField.requestFocus();
            return;
        }
        if (author.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation", "Enter an author.");
            authorField.requestFocus();
            return;
        }
        if (isbn.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation", "Enter an ISBN.");
            isbnField.requestFocus();
            return;
        }
        if (!isValidIsbn(isbn)) {
            showAlert(Alert.AlertType.WARNING, "Invalid ISBN",
                    "Enter a valid ISBN-10 or ISBN-13, with or without hyphens.");
            isbnField.requestFocus();
            return;
        }
        boolean duplicate = books.stream()
                .anyMatch(book -> book.getIsbn().equalsIgnoreCase(isbn));
        if (duplicate) {
            showAlert(Alert.AlertType.WARNING, "Duplicate ISBN",
                    "A book with this ISBN is already in the catalog.");
            isbnField.requestFocus();
            return;
        }

        books.add(new Book(isbn, title, author, true));
        clearForm();
        statusLabel.setText("Added: " + title);
    }

    private boolean isValidIsbn(String isbn) {
        if (isbn.matches("\\d{9}[\\dXx]")) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int digit = (i == 9 && (isbn.charAt(i) == 'X' || isbn.charAt(i) == 'x'))
                        ? 10 : Character.digit(isbn.charAt(i), 10);
                sum += digit * (10 - i);
            }
            return sum % 11 == 0;
        }
        if (isbn.matches("\\d{13}")) {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                int digit = Character.digit(isbn.charAt(i), 10);
                sum += digit * (i % 2 == 0 ? 1 : 3);
            }
            int checkDigit = (10 - (sum % 10)) % 10;
            return checkDigit == Character.digit(isbn.charAt(12), 10);
        }
        return false;
    }

    private void handleRemoveBook() {
        Book selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.INFORMATION, "Select a book",
                    "Select a book row before removing it.");
            return;
        }
        books.remove(selected);
        statusLabel.setText("Removed: " + selected.getTitle());
    }

    private void handleToggleAvailability() {
        Book selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert(Alert.AlertType.INFORMATION, "Select a book",
                    "Select a book row before checking it out or returning it.");
            return;
        }
        selected.setAvailable(!selected.isAvailable());
        table.refresh();
        statusLabel.setText(selected.getTitle()
                + (selected.isAvailable() ? " is now available." : " has been checked out."));
    }

    private void applySearch(String query) {
        String normalized = query == null ? "" : query.trim().toLowerCase(Locale.ROOT);
        filteredBooks.setPredicate(book -> normalized.isEmpty()
                || book.getTitle().toLowerCase(Locale.ROOT).contains(normalized)
                || book.getAuthor().toLowerCase(Locale.ROOT).contains(normalized));
        long matches = books.stream()
                .filter(book -> book.getTitle().toLowerCase(Locale.ROOT).contains(normalized)
                        || book.getAuthor().toLowerCase(Locale.ROOT).contains(normalized))
                .count();
        statusLabel.setText(normalized.isEmpty()
                ? "Showing all " + books.size() + " book(s)."
                : "Search matches: " + matches);
    }

    private void handleSave() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save Book Catalog");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        chooser.setInitialFileName("books.csv");
        File file = chooser.showSaveDialog(primaryStage);
        if (file == null) {
            statusLabel.setText("Save cancelled.");
            return;
        }
        try {
            CsvBookStorage.save(file.toPath(), books);
            statusLabel.setText("Saved " + books.size() + " book(s) to " + file.getName());
        } catch (IOException | RuntimeException ex) {
            showAlert(Alert.AlertType.ERROR, "Save failed",
                    "The catalog could not be saved: " + ex.getMessage());
        }
    }

    private void handleLoad() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Load Book Catalog");
        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        File file = chooser.showOpenDialog(primaryStage);
        if (file == null) {
            statusLabel.setText("Load cancelled.");
            return;
        }
        try {
            List<Book> loaded = CsvBookStorage.load(file.toPath());
            Set<String> seenIsbns = new HashSet<>();
            for (Book book : loaded) {
                if (!isValidIsbn(book.getIsbn())) {
                    throw new IOException("Invalid ISBN found: " + book.getIsbn());
                }
                if (!seenIsbns.add(book.getIsbn().toLowerCase(Locale.ROOT))) {
                    throw new IOException("Duplicate ISBN found: " + book.getIsbn());
                }
            }
            books.setAll(loaded);
            searchField.clear();
            statusLabel.setText("Loaded " + books.size() + " book(s) from " + file.getName());
        } catch (IOException | RuntimeException ex) {
            showAlert(Alert.AlertType.ERROR, "Load failed",
                    "The catalog was not replaced: " + ex.getMessage());
        }
    }

    private void clearForm() {
        isbnField.clear();
        titleField.clear();
        authorField.clear();
        isbnField.requestFocus();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void stop() {
        // Saving is explicit through Save CSV so that users control file location.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
