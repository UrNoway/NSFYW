package net.unelement.nsfyw;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import net.unelement.nsfyw.service.Service;
import net.unelement.nsfyw.service.dns.ADNS;
import net.unelement.nsfyw.service.dns.DnsFactory;
import net.unelement.nsfyw.service.emptybox.ABox;
import net.unelement.nsfyw.service.emptybox.BoxFactory;
import net.unelement.nsfyw.service.hosting.AHost;
import net.unelement.nsfyw.service.hosting.HostingFactory;

/**
 * Not Safe For Your Wife
 */
public class NSFYW {

    static void main(String[] args) {
        if(args.length <= 1){
            App.main(args);
        }else{
            Service service = Service.fromName(args[0].toLowerCase());
            if(service != null){
                switch(service){
                    case DNS -> {
                        if(args.length == 6){
                            // Fill fields
                            String name = args[1];
                            String address = args[2];
                            int port = Integer.parseInt(args[3]);
                            int limitResources = Integer.parseInt(args[4]);
                            double speedLimitPerUser = Double.parseDouble(args[5]);

                            // Use factory
                            ADNS dns = DnsFactory.create(name, address, port,
                                    limitResources, speedLimitPerUser);

                            // Open server
                            System.out.println("dns created");
                            // TODO
                        }
                    }
                    case EmptyBox -> {
                        if(args.length == 10){
                            // Fill fields
                            String name = args[1];
                            String webSiteName = args[2];
                            String webSiteUrl = args[3];
                            String maintainerName = args[4];
                            String maintainerEmail = args[5];
                            String entryPoint = args[6];

                            String hostname = args[7];
                            String uniqueFolderName = args[8];
                            String startingDnsAddress = args[9];

                            // Use factory
                            AHost host = HostingFactory.create(hostname, uniqueFolderName);

                            // TODO: DNS ; integrate a JSON array to connect more engine
                            ADNS genericDNS = DnsFactory.create(
                                "", startingDnsAddress, 9020, -1, -1d
                            );

                            host.getReplicas().add(genericDNS);

                            ABox box = BoxFactory.create(
                                    name, host, webSiteName, webSiteUrl,
                                    maintainerName, maintainerEmail, entryPoint
                            );

                            // Open server
                            System.out.println("box created");
                            // TODO
                        }
                    }
                }
            }else{
                System.err.println("Invalid service name: " + args[0]);
            }
        }
    }

    public static class App extends Application {

        public static String startInternetAddress = "";

        public static void main(String[] args) {
            if(args.length == 1){ startInternetAddress = args[0]; }
            Application.launch(App.class, args);
        }

        @Override
        public void start(Stage stage) {
            stage.setTitle("Not Safe For Your Wife, do not mention it!");

            WebView webView = new WebView();

            if(startInternetAddress.isEmpty()){
                startInternetAddress = "https://www.google.com";
            }
            webView.getEngine().load(startInternetAddress);
            webView.setMinHeight(1000);

            VBox vBox = new VBox(webView);
            Scene scene = new Scene(vBox, 1920, 1000);

            stage.setScene(scene);
            stage.show();
        }
    }
}
