import java.io.*;
import java.net.*;
import java.util.Set;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Set<ClientHandler> clientList;
    private String userName;

    public ClientHandler(Socket socket, Set<ClientHandler> clientList) {
        this.socket = socket;
        this.clientList = clientList;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Akış oluşturulamadı: " + e.getMessage());
        }
    }

    
    public void run() {
        try {
            userName = in.readLine();
            System.out.println(userName + " bağlandı.");
            sendToAll(userName + " sohbete katıldı.");

            
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                sendToAll(userName + ": " + message);
            }

        } catch (IOException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        } finally {
            //if there is conn problem close or remove all things.
            try {
                clientList.remove(this);
                socket.close();
                sendToAll(userName + " ayrıldı.");
                System.out.println(userName + " bağlantıyı kapattı.");
            } catch (IOException e) {
                System.out.println("Çıkışta hata: " + e.getMessage());
            }
        }
    }
//boradcast for all other connections
    private void sendToAll(String message) {
        for (ClientHandler client : clientList) {
            /*if (client != this) {
                client.out.println(message);
            }*/ //i will decide after test if user can see their own message
            client.out.println(message);

        }
    }
}