package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	private ToDoListModel todoModel;
	private ListView<String> taskListView;
	private TextField taskInput;

	@Override
	public void start(Stage primaryStage) {
		todoModel = new ToDoListModel();

		// Input section
		taskInput = new TextField();
		taskInput.setPromptText("Enter a task...");
		Button addBtn = new Button("Add");
		HBox inputBox = new HBox(10, taskInput, addBtn);
		inputBox.setPadding(new Insets(10));

		// Task list display
		taskListView = new ListView<>();
		refreshTaskList();

		// Remove button
		Button removeBtn = new Button("Remove Selected");
		HBox buttonBox = new HBox(10, removeBtn);
		buttonBox.setPadding(new Insets(10));

		// Main layout
		VBox root = new VBox(10, inputBox, taskListView, buttonBox);
		root.setPadding(new Insets(10));

		// Event handlers
		addBtn.setOnAction(e -> {
			String task = taskInput.getText();
			if (!task.isEmpty()) {
				todoModel.addTask(task);
				taskInput.clear();
				refreshTaskList();
			}
		});

		removeBtn.setOnAction(e -> {
			int selected = taskListView.getSelectionModel().getSelectedIndex();
			if (selected >= 0) {
				todoModel.removeTask(selected);
				refreshTaskList();
			}
		});

		// Scene and stage
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("To-Do List");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void refreshTaskList() {
		taskListView.setItems(todoModel.getTasks());
	}

	public static void main(String[] args) {
		launch(args);
	}
}