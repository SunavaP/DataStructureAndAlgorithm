
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class ElevatorDesign {

    public static void main(String[] args) {
        System.out.println("Welcome to MyLift");
        // RequestListenerThread to read requested floor and add to Set
        Thread requestListenerThread = new Thread(new RequestListener(),
                "RequestListenerThread");
        // RequestProcessorThread to read Set and process requested floor
        Thread requestProcessorThread = new Thread(new RequestProcessor(),
                "RequestProcessorThread");
        requestListenerThread.start();
        requestProcessorThread.start();
    }
}

class Elevator {
    private static Elevator elevator = null;
    private static TreeSet<Integer> requestSet = new TreeSet<Integer>();
    private int currentFloor = 0;

    private Direction direction = Direction.UP;

    private Elevator() {
    };

    /**
     * @return singleton instance
     */
    static Elevator getInstance() {
        if (elevator == null) {
            elevator = new Elevator();
        }
        return elevator;
    }

    /**
     * Add request to Set
     *
     * @param f
     */
    public synchronized void addFloor(int f) {
        requestSet.add(f);
        // Notify the thread that a new request has come.
        notify();
    }

    /**
     * @return next request to process based on elevator current floor and
     *         direction
     */
    public synchronized int nextFloor() {

        Integer floor = null;

        if (direction == Direction.UP) {
            if (requestSet.ceiling(currentFloor) != null) {
                floor = requestSet.ceiling(currentFloor);
            } else {
                floor = requestSet.floor(currentFloor);
            }
        } else {
            if (requestSet.floor(currentFloor) != null) {
                floor = requestSet.floor(currentFloor);
            } else {
                floor = requestSet.ceiling(currentFloor);
            }
        }
        if (floor == null) {
            try {
                System.out.println("No Request to process. Waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Processing Request : " + floor);
            requestSet.remove(floor);
        }
        return (floor == null) ? -1 : floor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Set current floor and direction based on requested floor
     *
     * @param currentFloor
     */
    public void setCurrentFloor(int currentFloor) {
        if (this.currentFloor > currentFloor) {
            setDirection(Direction.DOWN);
        } else {
            setDirection(Direction.UP);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.currentFloor = currentFloor;
        System.out.println("Floor : " + currentFloor);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}

class RequestProcessor implements Runnable {

    @Override
    public void run() {
        while (true) {
            Elevator elevator = Elevator.getInstance();
            int floor = elevator.nextFloor();
            int currentFloor = elevator.getCurrentFloor();
            if (floor >= 0) {
                if (currentFloor > floor) {
                    while (currentFloor > floor) {
                        elevator.setCurrentFloor(--currentFloor);
                    }
                } else {
                    while (currentFloor < floor) {
                        elevator.setCurrentFloor(++currentFloor);
                    }
                }
            }
        }
    }
}

class RequestListener implements Runnable {

    @Override
    public void run() {

        while (true) {
            String floorNumberStr = null;
            try {
                // Read input from console
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(System.in));
                floorNumberStr = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (isValidFloorNumber(floorNumberStr)) {
                System.out.println("User Pressed : " + floorNumberStr);
                Elevator elevator = Elevator.getInstance();
                elevator.addFloor(Integer.parseInt(floorNumberStr));
            } else {
                System.out.println("Floor Request Invalid : " + floorNumberStr);
            }
        }
    }

    /**
     * This method is used to define maximum floors this elevator can process.
     * @param s - requested floor
     * @return true if requested floor is integer and upto two digits. (max floor = 99)
     */
    public boolean isValidFloorNumber(String s) {
        return (s != null) && s.matches("\\d{1,2}");
    }

}

enum Direction {
    UP, DOWN
}