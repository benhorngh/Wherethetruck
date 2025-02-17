
public class Main {
	
	
	public static final String folder = "pfls"; 


	public static void main(String[]args){

		String username = "";
		String password = "";

		start(username, password);

	}
	static Play play;
	static Thread tr;
	
	public static void THROW(){
		stop();
		mainScreen.writeToLog("incorrect");		
		
	}
	
	
	public static void start(String username, String password){
		
		if((username == null) || (password == null) 
				|| (username.isEmpty()) || (password.isEmpty())){
			THROW();
			return;
		}
		
		play = new Play(username,password);
		tr = new Thread(play);

		try{
			tr.start();
		}catch(Exception e){e.printStackTrace();
		stop();
		return;}
	}

	public static void stop(){
	
		try{
			play.active = false;
			play.turnOff();
		}catch(Exception e){e.printStackTrace();}

		try{
			tr.interrupt();
		}catch(Exception e){e.printStackTrace();}

	}


}
