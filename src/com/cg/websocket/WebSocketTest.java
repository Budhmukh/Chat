package com.cg.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket1")
public class WebSocketTest {

  private static Set<Session> clients = 
    Collections.synchronizedSet(new HashSet<Session>());

  @OnMessage
  public void onMessage(String message, Session session ,@PathParam("type-name") String type) 
    throws IOException {
      // Iterate over the connected sessions
      // and broadcast the received message
      //for(Session client : clients){
        //  client.getBasicRemote().sendText(message);
//	  for (Session sess : session.getOpenSessions()) {
  //        if (sess.isOpen())

             session.getBasicRemote().sendText(message);
    //   

        
      
    }

  

  @OnOpen
  public void onOpen (Session session) {
  // Add session to the connected sessions set
    clients.add(session);
  }

  @OnClose
  public void onClose (Session session) {
    // Remove session from the connected sessions set
    clients.remove(session);
  }

}
