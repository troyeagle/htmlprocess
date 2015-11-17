package troyeagle.htmlprocess;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import troyeagle.htmlprocess.basic.HtmlBasicProcessor;
import troyeagle.htmlprocess.basic.RegexProcessor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			HtmlBasicProcessor tss=new HtmlBasicProcessor("http://218.94.159.102/tss/en/c1008/forum/viewTopic/8356.html");
			String raw=tss.getContentAsString();
			String content=RegexProcessor.delHTMLTag(raw);
			String[] split=content.split("Re:2014-2015-2本三、本四选课说明");
			for(int i=1;i<split.length;i++){
				String[] anothersplit=split[i].split("\n");
				for(int j=3;j<anothersplit.length;j++){
					System.out.print(anothersplit[j].trim()+"\t");
				}
				System.out.println();
			}
			//System.out.println(content);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
