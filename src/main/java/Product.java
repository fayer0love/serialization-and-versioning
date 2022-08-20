import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1234L;
    private String name;
    private String size;

    public Product(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String toString() {
        return "Product{name='" + this.name + "', size='" + this.size + "'}";
    }
}
