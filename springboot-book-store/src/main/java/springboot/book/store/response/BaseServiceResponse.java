/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springboot.book.store.response;

/**
 *
 * @author francis taguiam
 */
public class BaseServiceResponse {

    private ServiceStatus status;
    private String message;

    public BaseServiceResponse() {
    }

    public BaseServiceResponse(ServiceStatus status) {
        this.status = status;
    }

    public BaseServiceResponse(ServiceStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
