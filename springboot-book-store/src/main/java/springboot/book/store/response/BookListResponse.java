package springboot.book.store.response;

import java.util.List;
import springboot.book.store.entity.BookEntity;

/**
 *
 * @author francis taguiam
 */
public class BookListResponse extends BaseServiceResponse {

    private List<BookEntity> payload;

    public BookListResponse() {
    }

    public BookListResponse(List<BookEntity> payload) {
        this.payload = payload;
    }

    public BookListResponse(List<BookEntity> payload, ServiceStatus status) {
        super(status);
        this.payload = payload;
    }

    public BookListResponse(List<BookEntity> payload, ServiceStatus status, String message) {
        super(status, message);
        this.payload = payload;
    }

    public BookListResponse(ServiceStatus status, String message) {
        super(status, message);
    }

    public List<BookEntity> getPayload() {
        return payload;
    }

    public void setPayload(List<BookEntity> payload) {
        this.payload = payload;
    }

}
