import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class loginToSense {
	private HttpURLConnection connection;
	private URL sense_login;
	private String session_id;

	/**
	 * klasse die inlogt in sense via JSON
	 * 
	 * @param username
	 *            sense gebruikersnaam
	 * @param password
	 *            MD5 encoded wachtwoord
	 * @throws Exception
	 *             gooit exception als er iets mis is met de htto aanvraag
	 */

	public loginToSense(String username, String password) {
		try {
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
			session_id = session_cookie.substring(
					session_cookie.indexOf("=") + 1, session_cookie.length());
			out.close();
			connection.disconnect();
		} catch (Exception e) {
			session_id = null;
		}
	}

	/**
	 * geeft een session ID terug voor sense
	 * 
	 * @return de session ID
	 */
	public String getSessionId() {
		return session_id;
	}
}
