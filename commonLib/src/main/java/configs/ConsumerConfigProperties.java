package configs;

public enum ConsumerConfigProperties {

	SERVER_ADDRESS("localhost:9092"),
	GROUP_ID_CLIENT("usertopicgroup");
	
	private String value;
	
	
	ConsumerConfigProperties(String enumVal) {
		this.value = enumVal;
	}
	
	public String getEnumVal() {
		return this.value;
	}
}
