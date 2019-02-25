package lejeuduplagiat.network.client;

import lejeuduplagiat.model.GameModel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client implements Runnable
{
    private Socket socket;

    private boolean running;

    private DataOutputStream output;
    private DataInputStream input;
    private GameModel game;


    public Client(GameModel game)
    {
        this.game = game;
        try
        {
            this.socket = new Socket();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void connect(String host, int port)
    {
        try
        {
            this.socket.connect(new InetSocketAddress(host, port));
            this.running = true;
            this.output = new DataOutputStream(this.socket.getOutputStream());
            this.input = new DataInputStream(this.socket.getInputStream());

            System.out.println("Connecté au serveur " + host + ":" + port);
            new Thread(this).start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void send(String message)
    {
        System.out.println("ENVOIE : " + message);
        try
        {
            this.output.writeUTF(message);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (this.running)
        {
            try
            {
                String message = input.readUTF();

                System.out.println("RECEPTION : " + message);
                String[] sData = message.split("->");
                String paquet = sData[0];
                String data = sData[1];
                switch (paquet)
                {

                    case "1" : Reception.recevoirJoueurDeServeur(data, game);
                        break;
                    case "2" : Reception.recevoirDeplacement(data, game);
                        break;
                    case "3" : Reception.recevoirFinTour(game);
                        break;
                    case "4" : Reception.recevoirCurrent(data, game);
                    default:
                        break;
                }

            }
            catch(Exception e )
            {
                e.printStackTrace();
                this.close();
            }
        }
        this.close();
    }


    private void close()
    {
        try
        {
            this.socket.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.running = false;
    }
}

