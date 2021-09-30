package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {

	public String FilePath;
	
	// BIẾN CHI PHÍ
	public double Luong1NV, SoLuongNV, TangLuong,CPBaoHiem, CPDaoTao, CPSinhHoat, CPQuangCao, CPSuaChua,
			CPThueDat, CPQuanLy, CPPhongNgu, CPDichVuKhac;
	public int KhauHao;
	@FXML
	private TextField SoLuongLaoDongTF, TienLuongTF, TangLuongTF, BaoHiemTF, DaoTaoTF, SinhHoatTF, QuangCaoTF,
			SuaChuaTF, ThueDatTF, QuanLyTF, PhongNguTF, DichVuKhacTF, KhauHaoTF;
	// BIẾN DOANH THU
	public double SoLuongPhong, GiaPhong, TDTangGia, DoanhThuKhac, CS1Nam, CS5NamSau, CSConLai;
	int SoNgay = 365;
	@FXML
	private TextField SoLuongPhongTF, GiaPhongTF, TDTangGiaTF, DoanhThuKhacTF, CS1NamTF, CS5NamSauTF, CSConLaiTF;
	
	// BIẾN DOANH THU VÀ CHI PHÍ CHO NHIỀU NĂM
	double[] DoanhThu;
	double[] ChiPhi;
	
	@FXML
	private TextField FilePathTF;
	
	@FXML 
	private TableView<DoanhThuVaChiPhi> table;
	
	@FXML
	private TableColumn<DoanhThuVaChiPhi, Integer> NamColumn;
	
	@FXML
	private TableColumn<DoanhThuVaChiPhi, Double> DoanhThuColumn;
	
	@FXML
	private TableColumn<DoanhThuVaChiPhi, Double> ChiPhiColumn;
	
	private ObservableList<DoanhThuVaChiPhi> DoanhThuVaChiPhiList;
	
	public void XuatDuLieu(ActionEvent event) throws IOException {
		FilePath = FilePathTF.getText();
		File f = new File(FilePath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		int soDong = 42;

		String[] data = new String[soDong];
		for (int i = 0; i < soDong; i++) {
			data[i] = br.readLine();
		}
		// Data từ dòng 16 - 31
		String[] cp16 = data[16].split("	");
		String[] cp17 = data[17].split("	");
		String[] cp18 = data[18].split("	");
		String[] cp19 = data[19].split("	");
		String[] cp21 = data[21].split("	");
		String[] cp22 = data[22].split("	");
		String[] cp23 = data[23].split("	");
		String[] cp24 = data[24].split("	");
		String[] cp25 = data[25].split("	");
		String[] cp26 = data[26].split("	");
		String[] cp28 = data[28].split("	");
		String[] cp29 = data[29].split("	");
		String[] cp31 = data[31].split("	");
		String[] cp34 = data[34].split("	");
		String[] cp36 = data[36].split("	");
		String[] cp37 = data[37].split("	");
		String[] cp38 = data[38].split("	");
		String[] cp39 = data[39].split("	");
		String[] cp40 = data[40].split("	");
		String[] cp41 = data[41].split("	");

		// CHI PHÍ TEXTFIELD
		TienLuongTF.setText(cp16[5]);
		SoLuongLaoDongTF.setText(cp17[6]);
		TangLuongTF.setText(cp18[3]);
		BaoHiemTF.setText(cp19[3]);
		DaoTaoTF.setText(cp21[3]);
		SinhHoatTF.setText(cp22[2]);
		QuangCaoTF.setText(cp23[2]);
		SuaChuaTF.setText(cp24[2]);
		ThueDatTF.setText(cp25[4]);
		QuanLyTF.setText(cp26[2]);
		PhongNguTF.setText(cp28[4]);
		DichVuKhacTF.setText(cp29[3]);
		KhauHaoTF.setText(cp31[3]);
		// DOANH THU TEXTFIELD
		SoLuongPhongTF.setText(cp34[4]);
		GiaPhongTF.setText(cp36[3]);
		TDTangGiaTF.setText(cp37[4]);
		DoanhThuKhacTF.setText(cp38[2]);
		CS1NamTF.setText(cp39[4]);
		CS5NamSauTF.setText(cp40[6]);
		CSConLaiTF.setText(cp41[6]);

		br.close();
	}

	public void XoaDuLieu(ActionEvent event) {
		TienLuongTF.setText("");
		SoLuongLaoDongTF.setText("");
		TangLuongTF.setText("");
		BaoHiemTF.setText("");
		DaoTaoTF.setText("");
		SinhHoatTF.setText("");
		QuangCaoTF.setText("");
		SuaChuaTF.setText("");
		ThueDatTF.setText("");
		QuanLyTF.setText("");
		PhongNguTF.setText("");
		DichVuKhacTF.setText("");
		KhauHaoTF.setText("");

		SoLuongPhongTF.setText("");
		GiaPhongTF.setText("");
		TDTangGiaTF.setText("");
		DoanhThuKhacTF.setText("");
		CS1NamTF.setText("");
		CS5NamSauTF.setText("");
		CSConLaiTF.setText("");
		
	}
	
	public void TinhToan(ActionEvent event) {
		
		//DOANH THU
		SoLuongPhong = Integer.parseInt(SoLuongPhongTF.getText());
		GiaPhong = Double.parseDouble(GiaPhongTF.getText());
		TDTangGia = Double.parseDouble(TDTangGiaTF.getText())*0.01;
		DoanhThuKhac = Double.parseDouble(DoanhThuKhacTF.getText())*0.01;
		CS1Nam = Double.parseDouble(CS1NamTF.getText())*0.01;
		CS5NamSau = Double.parseDouble(CS5NamSauTF.getText())*0.01;
		CSConLai = Double.parseDouble(CSConLaiTF.getText())*0.01;
		
		KhauHao = Integer.parseInt(KhauHaoTF.getText());
		
		DoanhThu = new double[KhauHao];
		for (int i = 0; i < DoanhThu.length; i++) {
			if (i == 0) {
				DoanhThu[i] = (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CS1Nam * SoNgay;
			} else if (i >= 1 && i <= 5) {
				GiaPhong += GiaPhong * TDTangGia;
				DoanhThu[i] = (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CS5NamSau * SoNgay
						+ (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CS5NamSau * SoNgay * TDTangGia;
			} else if (i > 5) {
				GiaPhong += GiaPhong * TDTangGia;
				DoanhThu[i] = (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CSConLai * SoNgay
						+ (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CSConLai * SoNgay * TDTangGia;
			}
		}
		
		
		// CHI PHÍ
		double CPKhac = Double.parseDouble(DaoTaoTF.getText())*0.01 + Double.parseDouble(SinhHoatTF.getText())*0.01
				+ Double.parseDouble(QuangCaoTF.getText())*0.01 + Double.parseDouble(SuaChuaTF.getText())*0.01
				+ Double.parseDouble(QuanLyTF.getText())*0.01 + Double.parseDouble(PhongNguTF.getText())*0.01;
		Luong1NV = Double.parseDouble(TienLuongTF.getText());
		SoLuongNV = Double.parseDouble(SoLuongLaoDongTF.getText());
		TangLuong = Double.parseDouble(TangLuongTF.getText())*0.01;
		CPBaoHiem = Double.parseDouble(BaoHiemTF.getText())*0.01;
		CPThueDat = Double.parseDouble(ThueDatTF.getText());
		CPDichVuKhac = Double.parseDouble(DichVuKhacTF.getText())*0.01;
		
		ChiPhi = new double[KhauHao];
		for (int i = 0; i < DoanhThu.length; i++) {
			if (i == 0) {
				ChiPhi[i] = DoanhThu[i] * CPKhac + Luong1NV *SoLuongNV* 12 + Luong1NV *SoLuongNV* 12 * CPBaoHiem + CPThueDat*12
						+ CPDichVuKhac*DoanhThuKhac*DoanhThu[i];
			} else if (i < 5) { 
				Luong1NV += Luong1NV*TangLuong;
				ChiPhi[i] = DoanhThu[i] * CPKhac + Luong1NV*SoLuongNV* 12 + Luong1NV *SoLuongNV* 12 * CPBaoHiem + CPThueDat*12
						+ CPDichVuKhac*DoanhThuKhac*DoanhThu[i];
			} else if (i >= 5) {
				Luong1NV += Luong1NV*TangLuong;
				ChiPhi[i] = DoanhThu[i] * (CPKhac-0.1) + Luong1NV *SoLuongNV * 12 + Luong1NV *SoLuongNV* 12 * CPBaoHiem + CPThueDat*12
						+ CPDichVuKhac*DoanhThuKhac*DoanhThu[i];
			}
		}
		
	}
	
	public void KetQua(ActionEvent event) {
		DoanhThuVaChiPhiList = FXCollections.observableArrayList();
		for (int i =0 ; i < DoanhThu.length; i++) {
			DoanhThuVaChiPhiList.add(new DoanhThuVaChiPhi(i+1, Math.round(DoanhThu[i]*100.0)/100.0, Math.round(ChiPhi[i]*100.0)/100.0));
		}
		
		NamColumn.setCellValueFactory(new PropertyValueFactory<DoanhThuVaChiPhi, Integer>("Nam"));
		DoanhThuColumn.setCellValueFactory(new PropertyValueFactory<DoanhThuVaChiPhi, Double>("DoanhThu"));
		ChiPhiColumn.setCellValueFactory(new PropertyValueFactory<DoanhThuVaChiPhi, Double>("ChiPhi"));
		table.setItems(DoanhThuVaChiPhiList);
	}
	
	
}