import java.util.ArrayList;
import java.util.Date;

import boilerplate.ArgumentProcessor.BaseParser;
import boilerplate.ArgumentProcessor.CommandLineOption;
import boilerplate.Console.BaseConsole;
import boilerplate.Debug.BaseDebug;
import boilerplate.Logging.BaseLogger;
import boilerplate.Testing.BaseTester;

/**
 * @author Ivan Malone
 * 
 *         Boilerplate for a basic CLI based Java Application Boilerplate
 * 
 *         Features
 * 
 * 
 * 
 *
 */
public class Application {
	// These are STATIC variables
	private static Application instance;

	final static private boolean logStartupToScreen = true;

	final static private Date date = new java.util.Date();

	final static private String _APP_VERSION = "0.0.1";

	final static private int _STARTUP = 0;
	final static private int _INFO = 1;
	final static private int _WARN = 2;
	final static private int _ERROR = 3;
	final static private int _EXCEPTION = 4;
	final static private int _SHUTDOWN = 5;

	static public boolean terminateApplication = true;

	// These are INSTANCE variables, they only exist within an 'instance' of
	// Application and are unique per Instance
	private BaseParser parser = new BaseParser();

	// METHODS
	final static private void log(int level, String message) {
		if (logStartupToScreen) {
			switch (level) {
			case 0: {
				System.out.println("[" + date + "]" + " - [Startup] - " + message);
				break;
			}
			case 1: {
				System.out.println("[" + date + "]" + " - [Info] - " + message);
				break;
			}
			case 2: {
				System.out.println("[" + date + "]" + " - [Warning] - " + message);
				break;
			}
			case 3: {
				System.out.println("[" + date + "]" + " - [Error] - " + message);
				break;
			}
			case 4: {
				System.out.println("[" + date + "]" + " - [Exception] - " + message);
				break;
			}
			case 5: {
				System.out.println("[" + date + "]" + " - [Shutdown] - " + message);
				break;
			}
			default: {
				System.out.println("[" + date + "]" + " - [Unknown] - " + message);
				break;
			}

			}

		}
	}

	final static private void log(String message) {
		log(_INFO, message);
	}

	final static private void println(String message) {
		log(_INFO, "println(\"" + message + "\")");
		System.out.println(message);

	}

	final static private void print(String message) {
		log(_INFO, "print(" + message + ")");
		System.out.print(message);
	}

	final static private void showBasicUsageInformation() {
		log("showBasicUsageInformation()");
		if (instance != null) {
			println(instance.parser.generateUsageInformation());
		}

	}

	public static void main(String[] args) {
		log(_STARTUP, "main(args.length = " + args.length + ")");

		try {
			println("Starting Application");
			Application app = new Application(args);
			if (args.length == 0) {
				log(_WARN,
						"No command line arguments to parse, not sure what to do so calling showBasicUsageInformation()");
				showBasicUsageInformation();
				terminateApplication = true;
			} else {
				log(_INFO, "At this point we will have parsed for all the following command line arguments");
				for (int i = 0; i < args.length; i++) {
					log(_INFO, "args[" + i + "] = " + args[i]);
				}

				terminateApplication = false;
			}

			if (terminateApplication == false) {
				log(_INFO, "Entering application Main Loop");
				do {

				} while (terminateApplication == false);
				log(_INFO, "Leaving application Main Loop");
			}
		} catch (Exception anException) {
			log(_EXCEPTION, "" + anException);
		} finally {
			log(_SHUTDOWN, "Application Terminated");
		}

	}

	BaseConsole consoleHelper = new BaseConsole();
	BaseDebug debugHelper = new BaseDebug();
	BaseLogger logger = new BaseLogger();
	BaseTester tester = new BaseTester();

	char _extractSwitch(String fromString) {
		return fromString.charAt(0);
	}

	String _extractArgument(String fromString) {
		String temp = "";
		for (int i = 0; i < fromString.length(); i++) {
			if (fromString.charAt(i) == " ".charAt(0))
				break;
			temp = temp + fromString.charAt(i);
		}
		return temp;
	}

	String _extractData(String fromString) {
		return fromString;
	}

	Application(String[] arguments) {
		Application.log("Application Constructor Called");
		if (Application.instance == null) {
			Application.instance = this;

			if (arguments.length > 0) {
				Application.terminateApplication = false;

				for (int i = 0; i < arguments.length; i++) {
					if (parser.isSwitchSupported(_extractSwitch(arguments[i])) == true) {
						if (parser.isArgumentSupported(_extractArgument(arguments[i])) == true) {
							CommandLineOption anOption = new CommandLineOption(arguments[i]);
							log(_INFO, anOption.toString());
						}
					}
				}
			} else {
				Application.terminateApplication = true;
			}

		} else {
			Application.log(_ERROR,
					"Detected an existing instance, this shouldn't be the case! " + Application.instance.toString());
			Application.terminateApplication = true;
		}

	}

}
