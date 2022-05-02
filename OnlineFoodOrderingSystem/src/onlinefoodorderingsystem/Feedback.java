package onlinefoodorderingsystem;
import java.time.LocalDate;
import java.util.ArrayList;


public class Feedback {

	private Feedback_Detector F_Type;
	private int Feedback_Id;
	private LocalDate Feedback_Date;
	private String Feedback_Type;
	private String Feedback_Desc;
	private String Feedback_State;
	private int Order_Id;

	public Feedback(){
            Set_POC();
	}

        public void setF_Type(Feedback_Detector F_Type) {
            this.F_Type = F_Type;
        }

        public void setFeedback_Id(int Feedback_Id) {
            this.Feedback_Id = Feedback_Id;
        }

        public void setFeedback_Date(LocalDate Feedback_Date) {
            this.Feedback_Date = Feedback_Date;
        }

        public void setFeedback_Type(String Feedback_Type) {
            this.Feedback_Type = Feedback_Type;
        }

        public void setFeedback_Desc(String Feedback_Desc) {
            this.Feedback_Desc = Feedback_Desc;
        }

        public void setFeedback_State(String Feedback_State) {
            this.Feedback_State = Feedback_State;
        }

        public void setOrder_Id(int Order_Id) {
            this.Order_Id = Order_Id;
        }

        public Feedback_Detector getF_Type() {
            return F_Type;
        }

        public int getFeedback_Id() {
            return Feedback_Id;
        }

        public LocalDate getFeedback_Date() {
            return Feedback_Date;
        }

        public String getFeedback_Type() {
            return Feedback_Type;
        }

        public String getFeedback_Desc() {
            return Feedback_Desc;
        }

        public String getFeedback_State() {
            return Feedback_State;
        }

        public int getOrder_Id() {
            return Order_Id;
        }

        
	public void Set_POC(){
            F_Type = new Admin();
	}

}