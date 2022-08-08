package jdk16;

import org.junit.Assert;
import org.junit.Test;

public class RecordStudy {

    @Test
    public void test1() {
        Book book = new Book("title", "author", "isbn");

        Assert.assertEquals(book.isbn(), "isbn");
        Assert.assertEquals(book.author(), "author");
        Assert.assertEquals(book.title(), "title_vincent");
    }

}
