package com.abdullahteke.main;

import java.util.List;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class Test {

	public static void main(String[] args) {
		
		List<String> stList=null;
		for (String string : stList) {
			System.out.println(string);
		}
		
//	    JSch jsch = new JSch();
////	    jsch.setKnownHosts("/Users/john/.ssh/known_hosts");
//	   
//		try {
//			Properties config= new Properties();
//			config.put("StrictHostKeyChecking", "no");
//			
//			Session jschSession = jsch.getSession("sapmmuser", "10.10.10.39",22);
//
//			jschSession.setConfig(config);
//
//			jschSession.setPassword("gpu2020");
//			
////			Properties configuration = new Properties();
////			configuration.put("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1,diffie-hellman-group-exchange-sha256");
////			JSch.setConfig("kex", "diffie-hellman-group1-sha1,diffie-hellman-group14-sha1,diffie-hellman-group-exchange-sha1,diffie-hellman-group-exchange-sha256");
//
//			jschSession.connect();
//			System.out.println("connected");
//			
//			ChannelSftp channelSftp = (ChannelSftp) jschSession.openChannel("sftp");
//			
//			channelSftp.connect(2000);
//			
//			String remoteDir= "ftp_dir/";
//		    String localDir = "C:\\\\ftp_dir\\";
//
//		    channelSftp.put(localDir+"abc.txt",remoteDir+"abc.test");
//		    channelSftp.disconnect();
//		    jschSession.disconnect();
//
//		} catch (JSchException | SftpException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}


	}

}
