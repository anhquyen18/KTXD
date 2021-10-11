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
	public double SoLuongPhong, GiaPhong, TDTangGia, DTNhaHang, DTMassage, CS1Nam, CS5NamSau, CSConLai;
	int SoNgay = 365;
	@FXML
	private TextField SoLuongPhongTF, GiaPhongTF, TDTangGiaTF, DTNhaHangTF, DTMassageTF, CS1NamTF, CS5NamSauTF, CSConLaiTF;

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
	public double CPVonTuCo, LaiSuatDaiHan, LaiSuatNganHan, LaiSuatTinhToan;
	@FXML
	private TextField CPVonTuCoTF, LaiSuatDaiHanTF, LaiSuatNganHanTF, LaiSuatTinhToanTF;

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
		int soDong = 43;

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
		String[] dt42 = data[42].split("	");
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
		LaiSuatTinhToanTF.setText("0");

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
		DTNhaHangTF.setText(dt38[4]);
		CS1NamTF.setText(dt39[4]);
		CS5NamSauTF.setText(dt40[6]);
		CSConLaiTF.setText(dt41[6]);
		DTMassageTF.setText(dt42[3]);

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
		
		// CHI PHÍ VỐN
		VDTCoVAT = Double.parseDouble(VDTCoVATTF.getText());
		VonTuCo = Double.parseDouble(VonTuCoTF.getText());
		VonVay = Double.parseDouble(VonVayTF.getText());
		CPVonTuCo = Double.parseDouble(CPVonTuCoTF.getText())*0.01;
		LaiSuatDaiHan = Double.parseDouble(LaiSuatDaiHanTF.getText())*0.01;
		
		double LaiSuatTinhToan = (VonTuCo*CPVonTuCo+VonVay*LaiSuatDaiHan)/VDTCoVAT;
		LaiSuatTinhToanTF.setText(Double.toString(LaiSuatTinhToan*100));

		// DOANH THU
		SoLuongPhong = Integer.parseInt(SoLuongPhongTF.getText());
		GiaPhong = Double.parseDouble(GiaPhongTF.getText());
		TDTangGia = Double.parseDouble(TDTangGiaTF.getText()) * 0.01;
		CS1Nam = Double.parseDouble(CS1NamTF.getText()) * 0.01;
		CS5NamSau = Double.parseDouble(CS5NamSauTF.getText()) * 0.01;
		CSConLai = Double.parseDouble(CSConLaiTF.getText()) * 0.01;
		KhauHao = Integer.parseInt(KhauHaoTF.getText());
		ThoiGianVayVon = Integer.parseInt(ThoiGianVayVonTF.getText());
		DTNhaHang = Double.parseDouble(DTNhaHangTF.getText()) * 0.01;
		DTMassage = Double.parseDouble(DTMassageTF.getText()) * 0.01;
		double DoanhThuKhac = DTNhaHang + DTMassage;
		
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
		
		double DoanhThuPhong = GiaPhong*SoNgay*SoLuongPhong;
		
		// TÍNH TỔNG DOANH THU VÀ CHI PHÍ THEO THỜI GIAN VAY VỐN
		DoanhThu = new double[ThoiGianVayVon];
		ChiPhi = new double[ThoiGianVayVon];
		for (int i = 0; i < DoanhThu.length; i++) {
			if (i == 0) {
				DoanhThu[i] = (1+ DoanhThuKhac)* DoanhThuPhong * CS1Nam;
				
				ChiPhi[i] = DoanhThu[i] * CPKhac + Luong1NV * SoLuongNV * 12 *(1+ CPBaoHiem)
						+ CPThueDat * 12 + CPDichVuKhac * (DoanhThuKhac-DTMassage) * DoanhThuPhong*CS1Nam;
			} else if (i >= 1 && i <= 5) {
				if ( i < 5) {
					DoanhThuPhong += DoanhThuPhong * TDTangGia;
					DoanhThu[i] = (1+ DoanhThuKhac)* DoanhThuPhong * CS5NamSau;
					Luong1NV += Luong1NV * TangLuong;
					
					ChiPhi[i] = DoanhThu[i] * CPKhac + Luong1NV * SoLuongNV * 12 *(1+ CPBaoHiem)
							+ CPThueDat * 12 + CPDichVuKhac * (DoanhThuKhac-DTMassage) * DoanhThuPhong*CS5NamSau;
				}else {
					DoanhThuPhong += DoanhThuPhong * TDTangGia;
					DoanhThu[i] = (1+ DoanhThuKhac)* DoanhThuPhong * CS5NamSau;
					
					Luong1NV += Luong1NV * TangLuong;
					ChiPhi[i] = DoanhThu[i] * (CPKhac - CPQuangCao) + Luong1NV * SoLuongNV * 12
							*(1+ CPBaoHiem) + CPThueDat * 12
							+ CPDichVuKhac * (DoanhThuKhac-DTMassage) * DoanhThuPhong*CS5NamSau;
				}				
			} else if (i > 5) {
				DoanhThuPhong += DoanhThuPhong * TDTangGia;
				DoanhThu[i] = (1+ DoanhThuKhac)* DoanhThuPhong  * CSConLai;
				
				Luong1NV += Luong1NV * TangLuong;
				ChiPhi[i] = DoanhThu[i] * (CPKhac - CPQuangCao) + Luong1NV * SoLuongNV * 12
						*(1+ CPBaoHiem) + CPThueDat * 12
						+ CPDichVuKhac *(DoanhThuKhac-DTMassage) * DoanhThuPhong*CSConLai;
			}
		}
		
		// TÍNH NPV
//		double TongChietKhau = 0;
//		for (int i = 0; i < DoanhThu.length; i++) {
//			TongChietKhau += (DoanhThu[i]-ChiPhi[i])/Math.pow(1+ LaiSuatTinhToan,i+1);
//		}
//		double NPV = TongChietKhau - VDTCoVAT;
		
		// TÍNH IRR
		double IRR = 0.0;
		double TongChietKhau = 0.0;
		double newNPV = 0.0;
		double rate = LaiSuatTinhToan;
		double rateGod = 0.0;
		for (int i = 0; i < 10; i++) {
			TongChietKhau = 0.0;
			for (int j = 0; j < DoanhThu.length; j++) {
					TongChietKhau += (DoanhThu[j]-ChiPhi[j])/Math.pow(1+ LaiSuatTinhToan+((double)i/100),j+1);
			}
			rate = LaiSuatTinhToan+ (double)i/100;
			newNPV = TongChietKhau - VDTCoVAT;	
			if (newNPV < 0) {
				for (int h = 1; h < 1000; h++) {
					TongChietKhau = 0.0;
					for (int j = 0; j < DoanhThu.length; j++) {
							TongChietKhau += (DoanhThu[j]-ChiPhi[j])/Math.pow(1+ rate-((double)h/100000),j+1);
					}
					newNPV = TongChietKhau - VDTCoVAT;
					rateGod = rate - (double)h/100000;	
					if (newNPV>-1.5) {
						for (int l =1; l < 1000; l++) {
							TongChietKhau = 0.0;
							for (int j = 0; j < DoanhThu.length; j++) {
								TongChietKhau += (DoanhThu[j]-ChiPhi[j])/Math.pow(1+ rateGod-((double)l/1000000),j+1);
							}
							newNPV = TongChietKhau - VDTCoVAT;
							IRR=rateGod-((double)l/1000000);
							if(newNPV > -0.2) {
								break;
							}
						}
						break;
					}	
				}
				break;
			}
		}
		System.out.println(Math.round(IRR*1000000.0)/1000000.0);
		
		
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