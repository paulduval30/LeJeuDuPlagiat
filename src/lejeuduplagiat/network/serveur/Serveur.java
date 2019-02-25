package lejeuduplagiat.network.serveur;

import lejeuduplagiat.model.Game;
import lejeuduplagiat.model.GameModel;
import lejeuduplagiat.model.GameModelServer;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Serveur implements Runnable
{
    public static Serveur instance;
    private ServerSocket socket;

    private Game gameModel;
    private boolean running;

    private ArrayList<ClientSocket> clients;
    private int nbJoueur;



    public Serveur()
    {
        Serveur.instance = this;
        this.gameModel = new GameModelServer();
        nbJoueur = 0;
        try
        {
            this.running = false;
            this.clients = new ArrayList<>();
            this.socket = new ServerSocket();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void listen()
    {
        try
        {
            this.socket.bind(new InetSocketAddress(25566), 1);
            System.out.println("En écoute sur le port 25566");
            this.running = true;
            new Thread(this).start();
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
                Socket clientSocket = this.socket.accept();
                this.clients.add(new ClientSocket(clientSocket));
                this.clients.get(clients.size() - 1).send("0-> Hello");
                System.out.println(clients.size());
                if(clients.size() == 2)
                {
                    this.running = false;
                    Paquet.envoyerCurrent();
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                break;
            }
        }

        this.close();
    }

    public Game getGameModel()
    {
        return gameModel;
    }

    public void sendAll(String message)
    {
        System.out.println(message);
        for(ClientSocket c : clients)
        {
            c.send(message);
        }
    }

    public void close()
    {
        try
        {
            // On ferme toutes les connexions courantes
            for (ClientSocket client : this.clients)
                if (client.isRunning())
                    client.close();

            this.socket.close();
            this.running = false;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public int getNbJoueur()
    {
        return nbJoueur;
    }

    public void ajouterJoueur()
    {
        this.nbJoueur ++;
    }

    public ArrayList<ClientSocket> getClients()
    {
        return clients;
    }

    public void setRunning(boolean running)
    {
        this.running = running;
    }

    public static void main(String[] argv)
    {
        new Serveur().listen();
    }
}

