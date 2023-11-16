package utils;

public class LoginForm {

	
		private String name;
		private String password;
	
		LoginForm(String name ,String password)
		{
			this.name = name ;
			this.password = password;
		}
		
		public String toString()
		{
			return ("User "+name+" has password "+ password);
		}
		
		public String getName()
		{
			return name;
		}
	
		public String getPassword()
		{
			return password;
		}
}
