/**
 * Created by Сергей on 14.07.2015.
 */
public class CoreMain {
    public static void main(String[] args){
        new Thread(new Processing()).start();
    }
}
