package config;

public interface DBConfig {
	public String DB_URL = "jdbc:oracle:thin:@//192.168.5.101:1521/xe";
	public String DB_DRIVER = "oracle.jdbc.OracleDriver";
	public String DB_USER = "scott";
	public String DB_PASS = "tiger";
}
