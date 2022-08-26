public class Main {
    public static void main(String[] args) throws InterruptedException {
        River myRiver = new River();

        Fish.setRiver(myRiver);
        Bear.setRiver(myRiver);
        myRiver.addFish(new Fish(), 5);
        myRiver.addBear(new Bear(), 73);
        myRiver.addFish(new Fish(), 75);

        while (true){
            myRiver.stepSim();
            System.out.println(myRiver);
            Thread.sleep(400);
        }
    }
}
