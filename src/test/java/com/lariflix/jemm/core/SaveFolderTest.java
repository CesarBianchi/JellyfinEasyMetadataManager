
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveFolderTest {

    @Test
    public void testGetSetJellyfinInstanceUrl() {
        LoadMovies loadMovies = new LoadMovies();
        loadMovies.setJellyfinInstanceUrl("http://localhost:8096");
        assertEquals("http://localhost:8096", loadMovies.getJellyfinInstanceUrl());
    }

    @Test
    public void testGetSetApiToken() {
        LoadMovies loadMovies = new LoadMovies();
        loadMovies.setApiToken("1234567890");
        assertEquals("1234567890", loadMovies.getApiToken());
    }

    @Test
    public void testGetSetcUserAdminID() {
        LoadMovies loadMovies = new LoadMovies();
        loadMovies.setcUserAdminID("admin");
        assertEquals("admin", loadMovies.getcUserAdminID());
    }

    @Test
    public void testGetSetcParentID() {
        LoadMovies loadMovies = new LoadMovies();
        loadMovies.setcParentID("parent1");
        assertEquals("parent1", loadMovies.getcParentID());
    }

    @Test
    public void testGetFullURL() {
        LoadMovies loadMovies = new LoadMovies();
        loadMovies.setJellyfinInstanceUrl("http://localhost:8096");
        loadMovies.setApiToken("1234567890");
        loadMovies.setcUserAdminID("admin");
        loadMovies.setcParentID("parent1");
        assertEquals("http://localhost:8096/Users/admin/Items?parentId=parent1&userId=admin&ApiKey=1234567890", loadMovies.getFullURL());
    }
}