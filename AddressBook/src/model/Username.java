package model;

public enum Username {
	Tom17, Pattrick11, Chris20, tErrY, JosEPH;

	public static String getRandomUsername() {
		return Username.values()[(int) (Math.random() * Username.values().length)].toString();
	}
}
