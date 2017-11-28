package demo;

import java.util.Collection;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

@SuppressWarnings("deprecation")
public class SendPushService {
	//发送消息
	public static void send(String msg){
		System.out.println("调用了send方法");
		ScriptBuffer scriptBuffer=new ScriptBuffer();/*构建发送所需的JS脚本*/
		WebContext webContext=WebContextFactory.get();
		Collection<ScriptSession> allScriptSessions = webContext.getAllScriptSessions();
		scriptBuffer.appendScript("dwrtest(");//调用客户端的js脚本函数
		scriptBuffer.appendData(msg);//这个msg可以被过滤处理一下，或者做其他的处理操作。这视需求而定。
		scriptBuffer.appendScript(")");
		Util util=new Util(allScriptSessions);
		util.addScript(scriptBuffer);//向客户端推送消息
		
	}
	
}
