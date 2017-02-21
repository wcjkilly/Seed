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
	
	//与某个客户端的连接会话，需要通过它来给客户端发送数据
		private Session session;
		//全局变量用于保存所有socket连接
		private static Set<ChatServer> sockets = new HashSet<>();

		/**
		 * 发送消息给所有在线的用户
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
			System.out.println("新用户" + session.getId() + "连接，当前用户数量：" + sockets.size());
			sendMsgToAll("用户"+session.getId()+"上线啦");
		}

		@OnClose
		public void onclose(Session session) {
			sockets.remove(this);
			System.out.println("用户" + session.getId() + "断开连接，当前用户数量：" + sockets.size());
		}

		@OnMessage
		public void onsend(Session session, String msg) {
			sendMsgToAll("用户"+session.getId()+"说:"+msg);
		}

}