package VCCORP;

interface Product {
	void delivery();
}

class BookProduct implements Product {
	@Override
	public void delivery() {
		System.out.println("Dang giao hang san pham Book.");
	}
}

class ElectronicProduct implements Product {
	@Override
	public void delivery() {
		System.out.println("Dang giao hang san pham Electronic");
	}
}

class ProductFactory {
	public Product createProduct(String type) {
		if ("book".equalsIgnoreCase(type)) {
			return new BookProduct();
		} else if ("electronic".equalsIgnoreCase(type)) {
			return new ElectronicProduct();
		}
		throw new IllegalArgumentException("Khong ton tai: " + type);
	}
}

public class FactoryPattern {
	
	public static void main(String[] args) {
		ProductFactory factory = new ProductFactory();

		Product book = factory.createProduct("book");
		book.delivery();

		Product electronic = factory.createProduct("electronic");
		electronic.delivery();
	}
}
