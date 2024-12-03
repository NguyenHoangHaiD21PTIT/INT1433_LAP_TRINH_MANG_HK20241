
package vn.medianews;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ObjectService", targetNamespace = "http://medianews.vn/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ObjectService {


    /**
     * 
     * @param studentCode
     * @param qCode
     * @param object
     */
    @WebMethod
    @RequestWrapper(localName = "submitObject", targetNamespace = "http://medianews.vn/", className = "vn.medianews.SubmitObject")
    @ResponseWrapper(localName = "submitObjectResponse", targetNamespace = "http://medianews.vn/", className = "vn.medianews.SubmitObjectResponse")
    @Action(input = "http://medianews.vn/ObjectService/submitObjectRequest", output = "http://medianews.vn/ObjectService/submitObjectResponse")
    public void submitObject(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode,
        @WebParam(name = "object", targetNamespace = "")
        Object object);

    /**
     * 
     * @param studentCode
     * @param qCode
     * @return
     *     returns java.lang.Object
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "requestObject", targetNamespace = "http://medianews.vn/", className = "vn.medianews.RequestObject")
    @ResponseWrapper(localName = "requestObjectResponse", targetNamespace = "http://medianews.vn/", className = "vn.medianews.RequestObjectResponse")
    @Action(input = "http://medianews.vn/ObjectService/requestObjectRequest", output = "http://medianews.vn/ObjectService/requestObjectResponse")
    public Object requestObject(
        @WebParam(name = "studentCode", targetNamespace = "")
        String studentCode,
        @WebParam(name = "qCode", targetNamespace = "")
        String qCode);

}