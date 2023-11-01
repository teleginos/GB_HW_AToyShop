import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        WeightedToyQueue toyQueue = new WeightedToyQueue();

        toyQueue.put("1 20 конструктор");
        toyQueue.put("2 20 робот");
        toyQueue.put("3 60 кукла");

        // Добавляем новую игрушку
        toyQueue.addNewToy("4 50 лего");

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        for (int i = 0; i < 10; i++) {
            writer.write(toyQueue.get());
            writer.newLine();
        }

        writer.close();
    }
}
