module ToDoListFX {
	requires javafx.controls;
	requires junit;

	exports application;
	opens application to javafx.graphics, javafx.fxml;
}