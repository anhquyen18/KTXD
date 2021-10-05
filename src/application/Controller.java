package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

	public String FileInput;
	public String FileOutput;

	// BIẾN CHI PHÍ
	public double Luong1NV, SoLuongNV, TangLuong, CPBaoHiem, CPDaoTao, CPSinhHoat, CPQuangCao, CPSuaChua, CPThueDat,
			CPQuanLy, CPPhongNgu, CPDichVuKhac;
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

	// BIẾN VỐN ĐẦU TƯ
	public double VDTChuaVAT, VDTThueVAT, VDTCoVAT, CPXDChuaVAT, CPXDThueVAT, CPXDCoVAT, VDTCoDinh, VonTuCo,
			VonTuCoTyLe, VonVay, VonVayTyLe;
	public int ThoiGianVayVon;
	@FXML
	private TextField VDTChuaVATTF, VDTThueVATTF, VDTCoVATTF, CPXDChuaVATTF, CPXDThueVATTF, CPXDCoVATTF, VDTCoDinhTF,
			VonTuCoTF, VonTuCoTyLeTF, VonVayTF, VonVayTyLeTF, ThoiGianVayVonTF;

	// BIẾN CHI PHÍ VỐN
	public double CPVonTuCo, LaiSuatDaiHan, LaiSuatNganHan;
	@FXML
	TextField CPVonTuCoTF, LaiSuatDaiHanTF, LaiSuatNganHanTF;

	// Table View
	@FXML
	private TextField FileInputTF, FileOutputTF;

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
		FileInput = FileInputTF.getText();
		File f = new File(FileInput);
		BufferedReader br = new BufferedReader(new FileReader(f));
		int soDong = 42;

		String[] data = new String[soDong];
		for (int i = 0; i < soDong; i++) {
			data[i] = br.readLine();
		}
		// Data chi phí từ dòng 16 - 31
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
		// Data doanh thu từ dòng 16 - 31
		String[] dt34 = data[34].split("	");
		String[] dt36 = data[36].split("	");
		String[] dt37 = data[37].split("	");
		String[] dt38 = data[38].split("	");
		String[] dt39 = data[39].split("	");
		String[] dt40 = data[40].split("	");
		String[] dt41 = data[41].split("	");
		// Data vốn đầu tư từ dòng 2 - 7
		String[] cp2 = data[2].split("	");
		String[] cp3 = data[3].split("	");
		String[] cp4 = data[4].split("	");
		String[] cp5 = data[5].split("	");
		String[] cp6 = data[6].split("	");
		String[] cp7 = data[7].split("	");
		// Dât chi phí vốn từ dòng 10 - 12
		String[] cp10 = data[10].split("	");
		String[] cp11 = data[11].split("	");
		String[] cp12 = data[12].split("	");

		// VỐN ĐẦU TƯ TEXTFIELD
		VDTChuaVATTF.setText(cp2[3]);
		VDTThueVATTF.setText(cp2[5]);
		VDTCoVATTF.setText(cp2[7]);
		CPXDChuaVATTF.setText(cp3[3]);
		CPXDThueVATTF.setText(cp3[5]);
		CPXDCoVATTF.setText(cp3[7]);
		VDTCoDinhTF.setText(cp4[2]);
		VonTuCoTF.setText(cp5[5]);
		VonTuCoTyLe = Math.round((Double.parseDouble(cp5[5]) * 100 / Double.parseDouble(cp4[2])) * 100.0) / 100.0;
		VonTuCoTyLeTF.setText(Double.toString(VonTuCoTyLe));
		VonVayTF.setText(cp6[4]);
		VonVayTyLe = Math.round((Double.parseDouble(cp6[4]) * 100 / Double.parseDouble(cp4[2])) * 100.0) / 100.0;
		VonVayTyLeTF.setText(Double.toString(VonVayTyLe));
		ThoiGianVayVonTF.setText(cp7[4]);

		// CHI PHÍ VỐN TEXTFIELD
		CPVonTuCoTF.setText(cp10[3]);
		LaiSuatDaiHanTF.setText(cp11[3]);
		LaiSuatNganHanTF.setText(cp12[3]);

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
		SoLuongPhongTF.setText(dt34[4]);
		GiaPhongTF.setText(dt36[3]);
		TDTangGiaTF.setText(dt37[4]);
		DoanhThuKhacTF.setText(dt38[2]);
		CS1NamTF.setText(dt39[4]);
		CS5NamSauTF.setText(dt40[6]);
		CSConLaiTF.setText(dt41[6]);

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
		
		VDTChuaVATTF.setText("");
		VDTThueVATTF.setText("");
		VDTCoVATTF.setText("");
		CPXDChuaVATTF.setText("");
		CPXDThueVATTF.setText("");
		CPXDCoVATTF.setText("");
		VDTCoDinhTF.setText("");
		VonTuCoTF.setText("");
		VonTuCoTyLeTF.setText("");
		VonVayTF.setText("");
		VonVayTyLeTF.setText("");
		ThoiGianVayVonTF.setText("");
		
		CPVonTuCoTF.setText("");
		LaiSuatDaiHanTF.setText("");
		LaiSuatNganHanTF.setText("");


	}

	public void TinhToan(ActionEvent event) {

		// DOANH THU
		SoLuongPhong = Integer.parseInt(SoLuongPhongTF.getText());
		GiaPhong = Double.parseDouble(GiaPhongTF.getText());
		TDTangGia = Double.parseDouble(TDTangGiaTF.getText()) * 0.01;
		DoanhThuKhac = Double.parseDouble(DoanhThuKhacTF.getText()) * 0.01;
		CS1Nam = Double.parseDouble(CS1NamTF.getText()) * 0.01;
		CS5NamSau = Double.parseDouble(CS5NamSauTF.getText()) * 0.01;
		CSConLai = Double.parseDouble(CSConLaiTF.getText()) * 0.01;

		KhauHao = Integer.parseInt(KhauHaoTF.getText());

		DoanhThu = new double[KhauHao];
		for (int i = 0; i < DoanhThu.length; i++) {
			if (i == 0) {
				DoanhThu[i] = (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CS1Nam * SoNgay;
			} else if (i >= 1 && i <= 5) {
				GiaPhong += GiaPhong * TDTangGia;
				DoanhThu[i] = (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CS5NamSau * SoNgay
						+ (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CS5NamSau * SoNgay
								* TDTangGia;
			} else if (i > 5) {
				GiaPhong += GiaPhong * TDTangGia;
				DoanhThu[i] = (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CSConLai * SoNgay
						+ (SoLuongPhong * GiaPhong + SoLuongPhong * GiaPhong * DoanhThuKhac) * CSConLai * SoNgay
								* TDTangGia;
			}
		}

		// CHI PHÍ
		CPDaoTao = Double.parseDouble(DaoTaoTF.getText()) * 0.01;
		CPSinhHoat = Double.parseDouble(SinhHoatTF.getText()) * 0.01;
		CPQuangCao = Double.parseDouble(QuangCaoTF.getText()) * 0.01;
		CPSuaChua = Double.parseDouble(SuaChuaTF.getText()) * 0.01;
		CPQuanLy = Double.parseDouble(QuanLyTF.getText()) * 0.01;
		CPPhongNgu = Double.parseDouble(PhongNguTF.getText()) * 0.01;
		Luong1NV = Double.parseDouble(TienLuongTF.getText());
		SoLuongNV = Double.parseDouble(SoLuongLaoDongTF.getText());
		TangLuong = Double.parseDouble(TangLuongTF.getText()) * 0.01;
		CPBaoHiem = Double.parseDouble(BaoHiemTF.getText()) * 0.01;
		CPThueDat = Double.parseDouble(ThueDatTF.getText());
		CPDichVuKhac = Double.parseDouble(DichVuKhacTF.getText()) * 0.01;
		double CPKhac = CPDaoTao + CPSinhHoat + CPQuangCao + CPSuaChua + CPQuanLy + CPPhongNgu;

		ChiPhi = new double[KhauHao];
		for (int i = 0; i < DoanhThu.length; i++) {
			if (i == 0) {
				ChiPhi[i] = DoanhThu[i] * CPKhac + Luong1NV * SoLuongNV * 12 + Luong1NV * SoLuongNV * 12 * CPBaoHiem
						+ CPThueDat * 12 + CPDichVuKhac * DoanhThuKhac * DoanhThu[i];
			} else if (i < 5) {
				Luong1NV += Luong1NV * TangLuong;
				ChiPhi[i] = DoanhThu[i] * CPKhac + Luong1NV * SoLuongNV * 12 + Luong1NV * SoLuongNV * 12 * CPBaoHiem
						+ CPThueDat * 12 + CPDichVuKhac * DoanhThuKhac * DoanhThu[i];
			} else if (i >= 5) {
				Luong1NV += Luong1NV * TangLuong;
				ChiPhi[i] = DoanhThu[i] * (CPKhac - CPQuangCao) + Luong1NV * SoLuongNV * 12
						+ Luong1NV * SoLuongNV * 12 * CPBaoHiem + CPThueDat * 12
						+ CPDichVuKhac * DoanhThuKhac * DoanhThu[i];
			}
		}

	}

	public void KetQua(ActionEvent event) {
		DoanhThuVaChiPhiList = FXCollections.observableArrayList();
		for (int i = 0; i < DoanhThu.length; i++) {
			DoanhThuVaChiPhiList.add(new DoanhThuVaChiPhi(i + 1, Math.round(DoanhThu[i] * 100.0) / 100.0,
					Math.round(ChiPhi[i] * 100.0) / 100.0));
		}

		NamColumn.setCellValueFactory(new PropertyValueFactory<DoanhThuVaChiPhi, Integer>("Nam"));
		DoanhThuColumn.setCellValueFactory(new PropertyValueFactory<DoanhThuVaChiPhi, Double>("DoanhThu"));
		ChiPhiColumn.setCellValueFactory(new PropertyValueFactory<DoanhThuVaChiPhi, Double>("ChiPhi"));
		table.setItems(DoanhThuVaChiPhiList);
	}

	public void XuatKetQua(ActionEvent event) throws IOException {
		FileOutput = FileOutputTF.getText();
		File f = new File(FileOutput);
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("Năm" + "	" + "Doanh Thu" + "	" + "Chi Phí" + "\n");
		for (int i = 0; i < DoanhThu.length; i++) {
			bw.write(i+1 + "	" + Math.round(DoanhThu[i] * 100.0) / 100.0 + "	" 
						+ Math.round(ChiPhi[i] * 100.0) / 100.0+"\n");
		}

		bw.close();
	}

}