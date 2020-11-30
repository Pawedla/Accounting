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
    public String bookOrder(Integer number, String[] order, String[] offer) {

        try {
            new File("save.txt").createNewFile();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("save.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputBuffer.append(line + "\n");
            }
            bufferedReader.close();
            inputBuffer.append("nr[" + number + "]-name[" + order[4] + "]-config[" + order[0] + ", " + order[1] + ", " + order[2] + ", " + order[3] + "]-cost[" + offer[1] + "]-supplyer[" + offer[0] + "]-deliveryDate[" + offer[2] + "]\n");
            FileOutputStream fileOut = new FileOutputStream("save.txt");
            fileOut.write(inputBuffer.toString().getBytes());
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return "";
    }
}
