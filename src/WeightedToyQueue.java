import java.util.*;

public class WeightedToyQueue {
    private List<Toy> toys = new ArrayList<>();
    private List<Integer> cumulativeWeights = new ArrayList<>();

    public void put(String input) {
        String[] parts = input.split(" ");
        if (parts.length < 3) return;

        String id = parts[0];
        int weight = Integer.parseInt(parts[1]);
        String name = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));

        Toy toy = new Toy(id, name, weight);
        toys.add(toy);

        if (cumulativeWeights.isEmpty()) {
            cumulativeWeights.add(weight);
        } else {
            cumulativeWeights.add(cumulativeWeights.get(cumulativeWeights.size() - 1) + weight);
        }
    }

    public String get() {
        int randVal = new Random().nextInt(cumulativeWeights.get(cumulativeWeights.size() - 1)) + 1;

        for (int index = 0; index < cumulativeWeights.size(); index++) {
            if (randVal <= cumulativeWeights.get(index)) {
                return toys.get(index).getName();
            }
        }
        return null;
    }

    public void addNewToy(String input) {
        put(input);
    }
}
