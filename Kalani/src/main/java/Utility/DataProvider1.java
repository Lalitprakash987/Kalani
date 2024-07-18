package Utility;

import org.testng.annotations.DataProvider;

public class DataProvider1 {
	@DataProvider(name = "contactUsData")
	public Object[][] getData() {
		return new Object[][] {
				{ "Lalit Fatehpuriya", "lalitprakash987@gmail.com", "Physics",
						"Lorem Ipsum is simply dummy text of the printing" },
				{ "John Doe", "john.doe@example.com", "Math", "Sample message for testing" },
				{ "Jane Smith", "jane.smith@example.com", "Chemistry", "Another sample message for testing" } };
	}
}