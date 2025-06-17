import java.util.Arrays;
import java.util.Comparator;
public class FractionalKnapsack {
    static class Item {
        int weight;
        int value;
        double ratio;
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }
    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items, Comparator.comparingDouble(item -> -item.ratio));
        double totalValue = 0;
        for (Item item : items) {
            if (capacity >= item.weight) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                totalValue += item.ratio * capacity;
                break;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items = {new Item(10, 60), new Item(20, 100), new Item(30, 120)};
        int capacity = 50;
        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value: " + maxValue);
    }
}