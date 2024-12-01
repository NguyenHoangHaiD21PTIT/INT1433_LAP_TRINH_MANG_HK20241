
package vn.medianews;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the vn.medianews package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubmitDataIntMatrixResponse_QNAME = new QName("http://medianews.vn/", "submitDataIntMatrixResponse");
    private final static QName _SubmitDataIntResponse_QNAME = new QName("http://medianews.vn/", "submitDataIntResponse");
    private final static QName _GetDataDoubleResponse_QNAME = new QName("http://medianews.vn/", "getDataDoubleResponse");
    private final static QName _SubmitDataIntArrayResponse_QNAME = new QName("http://medianews.vn/", "submitDataIntArrayResponse");
    private final static QName _GetDataResponse_QNAME = new QName("http://medianews.vn/", "getDataResponse");
    private final static QName _SubmitDataStringResponse_QNAME = new QName("http://medianews.vn/", "submitDataStringResponse");
    private final static QName _SubmitDataStringArray_QNAME = new QName("http://medianews.vn/", "submitDataStringArray");
    private final static QName _SubmitDataStringArrayResponse_QNAME = new QName("http://medianews.vn/", "submitDataStringArrayResponse");
    private final static QName _SubmitDataString_QNAME = new QName("http://medianews.vn/", "submitDataString");
    private final static QName _GetData_QNAME = new QName("http://medianews.vn/", "getData");
    private final static QName _SubmitDataIntMatrix_QNAME = new QName("http://medianews.vn/", "submitDataIntMatrix");
    private final static QName _SubmitDataIntArray_QNAME = new QName("http://medianews.vn/", "submitDataIntArray");
    private final static QName _SubmitDataInt_QNAME = new QName("http://medianews.vn/", "submitDataInt");
    private final static QName _GetDataDouble_QNAME = new QName("http://medianews.vn/", "getDataDouble");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: vn.medianews
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubmitDataInt }
     * 
     */
    public SubmitDataInt createSubmitDataInt() {
        return new SubmitDataInt();
    }

    /**
     * Create an instance of {@link SubmitDataIntResponse }
     * 
     */
    public SubmitDataIntResponse createSubmitDataIntResponse() {
        return new SubmitDataIntResponse();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link GetDataDoubleResponse }
     * 
     */
    public GetDataDoubleResponse createGetDataDoubleResponse() {
        return new GetDataDoubleResponse();
    }

    /**
     * Create an instance of {@link GetDataDouble }
     * 
     */
    public GetDataDouble createGetDataDouble() {
        return new GetDataDouble();
    }

    /**
     * Create an instance of {@link GetData }
     * 
     */
    public GetData createGetData() {
        return new GetData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataIntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataIntMatrixResponse")
    public JAXBElement<SubmitDataIntResponse> createSubmitDataIntMatrixResponse(SubmitDataIntResponse value) {
        return new JAXBElement<SubmitDataIntResponse>(_SubmitDataIntMatrixResponse_QNAME, SubmitDataIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataIntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataIntResponse")
    public JAXBElement<SubmitDataIntResponse> createSubmitDataIntResponse(SubmitDataIntResponse value) {
        return new JAXBElement<SubmitDataIntResponse>(_SubmitDataIntResponse_QNAME, SubmitDataIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataDoubleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "getDataDoubleResponse")
    public JAXBElement<GetDataDoubleResponse> createGetDataDoubleResponse(GetDataDoubleResponse value) {
        return new JAXBElement<GetDataDoubleResponse>(_GetDataDoubleResponse_QNAME, GetDataDoubleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataIntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataIntArrayResponse")
    public JAXBElement<SubmitDataIntResponse> createSubmitDataIntArrayResponse(SubmitDataIntResponse value) {
        return new JAXBElement<SubmitDataIntResponse>(_SubmitDataIntArrayResponse_QNAME, SubmitDataIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "getDataResponse")
    public JAXBElement<GetDataResponse> createGetDataResponse(GetDataResponse value) {
        return new JAXBElement<GetDataResponse>(_GetDataResponse_QNAME, GetDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataIntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataStringResponse")
    public JAXBElement<SubmitDataIntResponse> createSubmitDataStringResponse(SubmitDataIntResponse value) {
        return new JAXBElement<SubmitDataIntResponse>(_SubmitDataStringResponse_QNAME, SubmitDataIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataStringArray")
    public JAXBElement<SubmitDataInt> createSubmitDataStringArray(SubmitDataInt value) {
        return new JAXBElement<SubmitDataInt>(_SubmitDataStringArray_QNAME, SubmitDataInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataIntResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataStringArrayResponse")
    public JAXBElement<SubmitDataIntResponse> createSubmitDataStringArrayResponse(SubmitDataIntResponse value) {
        return new JAXBElement<SubmitDataIntResponse>(_SubmitDataStringArrayResponse_QNAME, SubmitDataIntResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataString")
    public JAXBElement<SubmitDataInt> createSubmitDataString(SubmitDataInt value) {
        return new JAXBElement<SubmitDataInt>(_SubmitDataString_QNAME, SubmitDataInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "getData")
    public JAXBElement<GetData> createGetData(GetData value) {
        return new JAXBElement<GetData>(_GetData_QNAME, GetData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataIntMatrix")
    public JAXBElement<SubmitDataInt> createSubmitDataIntMatrix(SubmitDataInt value) {
        return new JAXBElement<SubmitDataInt>(_SubmitDataIntMatrix_QNAME, SubmitDataInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataIntArray")
    public JAXBElement<SubmitDataInt> createSubmitDataIntArray(SubmitDataInt value) {
        return new JAXBElement<SubmitDataInt>(_SubmitDataIntArray_QNAME, SubmitDataInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitDataInt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "submitDataInt")
    public JAXBElement<SubmitDataInt> createSubmitDataInt(SubmitDataInt value) {
        return new JAXBElement<SubmitDataInt>(_SubmitDataInt_QNAME, SubmitDataInt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataDouble }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://medianews.vn/", name = "getDataDouble")
    public JAXBElement<GetDataDouble> createGetDataDouble(GetDataDouble value) {
        return new JAXBElement<GetDataDouble>(_GetDataDouble_QNAME, GetDataDouble.class, null, value);
    }

}
