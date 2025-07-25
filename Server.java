import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static Set<ClientHandler> clients = new HashSet<>();//uniqe olduğu inin hashset ve sıra vs de önemsiz
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sunucu başlatılıyor...");
        InetAddress ip;
        
        int PORT = sc.nextInt();
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Sunucunun IP adresi: " + ip.getHostAddress() + " + " + "Sunucu Portu : " + PORT);
        } catch (UnknownHostException ex) {
            System.out.println("Sunucu hatası: " + ex.getMessage());
        }

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {//sunucuyu dinlemeye başlıoyr
            System.out.println("Port " + PORT + " üzerinden dinleniyor.");

            while (true) {//sürekli bağlantı bekliyor
                Socket socket = serverSocket.accept(); //bağlantıları direk kabul ediyor
                System.out.println("Yeni kullanıcı bağlandı: " + socket);

                ClientHandler client = new ClientHandler(socket, clients);
                clients.add(client);

                Thread t = new Thread(client); 
                t.start();
            }

        } catch (IOException e) {
            System.out.println("Sunucu hatası: " + e.getMessage());
        }
    }
}