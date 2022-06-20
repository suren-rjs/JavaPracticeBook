public class Product {
  static int id = 1;
  int ProductId;
  String ProductName;
  int ProductPrice;
  int ProductCount;

  public Product(String productName, int productPrice, int productCount) {
    this.ProductId = id++;
    this.ProductName = productName;
    this.ProductPrice = productPrice;
    this.ProductCount = productCount;
  }
}
