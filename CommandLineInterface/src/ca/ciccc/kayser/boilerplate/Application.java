package ca.ciccc.kayser.boilerplate;

import ca.ciccc.kayser.boilerplate.controller.ApplicationController;
import ca.ciccc.kayser.boilerplate.model.ApplicationModel;
import ca.ciccc.kayser.boilerplate.view.ApplicationView;

public class Application {

	static Application instance;

	ApplicationModel model;
	ApplicationView view;
	ApplicationController controller;

	public static void main(String[] args) {

		if (instance == null)
			instance = new Application(args);

	}

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
			// model.commandLine.add(c);
		}

		view.printCommandLine();

	}

}
