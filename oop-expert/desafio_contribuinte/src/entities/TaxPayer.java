package entities;

public class TaxPayer {
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double salary = salaryIncome / 12;
		if (salary < 3000) {
			return 0;
		} else if (salary >= 3000 && salary < 5000) {
			return 0.1 * salaryIncome;
		}

		return 0.2 * salaryIncome;
	}

	public double servicesTax() {
		return 0.15 * servicesIncome;
	}

	public double capitalTax() {
		return 0.2 * capitalIncome;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double maxRebate = 0.3 * grossTax();
		double currentRebate = healthSpending + educationSpending;
		return currentRebate > maxRebate ? maxRebate : currentRebate;
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}
}
