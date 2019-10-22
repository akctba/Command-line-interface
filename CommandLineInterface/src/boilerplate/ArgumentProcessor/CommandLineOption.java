package boilerplate.ArgumentProcessor;

public class CommandLineOption
	{
		
		public char usedSwitch;
		public String presentArgument;
		public String data;

		public CommandLineOption(String data)
			{
				usedSwitch = data.charAt(0);
				presentArgument = "";
				int aChar = 1;
				for (aChar = 1; aChar < data.length(); aChar++)
					{
					if (data.charAt(aChar) == " ".charAt(0))
						{
							break;
						}
					else
						{
							presentArgument = presentArgument + data.charAt(aChar);
						}
					
					}
				
				for (aChar = aChar; aChar < data.length(); aChar++)
					{
					this.data = this.data + data.charAt(aChar);
					}
				
			}

	}
