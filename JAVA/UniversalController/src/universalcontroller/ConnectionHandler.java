/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcontroller;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anshal dwivedi
 * IT,MNNIT Allahabad
 * anshaldwivedi@gmail.com
 */
public class ConnectionHandler {
    public final static int FRONT = 3;
    public final static int FRONT_RIGHT = 4;
    public final static int RIGHT = 5;
    public final static int RIGHT_BOTTOM = 6;
    public final static int BOTTOM = 7;
    public final static int BOTTOM_LEFT = 8;
    public final static int LEFT = 1;
    public final static int LEFT_FRONT = 2;
    public final static int CENTER=9;
    public ServerSocket serv_sock;
    public Socket sock;
    public DataInputStream dis;
    
        public void startConnection()
    {
        Connection con=new Connection();
        con.start();
    }
    public void pressedA(){
       //override this function where you extend this class
    }
    public void pressedB(){
        //override this function where you extend this class
    }
    public void pressedX(){
        //override this function where you extend this class
    }
    public void pressedY(){
        //override this function where you extend this class
    }
    public void pressedS1(){
        //override this function where you extend this class
    }
    public void pressedS2(){
        //override this function where you extend this class
    }
    public void joyStickMoves(int angle,int power,int direction)
    {
        //override this function where you extend this class
    }
     
    public class Connection extends Thread{  // It initialize and handles the connections
        public void run(){
            try {
                serv_sock=new ServerSocket(11000);
                sock=serv_sock.accept();
                System.out.println("Connected");
                dis=new DataInputStream(sock.getInputStream());
                while(true)
                {
                    int a=dis.readInt();
                    if(a==1)
                    {
                        String s=dis.readUTF();
                        if(s.equals("A")){
                             pressedA();
                        }  
                        else if(s.equals("B")){
                             pressedB();
                        }
                           
                        else if(s.equals("X"))
                        {
                              pressedX();
                        }
                          
                        else if(s.equals("Y"))
                        {
                            pressedY();
                        }
                        else if(s.equals("S1"))
                        {
                            pressedS1();
                        }
                        else if(s.equals("S2"))
                        {
                            pressedS2();
                        }
                            
                    }
                    else
                    {
                        int  angle=dis.readInt();
                        int  power=dis.readInt();
                        int direction=dis.readInt();
                        System.out.println(angle+" "+power+" "+direction);
                        joyStickMoves(angle, power, direction);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
