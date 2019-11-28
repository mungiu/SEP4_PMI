import org.junit.Before;
import utils.Database;

public class TestConnection {
    Database db;

    @Before
    public void setup(){

        db = Database.getInstance();
    }


}
