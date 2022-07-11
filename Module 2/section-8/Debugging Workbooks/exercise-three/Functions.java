public class Functions {
    public static void main(String[] args) {
        int random = random(15);    
        System.out.println("Number: " + random);
        System.out.println("Prime or Composite: " + isPrime(random));
    }

    public static int random(int range) {
        double random = Math.random() * range + 1;
        return (int) random;
    }
    public static String isPrime(int random) {
        String isPrime = "Prime";
        if (random == 1) {
            isPrime = "Composite";
        }
        for (int i = 1; i < random; i++) {
            if (random % i == 0 && i != 1 && i != random) {
                isPrime = "Composite";
                break;
            } else {
                continue;
            }
        }
        return isPrime;
    }
}
