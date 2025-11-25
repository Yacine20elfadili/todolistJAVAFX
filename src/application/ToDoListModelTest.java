package application;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ToDoListModelTest {
	private ToDoListModel todoModel;

	@Before
	public void setUp() {
		todoModel = new ToDoListModel();
	}

	@Test
	public void testAddTask() {
		todoModel.addTask("Buy groceries");
		assertEquals(1, todoModel.getTasks().size());
		assertEquals("Buy groceries", todoModel.getTasks().get(0));
	}

	@Test
	public void testRemoveTask() {
		todoModel.addTask("Task 1");
		todoModel.addTask("Task 2");
		todoModel.removeTask(0);
		assertEquals(1, todoModel.getTasks().size());
		assertEquals("Task 2", todoModel.getTasks().get(0));
	}

	@Test
	public void testRemoveInvalidIndex() {
		todoModel.addTask("Task 1");
		todoModel.removeTask(5);
		assertEquals(1, todoModel.getTasks().size());
	}

	@Test
	public void testEmptyList() {
		assertEquals(0, todoModel.getTasks().size());
	}

	@Test
	public void testMultipleTasks() {
		todoModel.addTask("Task 1");
		todoModel.addTask("Task 2");
		todoModel.addTask("Task 3");
		assertEquals(3, todoModel.getTasks().size());
	}
}