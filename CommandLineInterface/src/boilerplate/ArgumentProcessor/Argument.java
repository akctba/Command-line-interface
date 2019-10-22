package boilerplate.ArgumentProcessor;

import java.util.ArrayList;

class Argument
	{
		public ArrayList<String> argument = new ArrayList<String>();
		public boolean hasParamaters;
		public boolean requiresParamaters;
		public boolean caseSensitive;
		public String description;


		public Argument(String aSupportedArgument, boolean hasParamaters, boolean requiresParamaters, boolean caseSensitive, String description)
			{
				this.argument.add(aSupportedArgument);
				this.hasParamaters = hasParamaters;
				this.requiresParamaters = requiresParamaters;
				this.caseSensitive = caseSensitive;
				this.description = description;
			}

		public Argument(String[] SupportedArguments, boolean hasParamaters, boolean requiresParamaters, boolean caseSensitive, String description)
			{
				for (int i = 0; i < SupportedArguments.length; i++)
					{
						this.argument.add(SupportedArguments[i]);
					}
				this.hasParamaters = hasParamaters;
				this.requiresParamaters = requiresParamaters;
				this.caseSensitive = caseSensitive;
				this.description = description;
			}

	}