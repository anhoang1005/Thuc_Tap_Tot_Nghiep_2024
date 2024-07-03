package VCCORP;

//Giao dien He thong thanh toan cu
interface OldPaymentSystem {
	void processPayment(String username, String paymentType, double amount);
}

//Phuong thuc su dung trong he thong thanh toan cu
class OldPaymentProcessor implements OldPaymentSystem {
	@Override
	public void processPayment(String username, String payMethod, double amount) {
		System.out.println("Thanh toan cho khach hang " + username + " bang " + payMethod + " gia tri " + amount +" bang he thong thanh toan cu!");
	}
}

//Giao fien he thong thanh toan moi
interface NewPaymentSystem {
	void makePayment(String username, double amount);
}

//Phuong thuc su dung trong he thong thanh toan moi
class NewPaymentProcessor implements NewPaymentSystem {
	@Override
	public void makePayment(String username, double amount) {
		System.out.println("Thanh toan cho khach hang " + username + " gia tri " + amount + " bang he thong thanh toan moi!");
	}
}

//Adqpter giup giao dien cu tuong thich giao dien moi
class PaymentAdapter implements OldPaymentSystem {
	private NewPaymentSystem newPaymentSystem;
	public PaymentAdapter(NewPaymentSystem newPaymentSystem) {
		this.newPaymentSystem = newPaymentSystem;
	}
	@Override
	public void processPayment(String username, String paymentType, double amount) {
		newPaymentSystem.makePayment(username, amount);
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		OldPaymentSystem oldPaymentSystem = new OldPaymentProcessor();
		oldPaymentSystem.processPayment("anhoang@gmail.com", "bank", 100.0);

		NewPaymentSystem newPaymentSystem = new NewPaymentProcessor();
		OldPaymentSystem adapter = new PaymentAdapter(newPaymentSystem);

		adapter.processPayment("anhoang@gmail.com", "credit", 150.0);
	}
}
