
public abstract class HostingSettings {
	
	private static String numberOfPlayer = "2";
	private static String numberOfBots = "1";
	private static String money = "4000";
	
	public static void setNumberOfPlayer(Object nop) {
		numberOfPlayer = nop.toString();
		System.out.println(numberOfPlayer);
	}
	public static void setNumberOfBots(Object nob) {
		numberOfBots = nob.toString();
		System.out.println(numberOfBots);
	}
	public static void setMoney(Object value) {
		money = value.toString();
		System.out.println(money);
	}
	
}
