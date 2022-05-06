package onlinefoodorderingsystem;
import java.time.LocalDate;
import java.util.ArrayList;


public class Feedback {

	private Feedback_Detector F_Type;
	private int Feedback_Id;
	private String FeedbackDate;
	private String Feedback_Type;
	private String Feedback_Desc;
	private String Feedback_State;
	private int Order_Id;
        private int rate;

        public Feedback(int Feedback_Id, String Feedback_Date, String Feedback_Type, String Feedback_Desc, String Feedback_State, int Order_Id) {
            this.Feedback_Id = Feedback_Id;
            this.FeedbackDate = Feedback_Date;
            this.Feedback_Type = Feedback_Type;
            this.Feedback_Desc = Feedback_Desc;
            this.Feedback_State = Feedback_State;
            this.Order_Id = Order_Id;
            Set_POC();
        }
        
	public Feedback(){
            Set_POC();
	}

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }
        
        public void setF_Type(Feedback_Detector F_Type) {
            this.F_Type = F_Type;
        }

        public void setFeedback_Id(int Feedback_Id) {
            this.Feedback_Id = Feedback_Id;
        }

        public void setFeedbackDate(String Feedback_Date) {
            this.FeedbackDate = Feedback_Date;
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

        public String getFeedbackDate() {
            return FeedbackDate;
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

    @Override
    public String toString() {
        return "Feedback{" + ", Feedback_Id=" + Feedback_Id + ", FeedbackDate=" + FeedbackDate + ", Feedback_Type=" + Feedback_Type + ", Feedback_Desc=" + Feedback_Desc + ", Feedback_State=" + Feedback_State + ", Order_Id=" + Order_Id + ", rate=" + rate + '}';
    }

}