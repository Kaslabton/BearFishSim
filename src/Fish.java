public class Fish extends Animal{
    private String symbol;
    private static River river;
    public Fish(){
        symbol = "F";
    }
    public Fish(String symbol){
        this.symbol = symbol;
    }
    public static void setRiver(River river){
        Fish.river = river;
    }

    public String getSymbol(){
        return symbol;
    }

    public boolean ifbeeneaten(int index){
        //left side
        Animal LeftToMe = river .getAnimalAt(index-1);
        if(LeftToMe.equals("B")){
            river.clearLoc(index);
            return true;
        }
        Animal RightToMe = river.getAnimalAt(index+1);
        if(RightToMe.equals("B")) {
            river.clearLoc(index);
            return true;
        }
        return false;
    }

    public void act(int index){
        if(ifbeeneaten(index))
            river.clearLoc(index);

        if(river == null)
            throw new IllegalStateException("Cannot Act - No River Set for Animals");

        int choice = (int)(1 + Math.random()*100);
        if(choice <= 20){
            //My loc
            //loc to the left of me
            //what is in th location to the left me
            //make sure I and mot at the left end
            if(index == 0)
                return;//exit, cannot move
            //get the Animal next to me
            Animal nextToMe = river .getAnimalAt(index-1);
            // if the space is empty, move to it
            if(nextToMe == null){
                river.clearLoc(index);
                river.addFish(this, index-1);
            }
        }
        else if(choice <= 40){//move right
            if(index == 100)
                return;
            Animal nextToMe = river.getAnimalAt(index+1);
            if (nextToMe == null) {
                river.clearLoc(index);
                river.addFish(this, index+1);
            }

        }
    }

}
