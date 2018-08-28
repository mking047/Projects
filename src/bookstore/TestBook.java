package bookstore;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class TestBook {


  String defaultTitle = "a title";
  String defaultPublisher = "ODU Publishing";
  String defaultISBN = "1234567890123";
  Author[] emptyAuthors = {};
  Author jones = new Author("Jim", "Jones");
  Author smith = new Author("Sarah", "Smith");
  Author doe = new Author("John", "Doe");
  Author[] twoAuthors = {jones, smith};
  Book blank = new Book();
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * Test method for {@link Book#Book()}.
   */
  @Test
  public final void testBook() {
    Book book = new Book();
    assertEquals("", book.getTitle());
    assertEquals("", book.getISBN());
    assertEquals("", book.getPublisher());
    assertEquals(0, book.numAuthors());
    Iterator<Author> it = book.iterator();
    assertFalse(it.hasNext());
    assertEquals(book, blank);
    assertEquals(book.hashCode(), blank.hashCode());
    assertEquals(book.toString(), blank.toString());
  }

  /**
   * Test method for 
   * {@link Book#Book(java.lang.String, java.lang.String, java.lang.String, Author[])}.
   */
  @Test
  public final void testBookStringStringStringAuthorArray() {
    Book book = new Book(defaultTitle, defaultPublisher, defaultISBN, twoAuthors);
    assertEquals(defaultTitle, book.getTitle());
    assertEquals(defaultISBN, book.getISBN());
    assertEquals(defaultPublisher, book.getPublisher());
    assertEquals(2, book.numAuthors());
    int count = 0;
    for (Author au: book) {
      assertEquals (twoAuthors[count], au);
      ++count;
    }
    assertEquals (2, count);
    assertNotEquals(book, blank);
    assertNotEquals(book.hashCode(), blank.hashCode());
    String bookRepr = book.toString();
    assertTrue (bookRepr.contains(defaultTitle));
    assertTrue (bookRepr.contains(defaultPublisher));
    assertTrue (bookRepr.contains(defaultISBN));
    assertTrue (bookRepr.contains("Jones"));
    assertTrue (bookRepr.contains("Smith"));
  }

  /**
   * Test method for {@link Book#setTitle(java.lang.String)}.
   */
  @Test
  public final void testSetTitle() {
    Book book = new Book(defaultTitle, defaultPublisher, 
        defaultISBN, twoAuthors);
    book.setTitle("something else");
    assertEquals("something else", book.getTitle());
    assertEquals(defaultISBN, book.getISBN());
    assertEquals(defaultPublisher, book.getPublisher());
    assertEquals(2, book.numAuthors());
    int count = 0;
    for (Author au: book) {
      assertEquals (twoAuthors[count], au);
      ++count;
    }
    assertEquals (2, count);
    assertNotEquals(book, blank);
    assertNotEquals(book.hashCode(), blank.hashCode());
    String bookRepr = book.toString();
    assertTrue (bookRepr.contains(defaultPublisher));
    assertTrue (bookRepr.contains(defaultISBN));
    assertTrue (bookRepr.contains("Jones"));
    assertTrue (bookRepr.contains("Smith"));
  }

  /**
   * Test method for {@link Book#setISBN(java.lang.String)}.
   */
  @Test
  public final void testSetISBN() {
    Book book = new Book(defaultTitle, defaultPublisher, 
        defaultISBN, twoAuthors);
    book.setISBN("something else");
    assertEquals("something else", book.getISBN());
    assertEquals(defaultTitle, book.getTitle());
    assertEquals(defaultPublisher, book.getPublisher());
    assertEquals(2, book.numAuthors());
    int count = 0;
    for (Author au: book) {
      assertEquals (twoAuthors[count], au);
      ++count;
    }
    assertEquals (2, count);
    assertNotEquals(book, blank);
    assertNotEquals(book.hashCode(), blank.hashCode());
    String bookRepr = book.toString();
    assertTrue (bookRepr.contains(defaultTitle));
    assertTrue (bookRepr.contains(defaultPublisher));
    assertTrue (bookRepr.contains("Jones"));
    assertTrue (bookRepr.contains("Smith"));
  }

  /**
   * Test method for {@link Book#setPublisher(java.lang.String)}.
   */
  @Test
  public final void testSetPublisher() {
    Book book = new Book(defaultTitle, defaultPublisher, 
        defaultISBN, twoAuthors);
    book.setPublisher("something else");
    assertEquals("something else", book.getPublisher());
    assertEquals(defaultTitle, book.getTitle());
    assertEquals(defaultISBN, book.getISBN());
    assertEquals(2, book.numAuthors());
    int count = 0;
    for (Author au: book) {
      assertEquals (twoAuthors[count], au);
      ++count;
    }
    assertEquals (2, count);
    assertNotEquals(book, blank);
    assertNotEquals(book.hashCode(), blank.hashCode());
    String bookRepr = book.toString();
    assertTrue (bookRepr.contains(defaultTitle));
    assertTrue (bookRepr.contains(defaultISBN));
    assertTrue (bookRepr.contains("Jones"));
    assertTrue (bookRepr.contains("Smith"));
  }

  /**
   * Test method for {@link Book#addAuthor(bookstore.Author)}.
   */
  @Test
  public final void testAddAuthor() {
    Book book0 = new Book(defaultTitle, defaultPublisher, defaultISBN, twoAuthors);
    Book book = new Book(defaultTitle, defaultPublisher, defaultISBN, twoAuthors);
    
    book.addAuthor(smith); // already in the author list
    assertEquals(2, book.numAuthors());
    int count = 0;
    for (Author au: book) {
      assertEquals (twoAuthors[count], au);
      ++count;
    }
    assertEquals (2, count);
    assertEquals (book0, book);
    
    book.addAuthor(doe); // already in the author list
    Author[] threeAuthors = {jones, smith, doe};
    assertEquals(3, book.numAuthors());
    count = 0;
    for (Author au: book) {
      assertEquals (threeAuthors[count], au);
      ++count;
    }
    assertEquals (3, count);
    assertEquals (book0, book);
    
    assertEquals(defaultTitle, book.getTitle());
    assertEquals(defaultISBN, book.getISBN());
    assertEquals(defaultPublisher, book.getPublisher());

    assertEquals(book0.hashCode(), book.hashCode());
    String bookRepr = book.toString();
    assertTrue (bookRepr.contains(defaultTitle));
    assertTrue (bookRepr.contains(defaultPublisher));
    assertTrue (bookRepr.contains(defaultISBN));
    assertTrue (bookRepr.contains("Jones"));
    assertTrue (bookRepr.contains("Smith"));
    assertTrue (bookRepr.contains("Doe"));
  }

  /**
   * Test method for {@link Book#clone()}.
   */
  @Test
  public final void testClone() {
    Book book0 = new Book(defaultTitle, defaultPublisher, defaultISBN, twoAuthors);
    Book book = (Book)book0.clone();
    assertEquals(defaultTitle, book.getTitle());
    assertEquals(defaultISBN, book.getISBN());
    assertEquals(defaultPublisher, book.getPublisher());
    assertEquals(2, book.numAuthors());
    int count = 0;
    for (Author au: book) {
      assertEquals (twoAuthors[count], au);
      ++count;
    }
    assertEquals (2, count);
    assertEquals(book0, book);
    assertEquals(book.hashCode(), book0.hashCode());
    String bookRepr = book.toString();
    assertEquals (book0.toString(), bookRepr);
  }

}
