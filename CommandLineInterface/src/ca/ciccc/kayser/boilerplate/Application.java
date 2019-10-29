package ca.ciccc.kayser.boilerplate;

import ca.ciccc.kayser.boilerplate.controller.ApplicationController;
import ca.ciccc.kayser.boilerplate.model.ApplicationModel;
import ca.ciccc.kayser.boilerplate.test.Test;
import ca.ciccc.kayser.boilerplate.view.ApplicationView;

public class Application {

	static Application instance;

	ApplicationModel model;
	ApplicationView view;
	ApplicationController controller;

	// A Reference to our CommandLine object we created in CommandLine.java
	private static CommandLine cmdLine;

	// Set a default value to false will keep our program running
	private static boolean _shouldTerminate = false;

	// If true, we will run our tests
	private static boolean _shouldRunTests = false;

	private static Keyboard kb = new Keyboard();

	void initialize() {

		// initialize
		this.model = new ApplicationModel();
		this.view = new ApplicationView();
		this.controller = new ApplicationController();

		model.setController(controller);
		model.setView(view);

		view.setController(controller);
		view.setModel(model);

		controller.setModel(model);
		controller.setView(view);

	}

	Application(String[] args) {
		initialize();

		for (String c : args) {
			controller.addCommandLineArgument(c);

		}

		view.printCommandLine();

	}

	public static void main(String[] args) {
		
		// create the singleton instance
		if (instance == null)
			instance = new Application(args);

		// create an 'instance' of CommandLine object with the name cmdLine
		cmdLine = new CommandLine(args); 
		// give it 'args' so that it knows what arguments were used (if any) on startup

		// set this depending on if -runTests is on the command line or not
		_shouldRunTests = cmdLine.doesArgumentExists("-runTests");
		
		// should we run our tests?
		if (_shouldRunTests == true) {
			Debug.log("Found -runTests in argument list: - will run tests now");
			// lets run some tests
			// Test.Test_Console_RunAll();
			// Test.Test_MathRunAll();
		}

		String inputText = "";
		int numa = 0;
		int numb = 0;

		do {
			// this code will be run at least 'once' and if _shouldTerminate == false, 
			// then it will continue to loop
			Console.println("Type some text ");
			inputText = kb.nextLine();
			Console.newLine(2);

			Console.println("You typed", inputText);
			Console.newLine(2);

			if (isToQuit(inputText)) {
				Console.newLine(2);
				Console.println("Ending Program", inputText);
				_shouldTerminate = true;
			}

			if (isToTest(inputText)) {
				Console.newLine(2);
				Console.println("Running Tests", inputText);
				Test.Test_Console_RunAll();
				Test.Test_MathRunAll();
			}
			// will only exit if _shouldTerminate is true
		} while (_shouldTerminate == false); 

	}
	
	/**
	 * Verify if a command is to exit the application
	 * @param command
	 * @return
	 */
	private static boolean isToQuit(String command) {
		String[] exitCommands = {"quit", "exit", "end"};
		for(String c : exitCommands) {
			if (c.equalsIgnoreCase(command))
				return true;
		}
		
		return false; 
	}
	
	/**
	 * Verify if a command is to run the application tests
	 * @param command
	 * @return
	 */
	private static boolean isToTest(String command) {
		String[] exitCommands = {"test", "tests", "verification"};
		for(String c : exitCommands) {
			if (c.equalsIgnoreCase(command))
				return true;
		}
		
		return false; 
	}

}
