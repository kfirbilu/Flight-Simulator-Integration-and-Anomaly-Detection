package Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import Server.Commands.DefaultIO;
import Server.Server.ClientHandler;


public class AnomalyDetectionHandler implements ClientHandler {

    Scanner in;

    PrintWriter out;

    public class SocketIO implements DefaultIO
    {


        @Override
        public String readText() {
            return in.nextLine();
        }

        @Override
        public void write(String text) {
            out.print(text);
        }

        @Override
        public float readVal() {
            return in.nextFloat();
        }

        @Override
        public void write(float val) {
            out.print(val);
        }
    }

    @Override
    public void comm(InputStream in, OutputStream out)
    {
        this.in = new Scanner(in);

        this.out = new PrintWriter(out);

        SocketIO socket = new SocketIO();

        CLI client = new CLI(socket);

        client.start();

        this.out.println("bye");

        this.out.close();

        this.in.close();

    }
}
