class Bank {

	int minbal() {
		return 1000;
	}
}

class SBI extends Bank {

	int minbal() {
		return 5000;
	}

}

class ICICI extends Bank {

}

class InheriTest {

	public static void main(String[] args) {
		Bank b = new SBI();
		System.out.println(b.minbal());
		b = new ICICI();
		System.out.println(b.minbal());
	}

}