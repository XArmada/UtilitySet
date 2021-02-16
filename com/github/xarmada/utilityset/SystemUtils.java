package com.github.xarmada.utilityset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class SystemUtils {
	public static String getPublicIP() {
		String ip = "None";
		
		
		try {
			URL whatismyip = new URL("https://api.ipify.org/");
			BufferedReader in = new BufferedReader(new InputStreamReader(
			                whatismyip.openStream()));
			
			ip = in.readLine();
		} catch (IOException e) {
			throw new UtilityException("Error while trying to get public ip! Stack trace: " + e.getSuppressed());
		}
		
		if(ip == "None") {
			throw new UtilityException("FATAL ERROR: Could not read ip! This should be impossible.");
		}
		
		
		return ip;
	}
	
	
	public static String getHWID() {

        String s = "";
        final String main = System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("COMPUTERNAME") + System.getProperty("user.name").trim();
        byte[] bytes = null;
		try {
			bytes = main.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			throw new UtilityException("Error while trying to get HWID! Could not get UTF-8 bytes! Stack trace: " + e1.getSuppressed());
		}
        MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new UtilityException("Error while trying to get HWID! MessageDigest was inaccessable. Stack trace: " + e.getSuppressed());
		}
        final byte[] md5 = messageDigest.digest(bytes);
        int i = 0;
        for (final byte b : md5) {
            s += Integer.toHexString((b & 0xFF) | 0x300).substring(0, 3);
            if (i != md5.length - 1) {
                s += "";
            }
            i++;
        }
        return s;
    }
	
	
	
	
	public static List<String> readTextFromURL(URL url) {

        List<String> temp = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            for (String s; (s = reader.readLine()) != null; ) {
                temp.add(s);
            }
        } catch (IOException e) {
        	throw new UtilityException("Error while reading text from URL! Could not initialize bufferedreader! stack trace: " + e.getSuppressed());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                	throw new UtilityException("Error while reading text from URL! Could not close reader! stack strace: " + e.getSuppressed());
                }
            }
        }

        return temp;
    }
}
