package com.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/websocket",configurator=GetHttpSessionConfigurator.class)
public class ChatServer {
	
	//与某个客户端的连接会话(WebSocket Session)，需要通过它来给客户端发送数据
	private Session session;
	//与某个客户端的Http Session，可以获取Http Session中的用户名标识
	private HttpSession httpSession;
	//客户端用户名
	private String username;
	//全局变量用于保存所有socket连接
	private static Set<ChatServer> chatServerLists = new HashSet<>();

	/**
	 * 发送消息给某个用户
	 * @param msg 
	 * @throws IOException 
	 */
	public void sendMsgToUser(String msg) throws IOException {
		String[] temp = msg.split("__####__");
		for (ChatServer item : chatServerLists) {
			if(temp[0]!=null && !"".equals(temp[0]) && temp[0].equals(item.username)){
				item.session.getBasicRemote().sendText(this.username+":"+temp[1]);
			}
		}
	}

	@OnOpen
	public void onopen(Session session, EndpointConfig config) {
		this.session = session;
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		this.username = (String) this.httpSession.getAttribute("username");
		chatServerLists.add(this);
		System.out.println("新用户" + this.username + "连接，当前用户数量：" + chatServerLists.size());
		//TODO 发送消息给所有客户端，以更新在线用户列表状态
	}

	@OnClose
	public void onclose(Session session) {
		chatServerLists.remove(this);
		System.out.println("用户" + this.username + "断开连接，当前用户数量：" + chatServerLists.size());
	}

	@OnMessage
	public void onsend(Session session, String msg) throws IOException {
		sendMsgToUser(msg);
	}
	
	@OnError
	public void onerror(Session session,Throwable error){
		System.out.println("error happened!");
	}

}