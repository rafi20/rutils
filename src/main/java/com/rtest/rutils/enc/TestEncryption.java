package com.rtest.rutils.enc;

import java.security.MessageDigest;

public class TestEncryption {

	public static void main(String[] args) throws Exception {
		deCrypt();
	}
	
	private static void deCrypt() throws Exception {
		String downloadId="1cacc0ca-45c3-415b-8ba4-b5fa958a74eb";
		String instanceId="3f965370-1b37-43f6-a938-480fd2411dbc";
		System.out.println("============"+ getHashData(downloadId, instanceId));
	}
	
	// This generates the passwdord from download uuid and connection id
	private static String getHashData(String downloadId, String instanceId) throws Exception
	{
	    MessageDigest md5 = MessageDigest.getInstance("MD5");
	md5.update(downloadId.getBytes("UTF-8"));
	md5.update(instanceId.getBytes("UTF-8"));
	    byte[] digest = md5.digest();
	StringBuilder sb = new StringBuilder();
	    for(byte b : digest)
	    {
	        // Make it ascii greater than SPACE(32) and less than DEL(127)
	        // Key stores have issues with non ascii chars and chars outside
	        // the above range
	int i = Math.abs((int)b);
	        if (i > 126)
	            i %= 127; // This will be less than 127
	if(i < 33)
	            i += 33;
	sb.append((char)i);
	}
	    return sb.toString();
	}

}
