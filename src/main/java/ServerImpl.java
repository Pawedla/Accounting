



import com.github.Pawedla.Server;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ServerImpl implements Server {

    public ServerImpl() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    //Gets desired Order from Client
    @Override
    public String bookOrder(String selection) {


        try {
            BufferedReader file = new BufferedReader(new FileReader("save.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
            }
            inputBuffer.append(selection);
            file.close();
            FileOutputStream fileOut = new FileOutputStream("save.txt");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "";
    }
}
