import Engines.FightSystem;

public class Main {
    public static void main(String[] args) {
        FightSystem fs = new FightSystem();
        fs.initialize();
        while(!fs.isEnd){
            fs.Round();
        }
    }
}