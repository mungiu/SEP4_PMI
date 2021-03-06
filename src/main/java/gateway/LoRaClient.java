package gateway;

import dao.PlantDataDao;
import model.PlantData;
import service.IPlantDataService;
import service.PlantDataService;
import utils.exceptions.PlantNotFoundException;

import java.net.URI;
import java.net.http.*;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

public class LoRaClient implements WebSocket.Listener {
    private IPlantDataService plantDataService;
    private PlantDataDao plantDataDao;

    public LoRaClient() {
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
                .buildAsync(URI.create("wss://iotnet.teracom.dk/app?token=vnoSZgAAABFpb3RuZXQudGVyYWNvbS5ka5UP5XduzFukz7WTiUm9E-I="), this);

        plantDataService = new PlantDataService();
        plantDataDao = new PlantDataDao();
    }

    //onOpen()
    public void onOpen(WebSocket webSocket) {
        // This WebSocket will invoke onText, onBinary, onPing, onPong or onClose methods on the associated listener (i.e. receive methods) up to n more times
        webSocket.request(1);
        System.out.println("WebSocket Listener has been opened for requests.");
    }

    //onError()
    public void onError​(WebSocket webSocket, Throwable error) {
        System.out.println("A " + error.getCause() + " exception was thrown.");
        System.out.println("Message: " + error.getLocalizedMessage());
        webSocket.abort();
    };

    //onClose()
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.out.println("WebSocket closed!");
        System.out.println("Status:" + statusCode + " Reason: " + reason);
        return  CompletableFuture.completedFuture("onClose() completed.").thenAccept(System.out::println);
    };

    //onPing()
    public CompletionStage<?> onPing​(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Ping: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return CompletableFuture.completedFuture("Ping completed.").thenAccept(System.out::println);
    };

    //onPong()
    public CompletionStage<?> onPong​(WebSocket webSocket, ByteBuffer message) {
        webSocket.request(1);
        System.out.println("Pong: Client ---> Server");
        System.out.println(message.asCharBuffer().toString());
        return null; // new CompletableFuture().completedFuture("Pong completed.").thenAccept(System.out::println);
    };

    //onText()
    public CompletionStage<?> onText​(WebSocket webSocket, CharSequence data, boolean last) {
        System.out.println("Data received");
        PlantData[] plantDataArray;

        try {
            plantDataArray = plantDataService.serializePlantDataFromJSON(data);
            if (plantDataArray != null)
                plantDataDao.addPlantDatas(plantDataArray);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error while parsing data from a device");
        } catch (SQLException e){
            e.printStackTrace();
        }catch (PlantNotFoundException e){
            System.err.println(e.getMessage());
        }

        webSocket.request(1);
        return  CompletableFuture.completedFuture("onText() completed.").thenAccept(System.out::println);
    };
}