package troyeagle.htmlprocess.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexProcessor {
	private static String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>";
	private static String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>";
	private static String regEx_html="<[^>]+>";
	public static String delHTMLTag(String htmlStr){
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
         
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
         
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 
        
        htmlStr=htmlStr.replaceAll("&nbsp;", " ");
        for(int i=1;i<6;i++){
            htmlStr=htmlStr.replaceAll("\n\n", "\n");	
        }

        return htmlStr.trim(); //返回文本字符串 
        
	}
}
