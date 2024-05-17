import java.io.*;
import java.net.*;

public class ClientKenan {
    public static void main(String[] args) {

        Socket client = null;

        int portnumber = 80;
        if(args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }

        for( int i = 0; i < 10; i++){
            try{
                String msg = "HAIIIIIIIIIIII";

                client = new Socket(InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created " + client);

                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);

                InputStream clientIN = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIN));

                BufferedReader stdIN = new BufferedReader(new InputStreamReader(System.in));


                System.out.println("Enter your name. Type Bye to exit. ");
                System.out.print(": ");

                msg = stdIN.readLine().trim();
                pw.println(msg);

                System.out.println("Message returned from the server = " + br.readLine());

                pw.close();
                br.close();
                client.close();

                if (msg.equalsIgnoreCase("bye")){
                    break;
                }


            } catch (IOException ie){
                System.out.println("Error is " + ie);
            }
        }
    }
}