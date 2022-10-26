package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	@FXML private ComboBox   comboBox_search;
	@FXML private TableView  tableView_boardList;
	@FXML private TextField  textField_search;

	
	// 설정 초기화
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setComboBox();
		
	}
	
	//콤보박스 설정 메소드
	public void setComboBox(){
		//콤보박스에 값을 "제목","작성자",로 추가
		comboBox_search.getItems().addAll("제목","작성자");
		//초기값은 "제목"이 되도록 설정
		comboBox_search.setValue("제목");
	}
	
	// 
	public void setTableData(String boardTitle, String boardWriter) {
		
	}
	
	
	@FXML
	public void onclickSearch(ActionEvent event){
		System.out.println("클릭했습니다.");
//		String boardTitle = null;
//		String boardWriter = null;
//		
//		//콤보박스의 값이 "제목" 이면 검색조건값이 제목으로
//		//"작성자" 이면 검색조건값이 작성자로 매개변수를 설정
//		
//		if(comboBox_search.getValue().toString().equals("제목")){
//			boardTitle = textField_search.getText();
//		}else if(comboBox_search.getValue().toString().equals("작성자")){
//			boardWriter = textField_search.getText();
//		}
//
//		//테이블 데이터 설정 메서드에 두 매개변수를 보냄
//		//하지만 매개변수 중 하나만 조건 값이 들어있음
//		this.setTableData(boardTitle, boardWriter);
	}
	
	//게시판 내용을 새로 입력 클릭 이벤트
		@FXML
		public void clickInsert(ActionEvent event){
			//팝업창을 불러오기 위한 스테이지 생성
			Stage stage = new Stage();
			
			//Detail.fxml로부터 컴포넌트를 불러와서 Scene에 배치한다.
			FlowPane pane = null;
			
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("Detail.fxml"));
				pane = (FlowPane)loader.load();
				
				DetailController detailController=(DetailController)loader.getController();
//				detailController.setParentController(this);
				
				Scene scene = new Scene(pane, 600, 400);
				stage.setScene(scene);
				
				stage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

}
