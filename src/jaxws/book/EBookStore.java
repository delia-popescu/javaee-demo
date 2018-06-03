package jaxws.book;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface EBookStore {

    @WebMethod
    String welcomeMessage(String name);

    @WebMethod
    List<String> findEBooks(String text);

    @WebMethod
    EBook takeBook(String title);

    @WebMethod
    void saveBook(EBook eBook);

    @WebMethod
    EBook addAppendix(EBook eBook, int appendixPages);
}
