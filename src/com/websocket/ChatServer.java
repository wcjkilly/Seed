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
	
	//��ĳ���ͻ��˵����ӻỰ(WebSocket Session)����Ҫͨ���������ͻ��˷�������
	private Session session;
	//��ĳ���ͻ��˵�Http Session�����Ի�ȡHttp Session�е��û�����ʶ
	private HttpSession httpSession;
	//�ͻ����û���
	private String username;
	//ȫ�ֱ������ڱ�������socket����
	private static Set<ChatServer> chatServerLists = new HashSet<>();

	/**
	 * ������Ϣ��ĳ���û�
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
		System.out.println("���û�" + this.username + "���ӣ���ǰ�û�������" + chatServerLists.size());
		//TODO ������Ϣ�����пͻ��ˣ��Ը��������û��б�״̬
	}

	@OnClose
	public void onclose(Session session) {
		chatServerLists.remove(this);
		System.out.println("�û�" + this.username + "�Ͽ����ӣ���ǰ�û�������" + chatServerLists.size());
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