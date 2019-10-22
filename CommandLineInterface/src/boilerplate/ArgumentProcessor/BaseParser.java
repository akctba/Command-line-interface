package boilerplate.ArgumentProcessor;

import java.util.ArrayList;
import java.util.Random;

public class BaseParser
	{
		private ArrayList<Switch> switches = new ArrayList<Switch>();
		private ArrayList<Argument> arguments = new ArrayList<Argument>();
		
		private void addDefaultSwitches()
			{
		    char[] defaultSwitches = {'-','/'};
		    for (int i = 0; i < defaultSwitches.length; i++)
		    	{
		    	switches.add(new Switch(defaultSwitches[i]));
		    	}
			}
		
		private void addDefaultArguments()
			{
			String[] help = {"help","h","?"};
			Argument h = new Argument(help[0],false,false,false, "Show basic help information");
			for (int i = 1; i < help.length; i++)
			    	{
			    	h.argument.add(help[i]);
			    	}
			arguments.add(h);
			    
			String[] version = {"v","ver"};
			Argument v = new Argument(version[0],false, false, false, "Shows version information");
			for (int i = 1; i < version.length; i++)
			    	{
			    	h.argument.add(version[i]);
			    	}
			arguments.add(v);
			}
		
		public boolean isSwitchSupported(char aSwitch)
			{
			for (int i = 0; i < switches.size(); i++)
				{
					if (switches.get(i).switchCharacter == aSwitch)
						{
							return true;
						}
				}
			return false;
			}
		
		public boolean isSwitchSupported(Switch aSwitch)
			{
			return isSwitchSupported(aSwitch.switchCharacter);
			}
		
		public boolean isArgumentSupported(String argument)
			{
			for (int i = 0; i < arguments.size(); i++)
				{
					if (arguments.get(i).argument.contains(argument)) return true;
				}
			return false;
			}
		
		public boolean isArgumentSupported(Argument argument)
			{
			for (int i = 0; i < argument.argument.size(); i++)
				{
				if (isArgumentSupported(argument.argument.get(i))) 
						{
							return true;
						}
				}
			return false;
			}
		
		public boolean doesArgumentRequireParamaters(String argument)
		{
			for (int i = 0; i < arguments.size(); i++)
				{
					if (arguments.get(i).argument.contains(argument) == true)
						{
						return arguments.get(i).requiresParamaters;
						}
				}
			return false;
		}
			
	
		public String generateUsageInformation()
		{	final int _EXAMPLE_USAGE_COUNT = 3;
		
			String message = "Usage Information\n";
			
			message = message + "Valid Switches are;\n";
			for (int i = 0; i < switches.size(); i++)
				{
					if (i == 0) message = message + "\t\t";
					message = message + "  " +  String.valueOf(switches.get(i).switchCharacter);
				}
			
			message = message + " - Default Switch is " + String.valueOf(switches.get(0).switchCharacter) + "\n";
			
			message = message + "\n This means you should type \"" + getAppName() + "\" followed by one or more switches then an argument (with or without paramaters), as described below\n";
			
			message = message + "\n";
			
			message = message + "Valid Arguments are;\n";
			
			for (int argIndex = 0; argIndex < arguments.size(); argIndex++)
				{
				for (int altArgIndex = 0; altArgIndex < arguments.get(argIndex).argument.size(); altArgIndex++)
					{					
					if (altArgIndex == 0)
						{
						message = message + "\t'" + switches.get(0).switchCharacter + arguments.get(argIndex).argument.get(altArgIndex) + "'\n";
						message = message + "\t" + arguments.get(argIndex).description + "\n";
						if (arguments.get(argIndex).argument.size() > 0)
							{
								message = message +"\tYou may also use; ";
							}
						}
					else
						{
						message = message + " '" + arguments.get(argIndex).argument.get(altArgIndex) + "',";
						}
					
					
					}
				message = message + "\n";
				message = message + "\t\tTakes Paramaters: " + arguments.get(argIndex).hasParamaters + "\n";
				message = message + "\t\tRequires Paramaters: " + arguments.get(argIndex).requiresParamaters + "\n";
				message = message + "\t\tCase Sensitive: " + arguments.get(argIndex).caseSensitive + "\n";
				message = message + "\n";
				}
			
			message = message + "\nRandomly Generated Examples\n";
			
			Random random = new Random();
			int rndSwitch;
			int rndArg;
			int rndAlt;
			String usageExample;
			for (int exampleCount = 0; exampleCount < _EXAMPLE_USAGE_COUNT; exampleCount++)
				{
					rndSwitch = random.nextInt(switches.size());
					rndArg = random.nextInt(arguments.size());
					rndAlt = random.nextInt(arguments.get(rndArg).argument.size());
					
					usageExample = "\n\t" + getAppName() + "\t" + switches.get(rndSwitch).switchCharacter + arguments.get(rndArg).argument.get(rndAlt) +  "\t\t- " +  arguments.get(rndArg).description + "\n";
					message = message + usageExample;					
					usageExample = "";
				}
			
		
			return message;
		}
		

		final  private String getAppName()
		{
			if (System.getProperty("program.name") == null)
				{
					return "program";
				}
			else
				{
					return System.getProperty("program.name");
				}
		}
		

		public BaseParser()
			{
			addDefaultSwitches();
			addDefaultArguments();
			}
		
	

	}
