/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universalcontroller;

/**
 *
 * @author anshal
 */
public class UniversalController {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConnectionHandler conh=new ConnectionHandler();
        conh.startConnection();
    }
    
}
