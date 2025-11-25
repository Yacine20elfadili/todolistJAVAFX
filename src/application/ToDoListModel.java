package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoListModel {
	private ObservableList<String> tasks;

	public ToDoListModel() {
		tasks = FXCollections.observableArrayList();
	}

	public void addTask(String description) {
		tasks.add(description);
	}

	public void removeTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
		}
	}

	public ObservableList<String> getTasks() {
		return tasks;
	}
}