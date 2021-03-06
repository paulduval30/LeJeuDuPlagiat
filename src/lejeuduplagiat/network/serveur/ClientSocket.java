package lejeuduplagiat.network.serveur;



import lejeuduplagiat.model.Personnage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket implements Runnable
{
    private Socket socket;

    private DataOutputStream out;
    private DataInputStream in;

    private boolean running;
    private Personnage personnage;

    public ClientSocket(Socket socket)
    {
        this.socket = socket;
        try
        {
            this.out = new DataOutputStream(socket.getOutputStream());
            this.in = new DataInputStream(socket.getInputStream());

            this.running = true;

            new Thread(this).start();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public boolean isRunning()
    {
        return this.running;
    }

    public void send(String message)
    {
        System.out.println("ENVOIE : " + message);
        try
        {
            this.out.writeUTF(message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while(this.isRunning())
        {
            try
            {
                String message = this.in.readUTF();
                System.out.println("RECEPTION : " + message);
                String[] paquet = message.split("->");
                switch (paquet[0])
                {
                    case "1" : Reception.recevoirJoueurDeClient(paquet[1]);
                        break;
                    case "2" : Reception.recevoirDeplacement(paquet[1]);
                        break;
                    case "3" : Reception.recevoirFinTour();
                    default:
                        break;
                }
            }
            catch (Exception e)
            {
                this.close();
            }
        }
    }

    void close()
    {
        try
        {
            this.socket.close();
            this.running = false;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public Personnage getJoueur()
    {
        return personnage;
    }

    public void setJoueur(Personnage j)
    {
        this.personnage = j;
    }
}

