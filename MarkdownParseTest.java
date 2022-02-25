import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest{
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
    
        List<String> expectedOutput = List.of("https://something.com", "some-page.html");

        assertEquals(expectedOutput, links);
    }

    @Test
    public void testGetLinksTwo() throws IOException{
        Path fileName = Path.of("test-file-two.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
    
        List<String> expectedOutput = List.of("https://something.com", "some-page.html");

        assertEquals(expectedOutput, links);
    }
    @Test
    public void testFailure(){
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinksThree() throws IOException{
        Path fileName = Path.of("test-file-three.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
    
        List<String> expectedOutput = List.of("https://something.com");

        assertEquals(expectedOutput, links);
    }

    @Test
    public void testGetLinksFour() throws IOException{
        Path fileName = Path.of("test-file-four.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
    
        List<String> expectedOutput = List.of("https://something.com", "some-page.html");

        assertEquals(expectedOutput, links);
    }


    @Test
    public void testSnipet1() throws IOException{
        Path fileName = Path.of("snip1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        List<String> expectedOutput = List.of("%60google.com", "google.com",  "ucsd.edu");

        assertEquals(expectedOutput, links);    
    }

    @Test
    public void testSnipet2() throws IOException{
        Path fileName = Path.of("snip2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        List<String> expectedOutput = List.of("a.com", "a.com(())", "example.com");

        assertEquals(expectedOutput, links);    
    }

    @Test
    public void testSnipet3() throws IOException{
        Path fileName = Path.of("snip3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        List<String> expectedOutput = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");

        assertEquals(expectedOutput, links);    
    }
}
