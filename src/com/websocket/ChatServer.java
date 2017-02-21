package com.websocket;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class ChatServer {
	
	//��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
		private Session session;
		//ȫ�ֱ������ڱ�������socket����
		private static Set<ChatServer> sockets = new HashSet<>();

		/**
		 * ������Ϣ���������ߵ��û�
		 * @param msg 
		 */
		public void sendMsgToAll(String msg) {
			for (ChatServer item : sockets) {
				try {
					item.session.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}
			}
		}

		@OnOpen
		public void onopen(Session session) {
			this.session = session;
			sockets.add(this);
			System.out.println("���û�" + session.getId() + "���ӣ���ǰ�û�������" + sockets.size());
			sendMsgToAll("�û�"+session.getId()+"������");
		}

		@OnClose
		public void onclose(Session session) {
			sockets.remove(this);
			System.out.println("�û�" + session.getId() + "�Ͽ����ӣ���ǰ�û�������" + sockets.size());
		}

		@OnMessage
		public void onsend(Session session, String msg) {
			sendMsgToAll("�û�"+session.getId()+"˵:"+msg);
		}

}