package Complete_Concurrent_Collections.SingletonPattern;

public enum EnumSingleton {
	INSTANCE;

	public static EnumSingleton getInstance(){
		return  INSTANCE;
	}
}
