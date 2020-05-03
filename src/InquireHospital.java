import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InquireHospital extends Application 
{
	TextField id_doc = new TextField();
	TextField name_doc = new TextField();
	TextField sp_doc = new TextField();
	TextField time_doc = new TextField();
	TextField Quali_doc = new TextField();
	TextField room_doc = new TextField();
	
	TextField id_pat = new TextField();
	TextField name_pat = new TextField();
	TextField dis_pat = new TextField();
	TextField sex_pat = new TextField();
	TextField as_pat = new TextField();
	TextField age_pat = new TextField();
	
	TextField comp_med = new TextField();
	TextField name_med = new TextField();
	TextField exp_med = new TextField();
	TextField cost_med = new TextField();
	
	TextField facility_lab = new TextField();
	TextField cost_lab = new TextField();
	
	TextField facility_fac = new TextField();
	
	TextField id_nur = new TextField();
	TextField name_nur = new TextField();
	TextField gen_nur = new TextField();
	TextField sal_nur = new TextField();
	
	TextField id_sec = new TextField();
	TextField name_sec = new TextField();
	TextField gen_sec = new TextField();
	TextField sal_sec = new TextField();
	
	static Scene s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20;

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// TODO Auto-generated method stub
		Button Doctor = new Button("Click Me");
		Button Patients = new Button("Click Me");
		Button Medicines = new Button("Click Me");
		Button Laboratories = new Button("Click Me");
		Button Facilities = new Button("Click Me");
		Button Staff = new Button("Click Me");
		Button main_menu = new Button("MAIN MENU");
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		Label l = new Label("--------------------------------------------------------------------------------"
				+ "\n            *** Welcome to Hospital Inquiry System Project in Java ***"
				+ "\n--------------------------------------------------------------------------------");
		l.setTextFill(Color.BLACK);
		gp.add(l, 0, 0);
		gp.add(new Label("1) Doctor"), 0, 2);
		gp.add(Doctor, 2, 2);
		gp.add(new Label("2) Patients"), 0, 3);
		gp.add(Patients, 2, 3);
		gp.add(new Label("3) Medicines"), 0, 4);
		gp.add(Medicines, 2, 4);
		gp.add(new Label("4) Laboratories"), 0, 5);
		gp.add(Laboratories, 2, 5);
		gp.add(new Label("5) Facilities"), 0, 6);
		gp.add(Facilities, 2, 6);
		gp.add(new Label("6) Staff"), 0, 7);
		gp.add(Staff, 2, 7);
		
		
		Doctor.setOnAction(e->
		
		{
			Button add_doc = new Button("Add New Entry");
			Button show_doc = new Button("Show Doctors list");
			Button delete_doc = new Button("Delete Entry");
			GridPane gp1 = new GridPane();
			gp1.setHgap(10);
			gp1.setVgap(10);
			gp1.add(new Label("--------------------------------------------------------------------------------"
					+ "\n                            		 *****DOCTOR SECTION*****"
					+ "\n--------------------------------------------------------------------------------"), 0, 0);
			gp1.add(add_doc, 0, 1);
			gp1.add(show_doc, 0, 2);
			gp1.add(delete_doc, 0, 3);
			gp1.add(main_menu, 0, 4);
			add_doc.setOnAction(e1 -> 
			{
				GridPane gp2 = new GridPane();
				gp2.setHgap(10);
				gp2.setVgap(10);
				
				gp2.add(new Label("--------------------------------------------------------------------------------"
						+ "\n                            	 ***ENTER FOLLOWING DATAS***"
						+ "\n--------------------------------------------------------------------------------"), 0, 1);
				gp2.add(new Label("ID "), 0, 3);
				gp2.add(id_doc, 1, 3);
				
				gp2.add(new Label("NAME "), 0, 4);
				gp2.add(name_doc, 1, 4);
				
				gp2.add(new Label("SPECIALIZATION "), 0, 5);
				gp2.add(sp_doc, 1, 5);
				
				gp2.add(new Label("WORK TIME "), 0, 6);
				gp2.add(time_doc, 1, 6);
				
				gp2.add(new Label("QUALIFICATION "), 0, 7);
				gp2.add(Quali_doc, 1, 7);
				
				gp2.add(new Label("ROOM NO "), 0, 8);
				gp2.add(room_doc, 1, 8);
				
				gp2.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 gp2.setBackground(background);
				Button add_d = new Button("ADD");
				Button back_d = new Button("Back");
				gp2.add(back_d, 0, 10);
				gp2.add(add_d, 0, 9);
				
				add_d.setOnAction(e3 -> {
					int id =  Integer.parseInt(id_doc.getText());
					String room = room_doc.getText();
					System.out.println(room);
					String name= name_doc.getText();
					String specialist = sp_doc.getText();
					String time = time_doc.getText();
					String qualification = Quali_doc.getText();
					InquireHospital.insert_doctor(id, name, specialist, time, qualification, room);
					InquireHospital.select_doc();
				});
				back_d.setOnAction(e2 -> {
					System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
					primaryStage.setTitle("DOCTOR");
					primaryStage.setScene(s1);
				});
				s2 = new Scene(gp2,2000,700);
				primaryStage.setTitle("Add new Entry");
				primaryStage.setScene(s2);
				primaryStage.show();
				
				
			});
			
			show_doc.setOnAction(e4->
			{
				InquireHospital.select_doc();
			});
			
			delete_doc.setOnAction(e2 -> 
			{
				TextField del_doc = new TextField();
				InquireHospital.select_doc();
				GridPane gp13 = new GridPane();
				gp13.setHgap(10);
				gp13.setVgap(10);
				gp13.add(new Label("Enter ID to Delete"), 0, 1);
				gp13.add(del_doc, 1, 1);
				
				gp13.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 gp13.setBackground(background);
				s19 = new Scene(gp13,2000,700);
				primaryStage.setScene(s19);
				
				primaryStage.setTitle("DELETE");
				Button del_d = new Button("DELETE");
				Button back1_doc = new Button("Back");
				gp13.add(back1_doc, 0, 10);
				gp13.add(del_d, 0, 9);
				
				del_d.setOnAction(e4 -> 
				{
					int id = Integer.parseInt(del_doc.getText());
					InquireHospital.delete_doc(id);
					System.out.println("DELETED SUCCESSFULLY!!!");
					InquireHospital.select_doc();
					
				});
				back1_doc.setOnAction(e3 -> {
					primaryStage.setTitle("DOCTOR");
					primaryStage.setScene(s1);
				});
				
				
			});
			
			main_menu.setOnAction(e1 -> {
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				primaryStage.setTitle("MAIN MENU");
				primaryStage.setScene(s);
			});	
			gp1.setAlignment(Pos.CENTER);
			BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
	                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
			 Background background = new Background(background_fill);
			 gp1.setBackground(background);
			s1 = new Scene(gp1,2000,700);
			primaryStage.setTitle("Doctor");
			primaryStage.setScene(s1);
			primaryStage.show();
		});
		
		Patients.setOnAction(e->
		{
			Button add_pat = new Button("Add New Entry");
			Button show_pat = new Button("Show Patients list");
			GridPane gp3 = new GridPane();
			gp3.setHgap(10);
			gp3.setVgap(10);
			gp3.add(new Label("--------------------------------------------------------------------------------"
					+ "\n                            		 *****PATIENT SECTION*****"
					+ "\n--------------------------------------------------------------------------------"), 0, 0);
			gp3.add(add_pat, 0, 1);
			gp3.add(show_pat, 0, 2);
			gp3.add(main_menu, 0, 3);
			add_pat.setOnAction(e1 -> 
			{
				
				GridPane gp4 = new GridPane();
				gp4.setHgap(10);
				gp4.setVgap(10);
				
				gp4.add(new Label("--------------------------------------------------------------------------------"
						+ "\n                            	 ***ENTER FOLLOWING DATAS***"
						+ "\n--------------------------------------------------------------------------------"), 0, 1);
				gp4.add(new Label("ID "), 0, 3);
				gp4.add(id_pat, 1, 3);
				
				gp4.add(new Label("NAME "), 0, 4);
				gp4.add(name_pat, 1, 4);
				
				gp4.add(new Label("DISEASE "), 0, 5);
				gp4.add(dis_pat, 1, 5);
				
				gp4.add(new Label("SEX "), 0, 6);
				gp4.add(sex_pat, 1, 6);
				
				gp4.add(new Label("ADMIT STATUS "), 0, 7);
				gp4.add(as_pat, 1, 7);
				
				gp4.add(new Label("AGE "), 0, 8);
				gp4.add(age_pat, 1, 8);
				
				gp4.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 gp4.setBackground(background);
				Button add_p = new Button("ADD");
				Button back_p = new Button("Back");
				gp4.add(back_p, 0, 10);
				gp4.add(add_p, 0, 9);
				
				add_p.setOnAction(e2 -> {
					int id =  Integer.parseInt(id_pat.getText());
					String age = age_pat.getText();
					System.out.println(age);
					String name= name_pat.getText();
					String disease = dis_pat.getText();
					String sex = sex_pat.getText();
					String admit_status = as_pat.getText();
					InquireHospital.insert_patient(id, name, disease, sex, admit_status, age);
					InquireHospital.select_patient();
				});
				back_p.setOnAction(e2 -> {
					primaryStage.setTitle("PATIENT");
					primaryStage.setScene(s4);
				});
				s3 = new Scene(gp4,2000,700);
				primaryStage.setTitle("Add new Entry");
				primaryStage.setScene(s3);
				primaryStage.show();
				
				
			});
			
			show_pat.setOnAction(e4->
			{
				InquireHospital.select_patient();
			});
			main_menu.setOnAction(e1 -> {
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				primaryStage.setTitle("MAIN MENU");
				primaryStage.setScene(s);
			});	
			gp3.setAlignment(Pos.CENTER);
			
			BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
	                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
			 Background background = new Background(background_fill);
			 gp3.setBackground(background);
			 
			s4 = new Scene(gp3,2000,700);
			primaryStage.setTitle("Patient");
			primaryStage.setScene(s4);
			primaryStage.show();
		});
		
		Medicines.setOnAction(e->
		{
			Button add_med = new Button("Add New Entry");
			Button show_med = new Button("Show Medicines list");
			GridPane gp5 = new GridPane();
			gp5.setHgap(10);
			gp5.setVgap(10);
			gp5.add(new Label("--------------------------------------------------------------------------------"
					+ "\n                            		 *****MEDICINES SECTION*****"
					+ "\n--------------------------------------------------------------------------------"), 0, 0);
			gp5.add(add_med, 0, 1);
			gp5.add(show_med, 0, 2);
			gp5.add(main_menu, 0, 3);
			add_med.setOnAction(e1 -> 
			{
				
				GridPane gp6 = new GridPane();
				gp6.setHgap(10);
				gp6.setVgap(10);
				
				gp6.add(new Label("--------------------------------------------------------------------------------"
						+ "\n                            	 ***ENTER FOLLOWING DATAS***"
						+ "\n--------------------------------------------------------------------------------"), 0, 1);
				gp6.add(new Label("NAME "), 0, 3);
				gp6.add(name_med, 1, 3);
				
				gp6.add(new Label("COMPANY "), 0, 4);
				gp6.add(comp_med, 1, 4);
				
				gp6.add(new Label("EXPIRY DATE "), 0, 5);
				gp6.add(exp_med, 1, 5);
				
				gp6.add(new Label("COST "), 0, 6);
				gp6.add(cost_med, 1, 6);
				
				gp6.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 gp6.setBackground(background);
				Button add_m = new Button("ADD");
				gp6.add(add_m, 0, 9);
				Button back_m = new Button("Back");
				gp6.add(back_m, 0, 10);
				add_m.setOnAction(e2 -> {
					String name= name_med.getText();
					String company = comp_med.getText();
					String exp_date = exp_med.getText();
					String cost = cost_med.getText();
					InquireHospital.insert_medicines(name, company, exp_date, cost);
					InquireHospital.select_medicines();
				});
				
				back_m.setOnAction(e2 -> {
					primaryStage.setTitle("MEDICINES");
					primaryStage.setScene(s6);
				});
				s5 = new Scene(gp6,2000,700);
				primaryStage.setTitle("Add new Entry");
				primaryStage.setScene(s5);
				primaryStage.show();
				
				
			});
			
			show_med.setOnAction(e4->
			{
				InquireHospital.select_medicines();
			});
			main_menu.setOnAction(e1 -> {
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				primaryStage.setTitle("MAIN MENU");
				primaryStage.setScene(s);
			});	
			gp5.setAlignment(Pos.CENTER);
			BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
	                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
			 Background background = new Background(background_fill);
			 gp5.setBackground(background);
			s6 = new Scene(gp5,2000,700);
			primaryStage.setTitle("Medicine");
			primaryStage.setScene(s6);
			primaryStage.show();
		});
		
		Laboratories.setOnAction(e->
		{
			Button add_lab = new Button("Add New Entry");
			Button show_lab = new Button("Show Laboratory list");
			GridPane gp7 = new GridPane();
			gp7.setHgap(10);
			gp7.setVgap(10);
			gp7.add(new Label("--------------------------------------------------------------------------------"
					+ "\n                            		 *****LABORATORIES SECTION*****"
					+ "\n--------------------------------------------------------------------------------"), 0, 0);
			gp7.add(add_lab, 0, 1);
			gp7.add(show_lab, 0, 2);
			gp7.add(main_menu, 0, 3);
			add_lab.setOnAction(e1 -> 
			{
				
				GridPane gp8 = new GridPane();
				gp8.setHgap(10);
				gp8.setVgap(10);
				
				gp8.add(new Label("--------------------------------------------------------------------------------"
						+ "\n                            	 ***ENTER FOLLOWING DATAS***"
						+ "\n--------------------------------------------------------------------------------"), 0, 1);
				gp8.add(new Label("LAB FACILITY "), 0, 3);
				gp8.add(facility_lab, 1, 3);
				
				gp8.add(new Label("COST"), 0, 4);
				gp8.add(cost_lab, 1, 4);
				
				gp8.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 gp8.setBackground(background);
				Button add_l = new Button("ADD");
				gp8.add(add_l, 0, 9);
				Button back_l = new Button("Back");
				gp8.add(back_l, 0, 10);
				add_l.setOnAction(e2 -> {
					String facility= facility_lab.getText();
					String cost = cost_lab.getText();
					InquireHospital.insert_lab(facility, cost);
					InquireHospital.select_lab();
				});
				back_l.setOnAction(e2 -> {
					primaryStage.setTitle("LABORATORIES");
					primaryStage.setScene(s8);
				});
				s7 = new Scene(gp8,2000,700);
				primaryStage.setTitle("Add new Entry");
				primaryStage.setScene(s7);
				primaryStage.show();
				
				
			});
			
			show_lab.setOnAction(e4->
			{
				InquireHospital.select_lab();
			});
			main_menu.setOnAction(e1 -> {
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				primaryStage.setTitle("MAIN MENU");
				primaryStage.setScene(s);
			});	
			gp7.setAlignment(Pos.CENTER);
			BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
	                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
			 Background background = new Background(background_fill);
			 gp7.setBackground(background);
			s8 = new Scene(gp7,2000,700);
			primaryStage.setTitle("Laboratories");
			primaryStage.setScene(s8);
			primaryStage.show();
		});
		
		Facilities.setOnAction(e->
		{
			Button add_fac = new Button("Add New Entry");
			Button show_fac = new Button("Show Facilities list");
			GridPane gp9 = new GridPane();
			gp9.setHgap(10);
			gp9.setVgap(10);
			gp9.add(new Label("--------------------------------------------------------------------------------"
					+ "\n                            		 *****FACILITIES SECTION*****"
					+ "\n--------------------------------------------------------------------------------"), 0, 0);
			gp9.add(add_fac, 0, 1);
			gp9.add(show_fac, 0, 2);
			gp9.add(main_menu, 0, 3);
			add_fac.setOnAction(e1 -> 
			{
				
				GridPane gp10 = new GridPane();
				gp10.setHgap(10);
				gp10.setVgap(10);
				
				gp10.add(new Label("--------------------------------------------------------------------------------"
						+ "\n                            	 ***ENTER FOLLOWING DATAS***"
						+ "\n--------------------------------------------------------------------------------"), 0, 1);
				gp10.add(new Label(" FACILITY "), 0, 3);
				gp10.add(facility_fac, 1, 3);
				
				
				gp10.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 gp10.setBackground(background);
				Button add_f = new Button("ADD");
				gp10.add(add_f, 0, 9);
				Button back_f = new Button("Back");
				gp10.add(back_f, 0, 10);
				add_f.setOnAction(e2 -> {
					String facility= facility_fac.getText();
					InquireHospital.insert_facility(facility);
					InquireHospital.select_facility();
				});
				back_f.setOnAction(e2 -> {
					primaryStage.setTitle("FACILITIES");
					primaryStage.setScene(s10);
				});
				s9 = new Scene(gp10,2000,700);
				primaryStage.setTitle("Add new Entry");
				primaryStage.setScene(s9);
				primaryStage.show();
				
				
			});
			
			show_fac.setOnAction(e4->
			{
				InquireHospital.select_facility();			
			});
			main_menu.setOnAction(e1 -> {
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				primaryStage.setTitle("MAIN MENU");
				primaryStage.setScene(s);
			});	
			gp9.setAlignment(Pos.CENTER);
			BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
	                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
			 Background background = new Background(background_fill);
			 gp9.setBackground(background);
			s10 = new Scene(gp9,2000,700);
			primaryStage.setTitle("Facilities");
			primaryStage.setScene(s10);
			primaryStage.show();
		});
		
		Staff.setOnAction(e->
		{
			Button nurse = new Button("NURSE");
			Button security = new Button("SECURITY");
			GridPane g = new GridPane();
			g.setHgap(10);
			g.setVgap(10);
			g.add(new Label("--------------------------------------------------------------------------------"
					+ "\n                            		 *****STAFF SECTION*****"
					+ "\n--------------------------------------------------------------------------------"), 0, 0);
			g.add(nurse, 0, 1);
			g.add(security, 0, 2);
			g.add(main_menu, 0, 3);
			nurse.setOnAction(e1->
			{
				Button add_nur = new Button("Add New Entry");
				Button show_nur = new Button("Show Nurses  list");
				Button delete_nur = new Button("Delete Entry");
				Button back_nur = new Button("Back");
				GridPane g1 = new GridPane();
				g1.setHgap(10);
				g1.setVgap(10);
				g1.add(new Label("--------------------------------------------------------------------------------" 
						+ "\n                            		 *****NURSES SECTION*****"
						+ "\n--------------------------------------------------------------------------------"), 0, 0);
				
				g1.add(add_nur, 0, 1);
				g1.add(show_nur, 0, 2);
				g1.add(delete_nur, 0, 3);
				g1.add(back_nur, 0, 4);
				g1.add(main_menu, 0, 5);
				add_nur.setOnAction(e3 -> 
				{
					
					GridPane g2 = new GridPane();
					g2.setHgap(10);
					g2.setVgap(10);
					
					g2.add(new Label("--------------------------------------------------------------------------------"
							+ "\n                            	 ***ENTER FOLLOWING DATAS***"
							+ "\n--------------------------------------------------------------------------------"), 0, 1);
					g2.add(new Label("ID"), 0, 3);
					g2.add(id_nur, 1, 3);
					g2.add(new Label("NAME"), 0, 4);
					g2.add(name_nur, 1, 4);
					g2.add(new Label("GENDER"), 0, 5);
					g2.add(gen_nur, 1, 5);
					g2.add(new Label("SALARY"), 0, 6);
					g2.add(sal_nur, 1, 6);
					
					g2.setAlignment(Pos.CENTER);
					
					BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
			                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
					 Background background = new Background(background_fill);
					 g2.setBackground(background);
					 
					Button add_n = new Button("ADD");
					Button back1_nur = new Button("Back");
					g2.add(back1_nur, 0, 10);
					g2.add(add_n, 0, 9);
					
					add_n.setOnAction(e2 -> {
						int id =  Integer.parseInt(id_nur.getText());
						String name= name_nur.getText();
						String gender= gen_nur.getText();
						String salary = sal_nur.getText();
						Staff_db.insert_nurse(id, name, gender, salary);
						Staff_db.select_nurse();
					});
					back1_nur.setOnAction(e2 -> {
						primaryStage.setTitle("NURSES");
						primaryStage.setScene(s15);
					});
					s14 = new Scene(g2,2000,700);
					primaryStage.setTitle("Add new Entry");
					primaryStage.setScene(s14);
					primaryStage.show();
					
				});
				show_nur.setOnAction(e4->
				{
					Staff_db.select_nurse();			
				});
				
				delete_nur.setOnAction(e2 -> 
				{
					TextField del_nur = new TextField();
					Staff_db.select_nurse();
					GridPane g6 = new GridPane();
					g6.setHgap(10);
					g6.setVgap(10);
					g6.add(new Label("Enter ID to Delete"), 0, 1);
					g6.add(del_nur, 1, 1);
					
					g6.setAlignment(Pos.CENTER);
					BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
			                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
					 Background background = new Background(background_fill);
					 g6.setBackground(background);
					s19 = new Scene(g6,2000,700);
					primaryStage.setScene(s19);
					
					primaryStage.setTitle("DELETE");
					Button del_n = new Button("DELETE");
					Button back2_nur = new Button("Back");
					g6.add(back2_nur, 0, 10);
					g6.add(del_n, 0, 9);
					
					del_n.setOnAction(e4 -> 
					{
						int id = Integer.parseInt(del_nur.getText());
						Staff_db.delete_nurse(id);
						System.out.println("DELETED SUCCESSFULLY!!!");
						Staff_db.select_nurse();
						
					});
					back2_nur.setOnAction(e3 -> {
						primaryStage.setTitle("NURSES");
						primaryStage.setScene(s15);
					});
					
					
				});
				
				back_nur.setOnAction(e2 -> {
					System.out.println(" \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
					primaryStage.setTitle("STAFF");
					primaryStage.setScene(s16);
				});
				g.add(main_menu, 0, 3);
				main_menu.setOnAction(e2 -> {
					System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
					primaryStage.setTitle("MAIN MENU");
					primaryStage.setScene(s);
				});	
				g1.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 g1.setBackground(background);
				s15 = new Scene(g1,2000,700);
				primaryStage.setScene(s15);
				primaryStage.setTitle("NURSES");
				
				primaryStage.show();
			});
			
			
			main_menu.setOnAction(e1 -> {
				System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
				primaryStage.setTitle("MAIN MENU");
				primaryStage.setScene(s);
			});	
			
			security.setOnAction(e1->
			{
				Button add_sec = new Button("Add New Entry");
				Button show_sec = new Button("Show Security list");
				Button delete_sec = new Button("Delete Entry");
				Button back_sec = new Button("Back");
				GridPane g3 = new GridPane();
				g3.setHgap(10);
				g3.setVgap(10);
				g3.add(new Label("--------------------------------------------------------------------------------" 
						+ "\n                            		 *****SECURITIES SECTION*****"
						+ "\n--------------------------------------------------------------------------------"), 0, 0);
				
				g3.add(add_sec, 0, 1);
				g3.add(show_sec, 0, 2);
				g3.add(delete_sec, 0, 3);
				g3.add(back_sec, 0, 4);
				g3.add(main_menu, 0, 5);
				add_sec.setOnAction(e3 -> 
				{
					
					GridPane g4 = new GridPane();
					g4.setHgap(10);
					g4.setVgap(10);
					
					g4.add(new Label("--------------------------------------------------------------------------------"
							+ "\n                            	 ***ENTER FOLLOWING DATAS***"
							+ "\n--------------------------------------------------------------------------------"), 0, 1);
					g4.add(new Label("ID"), 0, 3);
					g4.add(id_nur, 1, 3);
					g4.add(new Label("NAME"), 0, 4);
					g4.add(name_nur, 1, 4);
					g4.add(new Label("GENDER"), 0, 5);
					g4.add(gen_nur, 1, 5);
					g4.add(new Label("SALARY"), 0, 6);
					g4.add(sal_nur, 1, 6);
					
					g4.setAlignment(Pos.CENTER);
					
					BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
			                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
					 Background background = new Background(background_fill);
					 g4.setBackground(background);
					 
					Button add_s = new Button("ADD");
					Button back1_sec = new Button("Back");
					g4.add(back1_sec, 0, 10);
					g4.add(add_s, 0, 9);
					
					add_s.setOnAction(e2 -> {
						int id =  Integer.parseInt(id_nur.getText());
						String name= name_nur.getText();
						String gender= gen_nur.getText();
						String salary = sal_nur.getText();
						Staff_db.insert_security(id, name, gender, salary);
						Staff_db.select_security();
					});
					back1_sec.setOnAction(e2 -> {
						primaryStage.setTitle("SECURITIES");
						primaryStage.setScene(s15);
					});
					s14 = new Scene(g4,2000,700);
					primaryStage.setTitle("Add new Entry");
					primaryStage.setScene(s14);
					primaryStage.show();
					
				});
				show_sec.setOnAction(e4->
				{
					Staff_db.select_security();			
				});
				
				delete_sec.setOnAction(e2 -> 
				{
					TextField del_sec = new TextField();
					Staff_db.select_security();
					GridPane g5 = new GridPane();
					g5.setHgap(10);
					g5.setVgap(10);
					g5.add(new Label("Enter ID to Delete"), 0, 1);
					g5.add(del_sec, 1, 1);
					
					g5.setAlignment(Pos.CENTER);
					BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
			                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
					 Background background = new Background(background_fill);
					 g5.setBackground(background);
					s18 = new Scene(g5,2000,700);
					primaryStage.setScene(s18);
					
					primaryStage.setTitle("DELETE");
					Button del_s = new Button("DELETE");
					Button back2_sec = new Button("Back");
					g5.add(back2_sec, 0, 10);
					g5.add(del_s, 0, 9);
					
					del_s.setOnAction(e4 -> 
					{
						int id = Integer.parseInt(del_sec.getText());
						Staff_db.delete_security(id);
						System.out.println("DELETED SUCCESSFULLY!!!");
						Staff_db.select_security();
						
					});
					back2_sec.setOnAction(e3 -> {
						primaryStage.setTitle("SECURITY");
						primaryStage.setScene(s15);
					});
					
					
				});
				
				back_sec.setOnAction(e2 -> {
					System.out.println(" \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n ");
					primaryStage.setTitle("STAFF");
					primaryStage.setScene(s16);
				});
				g.add(main_menu, 0, 3);
				main_menu.setOnAction(e2 -> {
					System.out.println("\n \n \n \n \n \n \n \n \n \n \n ");
					primaryStage.setTitle("MAIN MENU");
					primaryStage.setScene(s);
				});	
				g3.setAlignment(Pos.CENTER);
				BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
		                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
				 Background background = new Background(background_fill);
				 g3.setBackground(background);
				s15 = new Scene(g3,2000,700);
				primaryStage.setScene(s15);
				primaryStage.setTitle("NURSES");
				
				primaryStage.show();
			});
			
			g.setAlignment(Pos.CENTER);
			BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
	                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
			 Background background = new Background(background_fill);
			 g.setBackground(background);
			s16 = new Scene(g,2000,700);
			primaryStage.setTitle("STAFF");
			primaryStage.setScene(s16);
			primaryStage.show();
			
			
			
		});
		
		gp.setAlignment(Pos.CENTER);
		
		BackgroundFill background_fill = new BackgroundFill(Color.CORNFLOWERBLUE,  
                CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		 Background background = new Background(background_fill);
		 gp.setBackground(background);
		 
		s = new Scene(gp,2000,700);
		primaryStage.setTitle("MAIN MENU");
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		//createTable_doctor();
		//insert_doctor(21, "Dr.Dharmendra", "ENT", "5-11AM", "MBBS,MD", "17");
		//insert_doctor(20, "Dr.Shah", "Surgeon", "5-11AM", "MBBS,MD", "18");
		//select_doc();
		//createTable_patient();
		//insert_patient(12, "Pankaj", "Cancer", "male", "y", "30");
		//select_patient();
		//createTable_medicines();
		//insert_medicines("Corex", "Cino pvt", "9-5-22", "55");
		//select_medicines();
		//createTable_lab();
		//insert_lab("X-ray", "800");
		//select_lab();
		//createTable_facility();
		//insert_facility("Ambulance");
		//select_facility();
		//Staff_db.createTable_nurse();
		//Staff_db.createTable_security();
		//Staff_db.select_nurse();
		//Staff_db.select_security();
		//HospitalManagement.delete_doc(21);
		launch(args);
	}
		 		
	private static Connection connect() 
	{  
		// SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
		Connection conn = null;  
		try
		{  
			conn = DriverManager.getConnection(url);  
			conn.setAutoCommit(false);
			conn.setReadOnly(false);
		} 
		catch (SQLException e) 
		{  
			System.out.println(e.getMessage());  
		}  
		return conn;	 		
	}
	static void createTable_doctor()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS doctors (\n"  
                + " Id integer PRIMARY KEY,\n"  
                + " Name text ,\n"
                +"Specialist text ,\n"
                +"Timing text ,\n"
                +"Qualification text ,\n"
                + "Room_No text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	} 
	
	static void insert_doctor(int Id,String Name,String Specialist,String Timing,String Qualification,String Room_no)
	{  								//insert function
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
        String sql = "INSERT INTO doctors (Id,Name,Specialist,Timing,Qualification,Room_NO) VALUES(?,?,?,?,?,?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, Id);
            pstmt.setString(2, Name);
            pstmt.setString(3, Specialist);
            pstmt.setString(4, Timing);
            pstmt.setString(5, Qualification);
            pstmt.setString(6, Room_no);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }  
	
	static void select_doc()
    {  
        String sql = "SELECT * FROM doctors";  
        try 
        {  
        	Connection conn = null;
            conn = connect();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            System.out.println("\n \n \n");
            System.out.println("DOCTORS LIST:-");
            System.out.println();
            System.out.println("ID\t" + "Doctor's Name \t " + " \t Specialist \t     "+ " \t Timing \t \t"+ "Qualification\t\t"+"R_No"); 
            System.out.println("");
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getInt("Id") +  "\t" +   
                                   rs.getString("Name") + " \t \t  " +  
                                   rs.getString("Specialist")+ " \t \t "+
                                   rs.getString("TIming")+ " \t \t  " +
                                   rs.getString("Qualification")+ " \t \t " +
                                   rs.getString("Room_no"));  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }
	
	static void delete_doc(int id)
	{
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
		String sql = "DELETE FROM doctors WHERE Id = ?";
		
		Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void createTable_patient()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS patients (\n"  
                + " Id integer PRIMARY KEY,\n"  
                + " Name text ,\n"
                +"Disease text ,\n"
                +"Gender text ,\n"
                +"Admit_Status text ,\n"
                + "Age text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void insert_patient(int Id,String Name,String Disease,String Gender,String Admit_status,String age)
	{  								//insert function
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
        String sql = "INSERT INTO patients (Id,Name,Disease,Gender,Admit_status,age) VALUES(?,?,?,?,?,?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, Id);
            pstmt.setString(2, Name);
            pstmt.setString(3, Disease);
            pstmt.setString(4, Gender);
            pstmt.setString(5, Admit_status);
            pstmt.setString(6, age);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }
	
	static void select_patient()
    {  
        String sql = "SELECT * FROM patients";  
        try 
        {  
        	Connection conn = null;
            conn = connect();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            System.out.println("\n \n \n");
            System.out.println("PATIENTS LIST:-");
            System.out.println();
            System.out.println("ID\t" + "Name\t      " + "DISEASE\t\t  "+ "GENDER\t"+ "ADMIT_STATUS\t"+ "age\t"); 
            System.out.println();
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getInt("Id") +  "\t" +   
                                   rs.getString("Name") + "\t\t" +  
                                   rs.getString("Disease")+ "\t\t   " +
                                   rs.getString("Gender")+ "\t\t   " +
                                   rs.getString("Admit_status")+ "\t\t   " +
                                   rs.getString("age"));  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }
	
	
	static void createTable_medicines()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS medicines (\n"  
                + " Name text ,\n"
                +"Company text ,\n"
                +"Exp_date text ,\n"
                +"Cost text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void insert_medicines(String Name,String Company,String Exp_date,String Cost)
	{  								//insert function
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
        String sql = "INSERT INTO medicines (Name,Company,Exp_date,Cost) VALUES(?,?,?,?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, Name);
            pstmt.setString(2,Company);
            pstmt.setString(3, Exp_date);
            pstmt.setString(4, Cost);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }
	
	static void select_medicines()
    {  
        String sql = "SELECT * FROM medicines";  
        try 
        {  
        	Connection conn = null;
            conn = connect();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            
            System.out.println("\n \n \n");
            System.out.println("MEDICINES LIST:-");
            System.out.println();
            System.out.println("NAME \t" + "COMPANY \t" + "EXP_DATE\t"+ "COST\t"); 
            System.out.println();
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getString("Name") + " \t" +  
                                   rs.getString("Company")+ " \t " +
                                   rs.getString("Exp_date")+ " \t " +
                                   rs.getString("Cost"));  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }
	
	static void createTable_lab()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS lab (\n"  
                + " Facilities text ,\n"
                +"Cost text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void insert_lab(String Facilities,String Cost)
	{  								//insert function
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
        String sql = "INSERT INTO lab (Facilities,Cost) VALUES(?,?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, Facilities);
            pstmt.setString(2, Cost);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }
	
	static void select_lab()
    {  
        String sql = "SELECT * FROM lab";  
        try 
        {  
        	Connection conn = null;
            conn = connect();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);
            
            System.out.println("\n \n \n");
            System.out.println("LABORATORY LIST:-");
            System.out.println();
            System.out.println("FACILITIES \t " + "COST \t "); 
            System.out.println();
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getString("Facilities") + " \t   " + 
                                   rs.getString("Cost")+ " \t ");  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }
	
	static void createTable_facility()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS facility (\n"  
                + " Facility text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void insert_facility(String Facility)
	{  								//insert function
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Hospital.db";
        String sql = "INSERT INTO facility (Facility) VALUES(?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, Facility);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }
	
	static void select_facility()
    {  
        String sql = "SELECT * FROM facility";  
        try 
        {  
        	Connection conn = null;
            conn = connect();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);
            
            System.out.println("\n \n \n");
            System.out.println("FACILITY LIST:-");
            System.out.println();
            System.out.println("AVAILABLE FACILITIES "); 
            System.out.println();
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getString("Facility"));  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }

}
class Staff_db
{
	private static Connection connect1() 
	{  
		// SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";  
		Connection conn = null;  
		try
		{  
			conn = DriverManager.getConnection(url);  
			conn.setAutoCommit(false);
			conn.setReadOnly(false);
		} 
		catch (SQLException e) 
		{  
			System.out.println(e.getMessage());  
		}  
		return conn;	 		
	}
	
	static void createTable_nurse()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS nurse (\n"  
                + " Id integer ,\n"
                +"Name text ,\n"
                +"Gender text ,\n"
                +"Salary text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void createTable_security()
	{												//createNewTable function
        // SQLite connection string  
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";
    	Connection conn=null;  
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS security (\n"  
                + " Id integer ,\n"
                +"Name text ,\n"
                +"Gender text ,\n"
                +"Salary text);";  
        try{
        	
        	conn = DriverManager.getConnection(url);  
        	conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();  
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}
	static void insert_nurse(int Id,String Name,String Gender,String Salary)
	{  								//insert function
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";
        String sql = "INSERT INTO nurse (Id,Name,Gender,Salary) VALUES(?,?,?,?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, Id);
            pstmt.setString(2,Name);
            pstmt.setString(3, Gender);
            pstmt.setString(4, Salary);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }
	
	static void delete_nurse(int id)
	{
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";
		String sql = "DELETE FROM nurse WHERE Id = ?";
		
		Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
	}
	static void delete_security(int id)
	{
		String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";
		String sql = "DELETE FROM security WHERE Id = ?";
		
		Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
	}
	
	static void insert_security(int Id,String Name,String Gender,String Salary)
	{  								//insert function
    	String url = "jdbc:sqlite:C:\\Users\\Siddhidi\\Desktop\\4th sem\\java-2019-122\\InquireHospital\\Database\\Staff.db";
        String sql = "INSERT INTO security (Id,Name,Gender,Salary) VALUES(?,?,?,?)";  
        Connection conn=null;
        try{  
            //Store.conn = SelectRecords.connect();
        	conn= DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setInt(1, Id);
            pstmt.setString(2,Name);
            pstmt.setString(3, Gender);
            pstmt.setString(4, Salary);
            pstmt.executeUpdate();
            pstmt.close();
            
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage());  
        }  
        
    }
	
	static void select_nurse()
    {  
        String sql = "SELECT * FROM nurse";  
        try 
        {  
        	Connection conn = null;
            conn = connect1();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            System.out.println("\n \n \n");
            System.out.println("NURSES LIST:-");
            System.out.println();
            System.out.println("ID \t " + "NAME \t " + "   GENDER \t "+ "SALARY \t "); 
            System.out.println();
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getString("ID") + "\t" +  
                                   rs.getString("NAME")+ "\t   " +
                                   rs.getString("GENDER")+ "\t   " +
                                   rs.getString("SALARY"));  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }
	
	static void select_security()
    {  
        String sql = "SELECT * FROM security";  
        try 
        {  
        	Connection conn = null;
            conn = connect1();
            conn.commit();
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            System.out.println("\n \n \n");
            System.out.println("SECURITY LIST");
            System.out.println();
            System.out.println("ID \t " + "NAME \t " + " \t GENDER \t "+ "SALARY \t "); 
            System.out.println();
            // loop through the result set  
            while (rs.next()) 
            {  
                System.out.println(rs.getString("ID") + " \t " +  
                                   rs.getString("NAME")+ " \t   " +
                                   rs.getString("GENDER")+ " \t " +
                                   rs.getString("SALARY"));  
            } 
           // Store.conn.commit();
            conn.close();
        } 
        catch (SQLException e) 
        {  
            System.out.println(e.getMessage()); 
        }
     }
}