package RMI;
import java.io.Serializable;
public class Product implements Serializable {
    private static final long serialVersionUID = 20151107L;
    private int id;
    private String code;
    private float importPrice;
    private float exportPrice;
    // Constructor mặc định
    public Product() {}
    // Constructor với các tham số
    public Product(int id, String code, float importPrice, float exportPrice) {
        this.id = id;
        this.code = code;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
    }
    //Viết hoa mã sản phẩm
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    //Xuất = Nhập + 20% -->Thay đổi xuất, lấy nhập -->setXuat, getNhap
    public float getImportPrice() {
        return importPrice;
    }
    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }
    // Phương thức toString để in thông tin sản phẩm
    @Override
    public String toString() {
        return "Product{id=" + id + ", code='" + code + "', importPrice=" + importPrice + ", exportPrice=" + exportPrice + "}";
    }
    //Đi thi không có thời gian đâu, cứ insert hết get set ra cần gì thì dùng cho tiện
}
