# LANConnection
Bu proje, aynı evde veya aynı internet ağına bağlı olan (LAN) bilgisayarlar arasında yazılı olarak mesajlaşmayı sağlayan basit bir sohbet uygulamasıdır. Program tamamen terminal (komut ekranı) üzerinden çalışır, herhangi bir grafik arayüz içermez.

Projede üç ana dosya vardır:
Server, ClientHandler ve Client.

Server dosyası, tüm cihazlarla bağlantı kuran ve mesajları yöneten ana merkezdir. Yani, bu dosya bir bilgisayarda çalıştırılır ve diğer herkes o bilgisayara bağlanır. Her bağlanan kullanıcı için ayrı bir “kanal” açılır. Böylece herkes aynı anda mesaj yazabilir ve okuyabilir. Bu da programın takılmadan çalışmasını sağlar.

ClientHandler dosyası, server’a bağlanan her kişi için ayrı ayrı çalışır. Bu dosya sayesinde, bir kişinin gönderdiği mesaj diğer herkese ulaştırılır.

Client dosyası ise kullanıcıların çalıştırdığı kısımdır. Bu dosya, IP ve port gibi bilgileri alarak server’a bağlanır. Kullanıcı mesaj yazdıkça bu mesaj server’a gider ve oradan diğer kullanıcılara gönderilir. Aynı şekilde diğerlerinden gelen mesajlar da ekranda görünür. Karşılıklı yazışma sağlanır.

Bu yapıyla birlikte herkes aynı ağda rahatça yazışabilir. Uygulama, temel ama etkili bir sohbet ortamı sunar. Özellikle yerel ağda hızlı ve kolay iletişim kurmak için kullanılabilir.

Bu projeye başlarken bildiğim bazı şeyler olduğu kadar, bilmediğim konuların da farkına vardım. Thread yapısı ve internet üzerinden bağlantı kurma gibi konularda temel bilgim vardı, ancak bunları uygulamalı şekilde kullanmak benim için ekstra bir çaba gerektirdi. Bu süreç hem öğretici hem de geliştirici oldu. Sadece teorik olarak değil, gerçekten çalışan bir sistem kurarak öğrenmek bana çok şey kattı.


Proje Açıklaması

Bu proje, aynı evde veya aynı internet ağına (LAN) bağlı bilgisayarlar arasında yazılı olarak mesajlaşmayı sağlayan basit bir sohbet uygulamasıdır. Uygulama tamamen terminal (komut ekranı) üzerinden çalışır; herhangi bir grafik arayüz içermez.

Dosya Yapısı

Projede üç ana dosya bulunur:
	•	Server.java
Tüm cihazlarla bağlantı kuran ve mesajları yöneten ana merkezdir. Yani bu dosya bir bilgisayarda çalıştırılır ve diğer tüm kullanıcılar bu bilgisayara bağlanır. Her bağlanan kullanıcı için ayrı bir “kanal” (thread) açılır. Bu sayede herkes aynı anda mesaj yazabilir ve okuyabilir. Bu yapı, uygulamanın takılmadan ve eşzamanlı şekilde çalışmasını sağlar.
	•	ClientHandler.java
Server’a bağlanan her kullanıcı için ayrı ayrı çalışan parçadır. Bir kullanıcının gönderdiği mesaj, bu sınıf sayesinde diğer tüm kullanıcılara iletilir.
	•	Client.java
Kullanıcıların çalıştırdığı bölümdür. IP adresi ve port bilgisi girilerek server’a bağlantı kurulur. Kullanıcı mesaj yazdıkça, bu mesaj server’a gönderilir ve oradan diğer tüm kullanıcılara iletilir. Aynı şekilde diğerlerinden gelen mesajlar da terminalde görüntülenir. Böylece karşılıklı yazışma sağlanır.

Kullanım Amacı

Bu yapıyla herkes aynı ağ üzerinde rahatça yazışabilir. Uygulama, temel ama işlevsel bir sohbet ortamı sunar. Özellikle yerel ağda hızlı ve pratik iletişim kurmak için kullanılabilir.

Geliştirme Süreci

Bu projeye başlarken bildiğim bazı şeyler olduğu kadar, bilmediğim konuların da farkına vardım. Thread yapısı ve ağ üzerinden bağlantı kurma gibi konularda temel bilgim vardı; ancak bunları gerçek bir projede uygulamak benim için hem ekstra bir çaba hem de değerli bir öğrenme süreci oldu.
Sadece teorik olarak değil, çalışan bir sistem geliştirerek öğrendim. Bu da bana ciddi anlamda pratik kazandırdı.
