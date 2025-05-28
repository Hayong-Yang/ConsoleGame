package characters;

public class Archer extends Champion{
    public Archer(String name){
        super(100,100,20,10,10,0,name);
    };


    @Override
    public void speak() {
        System.out.println("싸늘하다. 가슴에 화실이 날아와 꽂힌다!!");
    }
}



