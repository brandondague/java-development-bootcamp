public class Airline {

    private Person[] seats;


    public Airline() {
        this.seats = new Person[11];
    }

    public Person getPerson(int index) {
        return new Person(this.seats[index]);
    }

    public void setPerson(Person person) {
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }

    public void createReservation(Person person) {
        while (this.seats[person.getSeatNumber() - 1] != null) {
            System.out.printf("%n%s, seat number: %d is already taken. Please choose another.%n", 
                                       person.getName(), person.getSeatNumber());
            person.chooseSeat();
        }

        int index = person.getSeatNumber() - 1;
        seats[index] = new Person(person);
        System.out.printf("%nThank you %s, your reservation for seat number: %d has been confirmed.%n", 
                                   person.getName(), person.getSeatNumber());
        
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.seats.length; i++) {
            if (seats[i] != null) {
                temp += seats[i].toString();
                temp += "\n\n";
            } else {
                temp += "Seat " + (i + 1) + " is empty.";
                temp += "\n\n";
            }
        }

        return temp;
    }
}
