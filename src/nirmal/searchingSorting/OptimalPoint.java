package nirmal.searchingSorting;

public class OptimalPoint {
        public static double findOptimalPoint(int[] xCoordinates, int[] yCoordinates) {
            int n = xCoordinates.length;
            double minDistance = Double.MAX_VALUE;
            double optimalPoint = 0.0;
            for (double point = 0.0; point <= 1.0; point += 0.001) {
                double totalDistance = 0.0;
                for (int i = 0; i < n; i++) {
                    double distance = Math.sqrt(Math.pow((point - xCoordinates[i]), 2) + Math.pow((0 - yCoordinates[i]), 2));
                    totalDistance += distance;
                }
                if (totalDistance < minDistance) {
                    minDistance = totalDistance;
                    optimalPoint = point;
                }
            }
            return optimalPoint;
        }

        public static void main(String[] args) {
            int[] xCoordinates = {1, 2, 3};
            int[] yCoordinates = {4, 5, 6};
            double optimalPoint = findOptimalPoint(xCoordinates, yCoordinates);
            System.out.println("Optimal Point: " + optimalPoint);
        }
}
