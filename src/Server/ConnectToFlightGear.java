package Server;

import java.io.*;
import java.net.Socket;

public class ConnectToFlightGear {

    public ConnectToFlightGear() throws IOException, InterruptedException {

        Socket flightGearSocket=new Socket("localhost", 5400);

        BufferedReader in=new BufferedReader(new FileReader("reg_flight.csv"));

        PrintWriter out=new PrintWriter(flightGearSocket.getOutputStream());

        String line;

        while((line=in.readLine())!=null) {

            out.println(line);

            out.flush();

            Thread.sleep(100);
        }

        out.close();

        in.close();

        flightGearSocket.close();

    }


}
