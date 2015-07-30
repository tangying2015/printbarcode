package com.eastsoft.comm.ptl.ssc;
/**
 * 编码修改为UTF-8
 */
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.eastsoft.comm.Iresponse;
import com.eastsoft.comm.IshowMsg;
import com.eastsoft.ptl.Tssc1650;
import com.eastsoft.ui.MainUI;
import com.eastsoft.util.ByteUtil;

public class CommHandler extends IoHandlerAdapter {

	private IshowMsg ishowMsg;
	private Iresponse response;
	private int res = MainUI.getResponseNum();
	public void setIshowMsg(IshowMsg ishowMsg) {
		this.ishowMsg = ishowMsg;
	}

	public CommHandler(IshowMsg ishowMsg) {
		super();
		this.ishowMsg = ishowMsg;
	}
	public CommHandler(IshowMsg ishowMsg,Iresponse response) {
		this(ishowMsg);
		this.response = response;
		
		
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception
	{
		cause.printStackTrace();
	}


	@Override
	public void sessionClosed(IoSession session) throws Exception {
		if (session == null) {
			return;
		}
		session.close(true);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception
	{

		byte buf[] = (byte[]) message;
		
	//	String str = ByteUtil.byteArrayToHexStr(buf);

	//	System.out.println("Received message:0x" + str);

		/*		if (session.isConnected()) {
					session.write(buf);
				}
		*/
//		System.out.println("Message written...");

		recData(session, buf);

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception
	{
		System.out.println("IDLE " + session.getIdleCount(status));
	}

	public void broadcast(String key, byte[] buf) {
	}

	private StringBuffer recevivebuf_final_aid = new StringBuffer(1000);
	private StringBuffer recevivebuf_temp_aid = new StringBuffer(1000);
	private boolean Flag_final;
	private boolean Flag_temp;
	public static final byte TEMP_Flag = -128;
	public static final byte FINAL_Flag = -127;
	
	private void recData(IoSession session, byte[] buf) throws Exception {
	//	byte[] a = {'a','b','c','d','\n','\n','a','b','c','d','\n','\n','a','b','c','d','\n','\n','a','b','c','d','\n','\n','a','b','c','d','\n','\n','a','b','c','d','\n','\n','a','b','c','d','\n','\n','a','b','c','d','\n','\n',-127,'A','I','D','1','2','3','4','5','6','\n','s'};
		//ishowMsg.showAllReceive(new String(a));
		ishowMsg.showAllReceive(new String(buf));
		
		char[] temp = new char[buf.length] ;
		for (int i = 0; i < buf.length; i++) {
			temp[i] = (char) buf[i];
			if((byte)temp[i] == (byte)-126){
				System.out.print("出现:"+(130));
				recevivebuf_temp_aid.delete(0, 1000);
				recevivebuf_final_aid.delete(0, 1000);
				Flag_final = false;
				Flag_temp = false;
			}
			if((byte)temp[i] == (byte)-127){
				System.out.print("出现:"+(-127));
				Flag_final = true;
				
			}
			if((byte)temp[i] == (byte)-128){
				System.out.print("出现:"+(-128));
				if(res == 0){
					Flag_temp = false;
					response.responsePassword();
				}else if(res == 1){
					Flag_temp = true;
				}
			}
		}
		if(Flag_temp){
			recevivebuf_temp_aid.append(temp);
			parseAidFromBuf(recevivebuf_temp_aid,TEMP_Flag);
		}
		
		if(Flag_final){
			recevivebuf_final_aid.append(temp);
			parseAidFromBuf(recevivebuf_final_aid,FINAL_Flag);
		}
		
		
		
		if(recevivebuf_final_aid.length() == 1000){
			recevivebuf_final_aid.delete(0, recevivebuf_final_aid.length()/2);
		}
		if(recevivebuf_temp_aid.length() == 1000){
			recevivebuf_temp_aid.delete(0, recevivebuf_temp_aid.length()/2);
		}
	}
	
	
	
	private void parseAidFromBuf(StringBuffer sb,byte flag){
		int i = 0;
		while(i < sb.length()){
			
			if((byte)sb.charAt(0) == TEMP_Flag){
				System.out.print("再次出现:"+(-128));
			}
			if((byte)sb.charAt(0) == FINAL_Flag){
				System.out.print("再次出现:"+(-127));
			}
			 
			if((byte)sb.charAt(0) != flag){
				sb.deleteCharAt(0);
			}
			else
			{
				for (int j = 1; j < sb.length(); j++) {
					if(sb.charAt(j) == '\r'||sb.charAt(j) == '\n'){
						String aidstring  = null;
						switch (flag) {
						case FINAL_Flag://response final aid startPrint
							aidstring = sb.substring(4,j);
							ishowMsg.startPrint(aidstring);//print pic
							recevivebuf_temp_aid.delete(0, 1000);
							recevivebuf_final_aid.delete(0, 1000);
							Flag_final = false;
							Flag_temp = false;
							break;
						case TEMP_Flag://temp aid  response passwd
							aidstring = sb.substring(1,j);
							response.responsePassword(aidstring);
							recevivebuf_temp_aid.delete(0, 1000);
							break;
							
						default:
							break;
						}
						
						return ;
					}else{
						continue;
					}
				}
				return;
			}
		}
	}
	


}
