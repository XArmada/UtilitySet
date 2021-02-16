package com.github.xarmada.utilityset;

public class ProxyUtility {
	public static void setProxy(String host, String port) {
		System.setProperty("socksProxyHost" , host);
		System.setProperty("socksProxyPort" , port);
	}
	public static void removeProxy() {
		System.setProperty("socksProxyHost" , null);
		System.setProperty("socksProxyPort" , null);
	}
	
	public static void setProxy(ProxyVal proxy) {
		System.setProperty("socksProxyHost" , proxy.host);
		System.setProperty("socksProxyPort" , proxy.port);
	}
}
