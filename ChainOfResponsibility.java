package VCCORP;

class PaymentRequest{
	private String username;
	private String payMethod;
	private Double payAmount;
	
	public PaymentRequest(String username, String payMethod, Double payAmount) {
		this.username = username;
		this.payMethod = payMethod;
		this.payAmount = payAmount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
}

abstract class PaymentHandler {
    protected PaymentHandler successor;

    public void setSuccessor(PaymentHandler successor) {
        this.successor = successor;
    }

    public abstract void handlePayment(PaymentRequest request);
}

class BankPaymentHandler extends PaymentHandler {
    public void handlePayment(PaymentRequest request) {
        if (request.getPayMethod().equals("bank")) {
        	System.out.println("Thanh toan qua ngan hang!");
        } else if (successor != null) {
            successor.handlePayment(request);
        }
    }
}

class CreditPaymentHandler extends PaymentHandler {
    public void handlePayment(PaymentRequest request) {
        if (request.getPayMethod().equals("credit")) {
        	System.out.println("Thanh toan qua the tin dung!");
        } else if (successor != null) {
            successor.handlePayment(request);
        }
    }
}

class WalletPaymentHandler extends PaymentHandler {
    public void handlePayment(PaymentRequest request) {
        if (request.getPayMethod().equals("wallet")) {
        	System.out.println("Thanh toan qua vi dien tu!");
        } else if (successor != null) {
            successor.handlePayment(request);
        }
    }
}

class PaymentProcessingChain {
    private PaymentHandler chain;

    public PaymentProcessingChain() {
        buildChain();
    }
    private void buildChain() {
        chain = new BankPaymentHandler();
        PaymentHandler creditHandler = new CreditPaymentHandler();
        PaymentHandler walletHandler = new WalletPaymentHandler();

        chain.setSuccessor(creditHandler);
        creditHandler.setSuccessor(walletHandler);
    }
    public void processPayment(PaymentRequest request) {
        chain.handlePayment(request);
    }
}


public class ChainOfResponsibility {
    public static void main(String[] args) {
        PaymentProcessingChain paymentChain = new PaymentProcessingChain();
        PaymentRequest paymentRequest = new PaymentRequest("hoanvanan@gmail.com", "wallet", 135000.0);
        paymentChain.processPayment(paymentRequest);
    }
}
