import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ip yi ve kullanıcı adını al - ip yi client üzerinden alabilirsin 
        System.out.print("Sunucunun IP adresi: ");
        String ip = sc.nextLine();

        System.out.print("Kullanıcı adınız: ");
        String username = sc.nextLine();
        
        System.out.print("Bağlanılacak Portu giriniz : ");
        int PORT = sc.nextInt();
        
        sc.nextLine(); //hata alıyordu /n karakterinden dolayı

        try {
            Socket socket = new Socket(ip, PORT);
            System.out.println("Sunucuya bağlanıldı.");
            System.out.println("Programdan çıkmak için /exit ");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(username);//sunucuya veri göndermek için 

            Thread readerThread = new Thread(() -> {
                try {
                    String messageFromServer;
                    while ((messageFromServer = in.readLine()) != null) {
                        System.out.println("\r " +messageFromServer);
                        System.out.print("> "); // tekrar yazma çizgisi
                    }
                } catch (IOException e) {
                    System.out.println("Sunucuyla bağlantı kesildi.");
                }
            });
            readerThread.start();

            while (true) {
                String message = sc.nextLine();
                if (message.equals("/exit")) {
                    break;
                }
                out.println(message);
            }

            
            socket.close();
            System.out.println("Bağlantı kapatıldı.");

        } catch (IOException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
           // güvenlik için scanner.close kullanılması tavsiye ediliyormuş -> not al
    }
}