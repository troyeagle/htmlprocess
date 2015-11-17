package troyeagle.htmlprocess.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HtmlBasicProcessor {
	private String url;
	private CloseableHttpResponse httpResponse;
	private CloseableHttpClient httpClient;
	public HtmlBasicProcessor(String url) throws ClientProtocolException, IOException{
		this.url=url;
		httpClient = HttpClients.createSystem();
		HttpPost httpPost = new HttpPost(url);
		httpResponse = httpClient.execute(httpPost);
	}

	public InputStream getContentAsStream() throws ClientProtocolException,IOException{		
		HttpEntity entity = httpResponse.getEntity();
		InputStream instream = entity.getContent();
		return instream;
	}
	public BufferedReader getContentAsBuffer() throws ClientProtocolException, IOException{
		InputStreamReader inreader = new InputStreamReader(getContentAsStream(),
				"GB2312");
		return new BufferedReader(inreader);
	}
	public String getContentAsString() throws ClientProtocolException,IOException{
		BufferedReader br = getContentAsBuffer();
		StringBuilder sb = new StringBuilder();
		String line="";
		while((line=br.readLine())!=null){
			line=line.trim();
			sb.append(line);
			sb.append("\n");	

		}
		
		return sb.toString();
	}
	public String getUrl() {
		return url;
	}

	
	
	
}
