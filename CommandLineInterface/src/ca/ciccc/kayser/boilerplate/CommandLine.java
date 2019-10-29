package ca.ciccc.kayser.boilerplate;

public class CommandLine {
	
	private String[] arguments = new String[0];

	public CommandLine(String[] arguments) {
		// the constructor will be called with whatever arguments (if any) were
		// known from the 'main' method

		// initialize our internal argument array to the same size as the one passed to
		// the constructor
		this.arguments = new String[arguments.length];

		// begin a loop and start copying arguments to this.arguments, one element at a
		// time
		for (int i = 0; i < arguments.length; i++) {
			this.arguments[i] = arguments[i];
		}
		// now we have saved a copy of the arguments

	}

	public boolean doesArgumentExists(String argument) {
		for (int i = 0; i < this.arguments.length; i++) {
			if (this.arguments[i].contains(argument)) {
				return true;
			}
		}
		return false;
	}

	public int getArgumentIndex(String argument) {
		for (int i = 0; i < this.arguments.length; i++) {
			if (this.arguments[i].contains(argument)) {
				return i;
			}
		}
		return -1;
	}
}
