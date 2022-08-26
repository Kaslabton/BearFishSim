public class River {
    Animal river[];
    public River(){
        river = new Animal[100];
    }
    public River (int num){
        river = new Animal [num];
    }
    //DD - return boolean, return false if out of bounds
    // and return false if index is already contains an Animal
    public boolean addBear(Bear a, int index){
        if(index< 0 || index >= river.length)
            return false;
        Animal temp = getAnimalAt(index);
        if(temp != null)
            return false;
        river[index] = a;
        return true;
    }
    public boolean addFish(Fish a, int index){
        if(index< 0 || index >= river.length)
            return false;
        Animal temp = getAnimalAt(index);
        if(temp != null)
            return false;
        river[index] = a;
        return true;
    }
    public boolean addAnimal(Animal a, int index){
        if(index< 0 || index >= river.length)
            return false;
        Animal temp = getAnimalAt(index);
        if(temp != null)
            return false;
        river[index] = a;
        return true;
    }

    public Animal getAnimalAt(int index){
        if (index < 0 || index >= river.length)
            throw new ArrayIndexOutOfBoundsException("index pass River Boundary");

        return river[index];
    }

    public String toString(){
        String out = "";//build our output
        for(Animal a : river){
            if (a == null){
                out += "-";
            }
            else
                out += a.getSymbol();
        }
        return out;
    }

    public void stepSim(){
        for(int i = 0; i< river.length; i++){
            Animal current = getAnimalAt(i);
            if( current != null){
                current.act(i);
            }
        }
    }

    public void clearLoc(int index) {
        river[index] = null;
    }
}
