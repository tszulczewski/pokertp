
public abstract class HostingSettings {
	
	private static String numberOfPlayer = "2";
	private static String numberOfBots = "1";
	private static String money = "4000";
	private static String potLimit = "0";
	private static String raiseStyle;
	private static String raiseLimit, raiseValue;
	private static String bigB, smallB;
	

	
	public static void setNumberOfPlayer(Object nop) {
		numberOfPlayer = nop.toString();
		System.out.println("Players: " + numberOfPlayer);
	}
	public static void setNumberOfBots(Object nob) {
		numberOfBots = nob.toString();
		System.out.println("Bots: " + numberOfBots);
	}
	public static void setMoney(Object value) {
		money = value.toString();
		System.out.println("Money: " + money);
	}
	public static void setPotLimit(Object limit) {
		potLimit = limit.toString();
		System.out.println("Pot limit: "+ potLimit);
	}
	public static void setStyle(Object item) {
		raiseStyle = item.toString();	
		System.out.println("Style: " + raiseStyle);
	}
	public static void setRaiseLimit(String limit) {
		raiseLimit = limit;	
		System.out.println("Raise limit: " + raiseLimit);
	}
	public static void setRaiseValue(String value) {
		raiseValue = value;	
		System.out.println("Raise Value: " + raiseValue);
	}
	public static void setBigB(String value) {
		bigB = value;	
		System.out.println("BigB : " + bigB);
	}
	public static void setSmallB(String value) {
		smallB = value;	
		System.out.println("smallB : " + smallB);
	}
	
	
}
