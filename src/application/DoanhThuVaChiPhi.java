package application;

public class DoanhThuVaChiPhi {
	private int Nam;
	private double DoanhThu;
	private double ChiPhi;
	
	public DoanhThuVaChiPhi(int Nam, double DoanhThu, double ChiPhi) {
		this.Nam = Nam;
		this.DoanhThu = DoanhThu;
		this.ChiPhi = ChiPhi;
	}
	
	public DoanhThuVaChiPhi() {
		
	}
	
	public int getNam() {
		return Nam;
	}

	public void setNam(int nam) {
		Nam = nam;
	}

	public double getDoanhThu() {
		return DoanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		DoanhThu = doanhThu;
	}

	public double getChiPhi() {
		return ChiPhi;
	}

	public void setChiPhi(double chiPhi) {
		ChiPhi = chiPhi;
	}
}
