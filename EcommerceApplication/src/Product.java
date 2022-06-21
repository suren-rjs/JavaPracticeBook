import java.util.*;

public class Product {
    static List<Product> productArrayList = new ArrayList<>();
    static Map<Integer, Product> allProducts = new HashMap<>();
    static Scanner input = new Scanner(System.in);
    static int id = 1;
    int productId;
    String productName;
    int productCount;
    int productPrice;

    public Product(String productName, int productPrice, int stockCount) {
        this.productId = id++;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount =stockCount;
    }

    public static void ProductsControlPanel() {
        System.out.println("1 -> Add new Product\n2 -> Update Product Stock\n3 -> Delete Product\n4 -> Back\nChoice");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                createNewProduct();
                break;
            case 2:
                System.out.println("Enter Product Id:");
                int productId = input.nextInt();
                if(!isExistingProduct(productId)) break;
                updateProductStock(productId);
                break;
            case 3:
                System.out.println("Enter Product Id:");
                productId = input.nextInt();
                if(!isExistingProduct(productId)) break;
                allProducts.remove(productId);
                System.out.println("=====================> Product Deleted!");
                break;
            case 4:
                AdminControlPanel.AdminControls("admin", "password");
                break;
        }
        ProductsControlPanel();
    }

    private static void updateProductStock(int productId) {
        Product currentProduct = allProducts.get(productId);
        System.out.println("Enter Stock:");
        int stockCount = input.nextInt();
        currentProduct.productCount =stockCount;
        System.out.println("=====================> Stock Updated!");
    }

    private static boolean isExistingProduct(int productId) {
        boolean isExisting = allProducts.containsKey(productId);
        if(!isExisting) System.out.println("Product Not Available!");
        return isExisting;
    }

    private static void createNewProduct() {
        System.out.println("Enter Product name, Price, Stock Count");
        String productName = input.next();
        int productPrice = input.nextInt();
        int stockCount = input.nextInt();
        Product newProduct = new Product(productName,productPrice,stockCount);
        allProducts.put(newProduct.productId, newProduct);
        System.out.println("Product "+newProduct.productName+" added with Stock Count : "+newProduct.productCount);
    }

    static void updateProductList() {
        productArrayList.clear();
        for (Product currentProduct : allProducts.values()) {
            productArrayList.add(currentProduct);
        }
    }
}
