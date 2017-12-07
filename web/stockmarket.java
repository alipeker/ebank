package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import usefulmethods.WriteFile;
import java.net.MalformedURLException;

public class stockmarket {

	public static void main() throws IOException {
		readFromWeb("http://uzmanpara.milliyet.com.tr/canli-borsa/");
		readFromWeb2("http://www.bloomberght.com/doviz/dolar");
	}

	public static void readFromWeb2(String webURL) throws IOException {
		URL url = new URL(webURL);
		InputStream is =  url.openStream();
		try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null) {
				if(line.trim().startsWith("<table class=\"table table-striped table-hover tableHeadRowStyle3 marketsData mar0\">")){
					String htmldata="<html><body>"+line;
					while(!line.trim().startsWith("</table>")){
						line = br.readLine();
						if(!line.trim().startsWith("<img")){
							htmldata=htmldata.concat(line);
						}
					}
					htmldata=htmldata.concat("</body></html>");
					WriteFile.writefile("D:\\javaworks\\ebank\\webpages\\third.html", htmldata);
				}
			}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MalformedURLException("URL is malformed!!");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}

	public static void readFromWeb(String webURL) throws IOException {
		URL url = new URL(webURL);
		InputStream is =  url.openStream();
		try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line = br.readLine()) != null) {
				if(line.trim().startsWith("<div class=\"box box10\" id=\"acik_koyu_yeri\">")){
					String htmldata="<html><body>"+line;
					while(!line.trim().startsWith("</div>")){
						line = br.readLine();
						htmldata=htmldata.concat(line);
					}
					htmldata=htmldata.concat("</body></html>");
					WriteFile.writefile("D:\\javaworks\\ebank\\webpages\\first.html", htmldata);
				}
				else if(line.trim().startsWith("<div class=\"box box10 last\" id=\"acik_koyu_yeri3\">")){
					String htmldata="<html><body>It refreshes every one minute."+line;
					while(!line.trim().startsWith("</div>")){
						line = br.readLine();
						htmldata=htmldata.concat(line);
					}
					htmldata=htmldata.concat("</body></html>");
					WriteFile.writefile("D:\\javaworks\\ebank\\webpages\\second.html", htmldata);
				}
			}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
			throw new MalformedURLException("URL is malformed!!");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new IOException();
		}
	}
}