import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class loginToSense {
	private HttpURLConnection connection;
	private URL sense_login;
	private String session_id;

	public loginToSense(String username, String password) throws Exception {
		sense_login = new URL("http://api.sense-os.nl/login.json");
		connection = (HttpURLConnection) sense_login.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setConnectTimeout(5000);
		OutputStream out = connection.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.print("{\"username\":\"" + username + "\",\"password\":\""
				+ password + "\"}");
		pw.flush();
		pw.close();
		String session_cookie = connection.getHeaderField("Set-Cookie");
		// and InputStream from here will be body
		connection.getInputStream();
		session_id = session_cookie.substring(session_cookie.indexOf("=") + 1,
				session_cookie.length());
	}

	public String getSessionId() {
		return session_id;
	}
}
